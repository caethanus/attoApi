package br.com.caethas.atto.atto.modules.caixa.submodules.transacao.enums

enum class TipoTransacao(val value: Int, val label: String) {
    ENTRADA(1, "Entrada"),
    SAIDA(2, "Saída")
}