package br.com.caethas.atto.atto.modules.membro.enums

import com.fasterxml.jackson.annotation.JsonCreator

enum class StatusAssociado(val value: Int, val label: String) {
    ATIVO(0, "Ativo"),
    INATIVO(1, "Inativo"),
    DESLIGADO(2, "Desligado"),
    INADIMPLENTE(3, "Inadimplente");

    companion object {
        fun fromValue(value: Int): StatusAssociado =
            entries.find { it.value == value }
                ?: throw IllegalArgumentException("Status desconhecido: $value")
    }
}