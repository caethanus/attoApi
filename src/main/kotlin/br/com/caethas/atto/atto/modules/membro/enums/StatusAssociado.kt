package br.com.caethas.atto.atto.modules.membro.enums

enum class StatusAssociado(val value: Int, val label: String) {
    ATIVO(1, "Ativo"),
    INATIVO(2, "Inativo"),
    DESLIGADO(3, "Desligado"),
    INADIMPLENTE(4, "Inadimplente")
}