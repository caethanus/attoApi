package br.com.caethas.atto.atto.modules.usuario.dto

import br.com.caethas.atto.atto.modules.usuario.enums.TipoUsuario
import br.com.caethas.atto.atto.shared.base.BaseDto

data class UsuarioDto(
    val baseDto: BaseDto,
    var login: String,
    var senha: String,
    var tipoUsuario: TipoUsuario
)