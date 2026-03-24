package br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.dto

import br.com.caethas.atto.atto.modules.diretoria.entity.DiretoriaEntity
import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.entity.ParticipacaoGestaoEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import java.time.LocalDateTime

data class GestaoDto(
    val baseDto: BaseDto,
    var dataInicioGestao: LocalDateTime,
    var dataFinalGestao: LocalDateTime?,
    var membrosGestao: MutableList<ParticipacaoGestaoEntity> = mutableListOf(),
    var diretoria: DiretoriaEntity
)