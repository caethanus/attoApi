package br.com.caethas.atto.atto.modules.membro.dto

import br.com.caethas.atto.atto.modules.membro.enums.StatusAssociado
import br.com.caethas.atto.atto.modules.usuario.entity.UsuarioEntity
import br.com.caethas.atto.atto.shared.base.BaseDto

data class MembroDto(
    val baseDto: BaseDto,
    var usuario: UsuarioEntity,
    var nomeMembro: String,
    var emailMembro: String?,
    var contatoMembro: String?,
    var enderecoMembro: String?,
    var statusAssociado: StatusAssociado,
)