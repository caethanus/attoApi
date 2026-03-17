package br.com.caethas.atto.atto.modules.membro.mapper

import br.com.caethas.atto.atto.modules.membro.dto.MembroFromDto
import br.com.caethas.atto.atto.modules.membro.dto.MembroToDto
import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.modules.membro.enums.StatusAssociado
import br.com.caethas.atto.atto.modules.usuario.mapper.UsuarioMapper
import br.com.caethas.atto.atto.modules.usuario.repository.UsuarioRepository
import br.com.caethas.atto.atto.shared.base.BaseMapper
import java.time.LocalDateTime
import java.util.UUID

class MembroMapper(
    private val usuarioRepository: UsuarioRepository,
    private val usuarioMapper: UsuarioMapper
) : BaseMapper<MembroEntity, MembroFromDto, MembroToDto>() {
    override fun fromDto(request: MembroFromDto): MembroEntity {
        return MembroEntity(
            usuario = usuarioRepository.findById(request.usuarioId).orElseThrow(),
            nomeMembro = request.nomeMembro,
            emailMembro = request.emailMembro,
            contatoMembro = request.contatoMembro,
            enderecoMembro = request.enderecoMembro,
            statusAssociado = request.statusAssociado
        )
    }

    override fun toDto(entity: MembroEntity): MembroToDto {
        return MembroToDto(
            id = entity.id ?: UUID.randomUUID(),
            criadoEm = entity.criadoEm ?: LocalDateTime.now(),
            atualizadoEm = entity.atualizadoEm,
            deletadoEm = entity.deletadoEm,
            sincronizadoEm = entity.sincronizadoEm,
            nomeMembro = entity.nomeMembro,
            emailMembro = entity.emailMembro,
            contatoMembro = entity.contatoMembro,
            enderecoMembro = entity.enderecoMembro,
            statusAssociado = entity.statusAssociado.toString(),
            usuario = usuarioMapper.toDto(entity.usuario)
        )
    }
}