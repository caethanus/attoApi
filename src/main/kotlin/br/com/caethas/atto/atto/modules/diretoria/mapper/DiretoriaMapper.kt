package br.com.caethas.atto.atto.modules.diretoria.mapper

import br.com.caethas.atto.atto.modules.diretoria.dto.DiretoriaDto
import br.com.caethas.atto.atto.modules.diretoria.entity.DiretoriaEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import br.com.caethas.atto.atto.shared.base.BaseMapper

class DiretoriaMapper : BaseMapper<DiretoriaEntity, DiretoriaDto>() {
    override fun toEntity(d: DiretoriaDto): DiretoriaEntity {
        return DiretoriaEntity(
            nomeDiretoria = d.nomeDiretoria,
            informacoesDiretoria = d.informacoesDiretoria,
            emailDiretoria = d.emailDiretoria,
            contatoDiretoria = d.contatoDiretoria,
            gestoes = d.gestoes
        ).apply {
            id = d.baseDto.id
            criadoEm = d.baseDto.criadoEm
            atualizadoEm = d.baseDto.atualizadoEm
            deletadoEm = d.baseDto.deletadoEm
            sincronizadoEm = d.baseDto.sincronizadoEm
        }
    }

    override fun toDto(e: DiretoriaEntity): DiretoriaDto {
        return DiretoriaDto(
            baseDto = BaseDto(
                id = e.id,
                criadoEm = e.criadoEm,
                atualizadoEm = e.atualizadoEm,
                deletadoEm = e.deletadoEm,
                sincronizadoEm = e.sincronizadoEm
            ),
            nomeDiretoria = e.nomeDiretoria,
            informacoesDiretoria = e.informacoesDiretoria,
            emailDiretoria = e.emailDiretoria,
            contatoDiretoria = e.contatoDiretoria,
            gestoes = e.gestoes,
        )
    }

    override fun updateEntity(
        e: DiretoriaEntity,
        d: DiretoriaDto
    ): DiretoriaEntity {
        e.criadoEm = d.baseDto.criadoEm
        e.criadoEm = d.baseDto.criadoEm
        e.deletadoEm = d.baseDto.deletadoEm
        e.sincronizadoEm = d.baseDto.sincronizadoEm

        e.nomeDiretoria = d.nomeDiretoria
        e.informacoesDiretoria = d.informacoesDiretoria
        e.emailDiretoria = d.emailDiretoria
        e.contatoDiretoria = d.contatoDiretoria
        e.gestoes = d.gestoes

        return e
    }

}