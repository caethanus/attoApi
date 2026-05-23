package br.com.caethas.atto.atto.modules.diretoria.dto

import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.entity.GestaoEntity
import br.com.caethas.atto.atto.shared.base.BaseDto

data class DiretoriaDto(
    val baseDto: BaseDto,
    var nomeDiretoria: String,
    var informacoesDiretoria: String,
    var emailDiretoria: String?,
    var contatoDiretoria: String?,
    var gestoes: MutableList<GestaoEntity> = mutableListOf()
)