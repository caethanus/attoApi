package br.com.caethas.atto.atto.modules.sincronizacao.enums

import com.fasterxml.jackson.annotation.JsonCreator

enum class EndpointEnum(val value: Int, val label: String) {
        MEMBROS(0, "membros");

        companion object {
                @JsonCreator
                @JvmStatic
                fun fromLabel(label: String): EndpointEnum =
                        entries.find { it.label == label }
                                ?: throw IllegalArgumentException("Endpoint não encontrado: $label")
        }
}