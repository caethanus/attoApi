package br.com.caethas.atto.atto.modules.usuario.mapper

import br.com.caethas.atto.atto.modules.usuario.dto.UsuarioFromDto
import br.com.caethas.atto.atto.modules.usuario.dto.UsuarioToDto
import br.com.caethas.atto.atto.modules.usuario.entity.UsuarioEntity
import br.com.caethas.atto.atto.modules.usuario.enums.TipoUsuario
import br.com.caethas.atto.atto.shared.base.BaseMapper
import java.time.LocalDateTime
import java.util.UUID

class UsuarioMapper() : BaseMapper<UsuarioEntity, UsuarioFromDto, UsuarioToDto>() {
    override fun fromDto(request: UsuarioFromDto): UsuarioEntity {
        return UsuarioEntity(
            login = request.login,
            senha = request.senha,
            tipoUsuario = TipoUsuario.valueOf(request.tipoUsuario)
        )
    }

    override fun toDto(entity: UsuarioEntity): UsuarioToDto {
        return UsuarioToDto(
            id = entity.id ?: UUID.randomUUID(),
            criadoEm = entity.criadoEm ?: LocalDateTime.now(),
            atualizadoEm = entity.atualizadoEm,
            deletadoEm = entity.deletadoEm,
            sincronizadoEm = entity.sincronizadoEm,
            login = entity.login,
            tipoUsuario = entity.tipoUsuario.toString()
        )
    }
}