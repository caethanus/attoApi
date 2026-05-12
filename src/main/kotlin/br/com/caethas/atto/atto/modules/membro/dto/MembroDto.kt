package br.com.caethas.atto.atto.modules.membro.dto

import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.modules.membro.enums.StatusAssociado
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
import java.util.UUID

data class MembroDto(
    @JsonProperty("id_membros")
    var id: UUID?,

    @JsonProperty("criadoEm")
    var criadoEm: LocalDateTime?,

    var atualizadoEm: LocalDateTime?,

    var deletadoEm: LocalDateTime?,

    var nomeMembro: String,

    var emailMembro: String?,

    var contatoMembro: String?,

    var enderecoMembro: String?,

    var statusAssociado: Int,
) {
    fun toEntity() = MembroEntity(
        nomeMembro = this.nomeMembro,
        emailMembro = this.emailMembro,
        contatoMembro = this.contatoMembro,
        enderecoMembro = this.enderecoMembro,
        statusAssociado = StatusAssociado.fromValue(this.statusAssociado),
    ).also {
        it.id = this.id
        it.criadoEm = this.criadoEm
        it.atualizadoEm = this.atualizadoEm
        it.deletadoEm = this.deletadoEm
    }
}