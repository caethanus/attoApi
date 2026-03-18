package br.com.caethas.atto.atto.modules.lista_presenca.dto

import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.entity.RegistroPresencaEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import java.time.LocalDateTime
import java.util.UUID

class ListaPresencaFromDto(
    val dataListaPresenca: LocalDateTime,
    val registrosPresenca: MutableList<RegistroPresencaEntity>
) : BaseDto.FromDto()

class ListaPresencaToDto(
    override val id: UUID?,
    override val criadoEm: LocalDateTime?,
    override val atualizadoEm: LocalDateTime?,
    override val deletadoEm: LocalDateTime?,
    override val sincronizadoEm: LocalDateTime?,
    val dataListaPresenca: LocalDateTime,
    val registrosPresenca: MutableList<RegistroPresencaEntity>
) : BaseDto.ToDto(id, criadoEm, atualizadoEm, deletadoEm, sincronizadoEm)