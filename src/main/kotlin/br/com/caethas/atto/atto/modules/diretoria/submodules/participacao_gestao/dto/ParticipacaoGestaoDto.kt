package br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.dto

import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.entity.CargoEntity
import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.entity.GestaoEntity
import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import java.time.LocalDateTime

data class ParticipacaoGestaoDto(
    val baseDto: BaseDto,
    var membro: MembroEntity,
    var cargo: CargoEntity,
    var dataEntrada: LocalDateTime,
    var dataSaida: LocalDateTime?,
    var gestao: GestaoEntity
)