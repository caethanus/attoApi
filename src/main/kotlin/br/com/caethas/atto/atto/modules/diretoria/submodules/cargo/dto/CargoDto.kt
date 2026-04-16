package br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.dto

import br.com.caethas.atto.atto.shared.base.BaseDto
import jakarta.persistence.Column

data class CargoDto(
    val baseDto: BaseDto,
    var tituloCargo: String,
    var descricaoCargo: String?
)