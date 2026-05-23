package br.com.caethas.atto.atto.modules.usuario.mapper

import br.com.caethas.atto.atto.modules.usuario.dto.UsuarioDto
import br.com.caethas.atto.atto.modules.usuario.entity.UsuarioEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import br.com.caethas.atto.atto.shared.base.BaseMapper

class UsuarioMapper : BaseMapper<UsuarioEntity, UsuarioDto>() {

    override fun toEntity(d: UsuarioDto): UsuarioEntity {
        return UsuarioEntity(
            login = d.login,
            senha = d.senha,
            tipoUsuario = d.tipoUsuario
        ).apply {
            id = d.baseDto.id
            criadoEm = d.baseDto.criadoEm
            atualizadoEm = d.baseDto.atualizadoEm
            deletadoEm = d.baseDto.deletadoEm
            sincronizadoEm = d.baseDto.sincronizadoEm
        }
    }

    override fun toDto(e: UsuarioEntity): UsuarioDto {
        return UsuarioDto(
            baseDto = BaseDto(
                id = e.id,
                criadoEm = e.criadoEm,
                atualizadoEm = e.atualizadoEm,
                deletadoEm = e.deletadoEm,
                sincronizadoEm = e.sincronizadoEm
            ),
            login = e.login,
            senha = e.senha, // ⚠️ evitar expor
            tipoUsuario = e.tipoUsuario
        )
    }

    override fun updateEntity(
        e: UsuarioEntity,
        d: UsuarioDto
    ): UsuarioEntity {

        e.login = d.login
        e.senha = d.senha
        e.tipoUsuario = d.tipoUsuario

        e.criadoEm = d.baseDto.criadoEm
        e.atualizadoEm = d.baseDto.atualizadoEm
        e.deletadoEm = d.baseDto.deletadoEm
        e.sincronizadoEm = d.baseDto.sincronizadoEm

        return e
    }
}