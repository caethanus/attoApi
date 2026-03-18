package br.com.caethas.atto.atto.modules.membro.dto

import br.com.caethas.atto.atto.modules.membro.enums.StatusAssociado
import br.com.caethas.atto.atto.modules.usuario.dto.UsuarioToDto
import br.com.caethas.atto.atto.modules.usuario.entity.UsuarioEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import java.time.LocalDateTime
import java.util.UUID

class MembroFromDto(
    val usuarioId: UUID,
    val nomeMembro: String,
    val emailMembro: String?,
    val contatoMembro: String?,
    val enderecoMembro: String?,
    val statusAssociado: StatusAssociado
) : BaseDto.FromDto()

data class MembroToDto(
    override val id: UUID,
    override val criadoEm: LocalDateTime,
    override val atualizadoEm: LocalDateTime?,
    override val deletadoEm: LocalDateTime?,
    override val sincronizadoEm: LocalDateTime?,
    val nomeMembro: String,
    val emailMembro: String?,
    val contatoMembro: String?,
    val enderecoMembro: String?,
    val statusAssociado: String,
    val usuario: UsuarioToDto


) : BaseDto.ToDto(id, criadoEm, atualizadoEm, deletadoEm, sincronizadoEm) {

}