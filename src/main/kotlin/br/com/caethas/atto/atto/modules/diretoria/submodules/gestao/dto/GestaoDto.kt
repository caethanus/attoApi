package br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.dto

import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.entity.ParticipacaoGestaoEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import java.time.LocalDateTime
import java.util.UUID

data class GestaoFromDto(
    val dataInicioGestao: LocalDateTime,
    val dataFinalGestao: LocalDateTime?,
    val membrosGestao: MutableList<ParticipacaoGestaoEntity>,
) : BaseDto.FromDto()

data class GestaoToDto(
    override val id: UUID?,
    override val criadoEm: LocalDateTime?,
    override val atualizadoEm: LocalDateTime?,
    override val deletadoEm: LocalDateTime?,
    override val sincronizadoEm: LocalDateTime?,
    val dataInicioGestao: LocalDateTime,
    val dataFinalGestao: LocalDateTime?,
    val membrosGestao: MutableList<ParticipacaoGestaoEntity>,
) : BaseDto.ToDto(
    id,
    criadoEm,
    atualizadoEm,
    deletadoEm,
    sincronizadoEm,
)