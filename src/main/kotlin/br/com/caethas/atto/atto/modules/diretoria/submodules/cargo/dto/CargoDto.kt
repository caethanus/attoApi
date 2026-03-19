package br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.dto

import br.com.caethas.atto.atto.shared.base.BaseDto
import java.time.LocalDateTime
import java.util.UUID

data class CargoFromDto(
    val tituloCargo: String,
    val descricaoCargo: String
) : BaseDto.FromDto()

data class CargoToDto(
    override val id: UUID?,
    override val criadoEm: LocalDateTime?,
    override val atualizadoEm: LocalDateTime?,
    override val deletadoEm: LocalDateTime?,
    override val sincronizadoEm: LocalDateTime?,
    val tituloCargo: String,
    val descricaoCargo: String?

) : BaseDto.ToDto(id, criadoEm, atualizadoEm, deletadoEm, sincronizadoEm)
