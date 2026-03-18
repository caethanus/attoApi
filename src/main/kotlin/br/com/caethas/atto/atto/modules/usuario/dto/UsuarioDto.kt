package br.com.caethas.atto.atto.modules.usuario.dto

import br.com.caethas.atto.atto.shared.base.BaseDto
import java.time.LocalDateTime
import java.util.UUID

data class UsuarioFromDto(
    val login: String,
    val senha: String,
    val tipoUsuario: String
) : BaseDto.FromDto()

data class UsuarioToDto(
    override val id: UUID,
    override val criadoEm: LocalDateTime,
    override val atualizadoEm: LocalDateTime?,
    override val deletadoEm: LocalDateTime?,
    override val sincronizadoEm: LocalDateTime?,
    val login: String,
    val tipoUsuario: String
) : BaseDto.ToDto(id, criadoEm, atualizadoEm, deletadoEm, sincronizadoEm)