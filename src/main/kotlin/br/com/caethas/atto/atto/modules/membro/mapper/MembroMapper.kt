package br.com.caethas.atto.atto.modules.membro.mapper

import br.com.caethas.atto.atto.modules.membro.dto.MembroDto
import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.modules.usuario.mapper.UsuarioMapper
import br.com.caethas.atto.atto.modules.usuario.repository.UsuarioRepository
import br.com.caethas.atto.atto.shared.base.BaseDto
import br.com.caethas.atto.atto.shared.base.BaseMapper

class MembroMapper(
    private val usuarioRepository: UsuarioRepository,
    private val usuarioMapper: UsuarioMapper
) : BaseMapper<MembroEntity, MembroDto>() {
    override fun toEntity(d: MembroDto): MembroEntity {
        return MembroEntity(
            usuario = d.usuario,
            nomeMembro = d.nomeMembro,
            emailMembro = d.emailMembro,
            contatoMembro = d.contatoMembro,
            enderecoMembro = d.enderecoMembro,
            statusAssociado = d.statusAssociado
        ).apply {
            id = d.baseDto.id
            criadoEm = d.baseDto.criadoEm
            atualizadoEm = d.baseDto.atualizadoEm
            deletadoEm = d.baseDto.deletadoEm
            sincronizadoEm = d.baseDto.sincronizadoEm
        }
    }

    override fun toDto(e: MembroEntity): MembroDto {
        return MembroDto(
            baseDto = BaseDto(
                id = e.id,
                criadoEm = e.criadoEm,
                atualizadoEm = e.atualizadoEm,
                deletadoEm = e.deletadoEm,
                sincronizadoEm = e.sincronizadoEm
            ),
            usuario = e.usuario,
            nomeMembro = e.nomeMembro,
            emailMembro = e.emailMembro,
            contatoMembro = e.contatoMembro,
            enderecoMembro = e.enderecoMembro,
            statusAssociado = e.statusAssociado
        )
    }

    override fun updateEntity(
        e: MembroEntity,
        d: MembroDto
    ): MembroEntity {

        e.usuario = d.usuario
        e.nomeMembro = d.nomeMembro
        e.emailMembro = d.emailMembro
        e.contatoMembro = e.contatoMembro
        e.enderecoMembro = e.enderecoMembro
        e.statusAssociado = d.statusAssociado

        e.criadoEm = d.baseDto.criadoEm
        e.atualizadoEm = d.baseDto.atualizadoEm
        e.deletadoEm = d.baseDto.deletadoEm
        e.sincronizadoEm = d.baseDto.sincronizadoEm
        return e
    }

}