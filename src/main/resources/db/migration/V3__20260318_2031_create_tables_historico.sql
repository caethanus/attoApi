-- Flyway Migration
-- Version: 3
-- Timestamp: 20260318_2031
-- Description: create_tables_historico
-- Created at: 2026-03-18T20:31:26.114255200

-- corrige o nullable de status_associado que está inconsistente
ALTER TABLE membros
    ALTER COLUMN status_associado SET NOT NULL;

ALTER TABLE membros
    RENAME COLUMN usuario_id TO membro_usuario_id;

-- cargos (independente)
CREATE TABLE cargos
(
    id              UUID PRIMARY KEY,
    criado_em       TIMESTAMP NOT NULL,
    atualizado_em   TIMESTAMP,
    deletado_em     TIMESTAMP,
    sincronizado_em TIMESTAMP,
    titulo_cargo    TEXT NOT NULL,
    descricao_cargo TEXT
);

-- diretorias (independente)
CREATE TABLE diretorias
(
    id                    UUID PRIMARY KEY,
    criado_em             TIMESTAMP NOT NULL,
    atualizado_em         TIMESTAMP,
    deletado_em           TIMESTAMP,
    sincronizado_em       TIMESTAMP,
    nome_diretoria        TEXT NOT NULL,
    informacoes_diretoria TEXT NOT NULL,
    email_diretoria       TEXT,
    contato_diretoria     TEXT
);

-- gestoes depende de diretorias
CREATE TABLE gestoes
(
    id                  UUID PRIMARY KEY,
    criado_em           TIMESTAMP NOT NULL,
    atualizado_em       TIMESTAMP,
    deletado_em         TIMESTAMP,
    sincronizado_em     TIMESTAMP,
    data_inicio_gestao  TIMESTAMP NOT NULL,
    data_final_gestao   TIMESTAMP,
    diretoria_gestao_id UUID,

    CONSTRAINT fk_gestao_diretoria
        FOREIGN KEY (diretoria_gestao_id) REFERENCES diretorias (id)
);

-- participacoes_gestao depende de membros, cargos e gestoes
CREATE TABLE participacoes_gestao
(
    id                            UUID PRIMARY KEY,
    criado_em                     TIMESTAMP NOT NULL,
    atualizado_em                 TIMESTAMP,
    deletado_em                   TIMESTAMP,
    sincronizado_em               TIMESTAMP,
    participacao_gestao_membro_id UUID      UNIQUE,
    participacao_gestao_cargo_id  UUID      NOT NULL,
    data_entrada                  TIMESTAMP NOT NULL,
    data_saida                    TIMESTAMP,

    CONSTRAINT fk_participacao_membro
        FOREIGN KEY (participacao_gestao_membro_id) REFERENCES membros (id),
    CONSTRAINT fk_participacao_cargo
        FOREIGN KEY (participacao_gestao_cargo_id) REFERENCES cargos (id),
);

