package br.com.caethas.atto.atto.modules.recado.dto

import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import java.time.LocalDateTime
import java.util.UUID

class RecadoFromDto(
    val tituloString: String,
    val descricaoRecado: String,
    val autorRecado: MembroEntity,
    val recadoUrgente: Boolean
) : BaseDto.FromDto()

class RecadoToDto(
    override val id: UUID?,
    override val criadoEm: LocalDateTime?,
    override val atualizadoEm: LocalDateTime?,
    override val deletadoEm: LocalDateTime?,
    override val sincronizadoEm: LocalDateTime?,
    val tituloString: String,
    val descricaoRecado: String,
    val autorRecado: MembroEntity,
    val recadoUrgente: Boolean
) : BaseDto.ToDto(
    id, criadoEm, atualizadoEm, deletadoEm, sincronizadoEm

)