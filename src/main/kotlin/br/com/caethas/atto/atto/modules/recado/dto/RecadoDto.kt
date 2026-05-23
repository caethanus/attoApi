package br.com.caethas.atto.atto.modules.recado.dto

import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.shared.base.BaseDto

class RecadoDto(
    val baseDto: BaseDto,
    var tituloString: String,
    var descricaoRecado: String,
    var autorRecado: MembroEntity,
    var recadoUrgente: Boolean
)