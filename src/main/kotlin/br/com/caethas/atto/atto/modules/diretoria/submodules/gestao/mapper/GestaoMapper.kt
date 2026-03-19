package br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.mapper

import br.com.caethas.atto.atto.modules.diretoria.mapper.DiretoriaMapper
import br.com.caethas.atto.atto.modules.diretoria.repository.DiretoriaRepository
import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.dto.GestaoFromDto
import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.dto.GestaoToDto
import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.entity.GestaoEntity
import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.repository.ParticipacaoGestaoRepository
import br.com.caethas.atto.atto.shared.base.BaseMapper
import java.util.UUID

class GestaoMapper(
    private val participacaoGestaoRepository: ParticipacaoGestaoRepository,
) : BaseMapper<GestaoEntity, GestaoFromDto, GestaoToDto>() {
    override fun fromDto(request: GestaoFromDto): GestaoEntity {
        return GestaoEntity(
            dataInicioGestao = request.dataInicioGestao,
            dataFinalGestao = request.dataFinalGestao,
            membrosGestao = request.membrosGestao,
            diretoria = request.diretoria,
        )
    }

    override fun toDto(entity: GestaoEntity): GestaoToDto {
        return GestaoToDto(
            id = entity.id,
            criadoEm = entity.criadoEm,
            atualizadoEm = entity.atualizadoEm,
            deletadoEm = entity.deletadoEm,
            sincronizadoEm = entity.sincronizadoEm,
            dataInicioGestao = entity.dataInicioGestao,
            dataFinalGestao = entity.dataFinalGestao,
            membrosGestao = entity.membrosGestao,
        )
    }

}