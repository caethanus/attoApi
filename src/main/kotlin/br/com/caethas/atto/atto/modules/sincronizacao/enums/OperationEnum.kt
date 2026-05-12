package br.com.caethas.atto.atto.modules.sincronizacao.enums

import com.fasterxml.jackson.annotation.JsonCreator

enum class OperationEnum(val value: Int, val label: String) {
    CREATE(0, "Create"),
    UPDATE(1, "Update"),
    DELETE(2, "Delete");

    companion object {
        @JsonCreator
        @JvmStatic
        fun fromLabel(label: String): OperationEnum =
            entries.find { it.label.equals(label, ignoreCase = true) }
                ?: throw IllegalArgumentException("Operação desconhecida: $label")
    }
}