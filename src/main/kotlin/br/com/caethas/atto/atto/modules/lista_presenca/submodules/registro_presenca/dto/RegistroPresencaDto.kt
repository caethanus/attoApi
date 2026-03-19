package br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.dto

import br.com.caethas.atto.atto.modules.lista_presenca.entity.ListaPresencaEntity
import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import java.time.LocalDateTime
import java.util.UUID

class RegistroPresencaFromDto(
    val membro: MembroEntity,
    val presente: Boolean,
    val listaPresenca: ListaPresencaEntity
) : BaseDto.FromDto()

class RegistroPresencaToDto(
    override val id: UUID?,
    override val criadoEm: LocalDateTime?,
    override val atualizadoEm: LocalDateTime?,
    override val deletadoEm: LocalDateTime?,
    override val sincronizadoEm: LocalDateTime?,
    val membro: MembroEntity,
    val presente: Boolean
) : BaseDto.ToDto(
    id, criadoEm, atualizadoEm, deletadoEm, sincronizadoEm
)