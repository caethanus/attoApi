package br.com.caethas.atto.atto.modules.membro.dto

import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.modules.membro.enums.StatusAssociado
import br.com.caethas.atto.atto.shared.base.dto.BaseDto
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
import java.util.UUID

data class MembroDto(
    @JsonProperty("membrosId")
    override var id: UUID? = null,

    @JsonProperty("criadoEm")
    override var criadoEm: LocalDateTime? = null,

    override var atualizadoEm: LocalDateTime? = null,

    override var deletadoEm: LocalDateTime? = null,

    var nomeMembro: String,

    var emailMembro: String?,

    var contatoMembro: String?,

    var enderecoMembro: String?,

    var statusAssociado: Int,
) : BaseDto<MembroEntity>() {
    override fun toEntity() = MembroEntity(
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