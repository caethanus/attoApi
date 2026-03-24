package br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.mapper

import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.dto.GestaoDto
import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.entity.GestaoEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import br.com.caethas.atto.atto.shared.base.BaseMapper

class GestaoMapper() : BaseMapper<GestaoEntity, GestaoDto>() {
    override fun toEntity(d: GestaoDto): GestaoEntity {
        return GestaoEntity(
            dataInicioGestao = d.dataInicioGestao,
            dataFinalGestao = d.dataFinalGestao,
            membrosGestao = d.membrosGestao,
            diretoria = d.diretoria
        ).apply {
            id = d.baseDto.id
            criadoEm = d.baseDto.criadoEm
            atualizadoEm = d.baseDto.atualizadoEm
            deletadoEm = d.baseDto.deletadoEm
            sincronizadoEm = d.baseDto.sincronizadoEm
        }
    }

    override fun toDto(e: GestaoEntity): GestaoDto {
        return GestaoDto(
            baseDto = BaseDto(
                id = e.id,
                criadoEm = e.criadoEm,
                atualizadoEm = e.atualizadoEm,
                deletadoEm = e.deletadoEm,
                sincronizadoEm = e.sincronizadoEm
            ),
            dataInicioGestao = e.dataInicioGestao,
            dataFinalGestao = e.dataFinalGestao,
            membrosGestao = e.membrosGestao,
            diretoria = e.diretoria
        )
    }

    override fun updateEntity(
        e: GestaoEntity,
        d: GestaoDto
    ): GestaoEntity {

        e.criadoEm = d.baseDto.criadoEm
        e.criadoEm = d.baseDto.criadoEm
        e.deletadoEm = d.baseDto.deletadoEm
        e.sincronizadoEm = d.baseDto.sincronizadoEm

        e.dataInicioGestao = d.dataInicioGestao
        e.dataFinalGestao = d.dataFinalGestao
        e.membrosGestao = d.membrosGestao
        e.diretoria = d.diretoria

        return e
    }
}