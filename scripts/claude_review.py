import os
import requests
from anthropic import Anthropic

# Configurações de Ambiente
GITLAB_URL = os.getenv("CI_SERVER_URL")
PROJECT_ID = os.getenv("CI_PROJECT_ID")
MR_IID = os.getenv("CI_MERGE_REQUEST_IID")
GITLAB_TOKEN = os.getenv("GITLAB_TOKEN")
ANTHROPIC_API_KEY = os.getenv("CLAUDE_API_KEY")

def get_mr_diff():
    """Busca as mudanças (diffs) do Merge Request atual."""
    url = f"{GITLAB_URL}/api/v4/projects/{PROJECT_ID}/merge_requests/{MR_IID}/changes"
    headers = {"PRIVATE-TOKEN": GITLAB_TOKEN}
    response = requests.get(url, headers=headers)
    response.raise_for_status()
    return response.json()['changes']

def ask_claude(diff_text):
    """Envia o diff para o Claude 3.5 Sonnet."""
    client = Anthropic(api_key=ANTHROPIC_API_KEY)

    prompt = f"""Você é um Engenheiro de Software Sênior realizando um Code Review.
    Seja conciso, técnico e direto. Foque em:
    1. Bugs potenciais e falhas de segurança.
    2. Problemas de performance.
    3. Sugestões de legibilidade.

    Abaixo estão as mudanças no código:
    {diff_text}
    
    Responda em Markdown. Use tabelas ou tópicos para facilitar a leitura."""

    message = client.messages.create(
        model="claude-3-5-sonnet-20240620",
        max_tokens=2048,
        messages=[{"role": "user", "content": prompt}]
    )
    return "".join([block.text for block in message.content if block.type == 'text'])

def post_comment(feedback):
    """Posta o feedback do Claude como um comentário no MR."""
    url = f"{GITLAB_URL}/api/v4/projects/{PROJECT_ID}/merge_requests/{MR_IID}/notes"
    headers = {"PRIVATE-TOKEN": GITLAB_TOKEN}
    data = {"body": f"### 🤖 Claude AI Code Review\n\n{feedback}"}
    response = requests.post(url, headers=headers, json=data)
    response.raise_for_status()

if __name__ == "__main__":
    try:
        print("Iniciando Code Review com Claude...")
        changes = get_mr_diff()

        # Filtra arquivos irrelevantes e limita o tamanho para controle de custos
        diff_payload = ""
        for change in changes:
            if not any(ext in change['new_path'] for ext in ['.json', '.md', '.lock']):
                diff_payload += f"\nArquivo: {change['new_path']}\n{change['diff']}"

        if diff_payload:
            review = ask_claude(diff_payload[:15000]) # Limite preventivo de caracteres
            post_comment(review)
            print("Review postado com sucesso!")
        else:
            print("Nenhuma mudança relevante para revisar.")

    except Exception as e:
        print(f"Erro no workflow: {e}")