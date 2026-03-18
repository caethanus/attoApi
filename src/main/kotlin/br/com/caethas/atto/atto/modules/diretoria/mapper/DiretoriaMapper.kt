package br.com.caethas.atto.atto.modules.diretoria.mapper

import br.com.caethas.atto.atto.modules.diretoria.dto.DiretoriaFromDto
import br.com.caethas.atto.atto.modules.diretoria.dto.DiretoriaToDto
import br.com.caethas.atto.atto.modules.diretoria.entity.DiretoriaEntity
import br.com.caethas.atto.atto.shared.base.BaseMapper

class DiretoriaMapper : BaseMapper<DiretoriaEntity, DiretoriaFromDto, DiretoriaToDto>() {
    override fun fromDto(request: DiretoriaFromDto): DiretoriaEntity {
        return DiretoriaEntity(
            nomeDiretoria = request.nomeDiretoria,
            informacoesDiretoria = request.informacoesDiretoria,
            emailDiretoria = request.emailDiretoria,
            contatoDiretoria = request.contatoDiretoria,
            gestoes = request.gestoes
        )
    }

    override fun toDto(entity: DiretoriaEntity): DiretoriaToDto {
        return DiretoriaToDto(
            id = entity.id,
            criadoEm = entity.criadoEm,
            atualizadoEm = entity.atualizadoEm,
            deletadoEm = entity.deletadoEm,
            sincronizadoEm = entity.sincronizadoEm,
            nomeDiretoria = entity.nomeDiretoria,
            informacoesDiretoria = entity.informacoesDiretoria,
            emailDiretoria = entity.emailDiretoria,
            contatoDiretoria = entity.contatoDiretoria,
            gestao = entity.gestoes
        )
    }
}