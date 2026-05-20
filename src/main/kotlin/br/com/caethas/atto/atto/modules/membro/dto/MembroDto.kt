package br.com.caethas.atto.atto.modules.membro.dto

import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.modules.membro.enums.StatusAssociado
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
import java.util.UUID

data class MembroDto(
    @JsonProperty("id")
    val id: UUID?, // ID interno gerado pelo framework

    @JsonProperty("membrosId")
    val membrosId: UUID?, // ID externo vindo do app

    val nomeMembro: String,

    val emailMembro: String?,

    val contatoMembro: String?,

    val enderecoMembro: String?,

    val statusAssociado: Int,

    @JsonProperty("criadoEm")
    val criadoEm: LocalDateTime? = null,

    val atualizadoEm: LocalDateTime? = null,

    val deletadoEm: LocalDateTime? = null,
) {
    fun toEntity(): MembroEntity = MembroEntity(
        membrosId = membrosId,
        nomeMembro = nomeMembro,
        emailMembro = emailMembro,
        contatoMembro = contatoMembro,
        enderecoMembro = enderecoMembro,
        statusAssociado = StatusAssociado.fromValue(statusAssociado),
    )
}