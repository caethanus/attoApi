package br.com.caethas.atto.atto.modules.evento.enums

enum class StatusEvento(val value: Int, val label: String) {
    AGENDADO(1, "Agendado"),
    REAGENDADO(2, "Reagendado"),
    EM_ANDAMENTO(3, "Em Andamento"),
    CONCLUIDO(4, "Concluído"),
    CANCELADO(5, "Cancelado"),
}