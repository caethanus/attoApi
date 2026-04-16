package br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.mapper

import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.repository.CargoRepository
import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.dto.ParticipacaoGestaoDto
import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.entity.ParticipacaoGestaoEntity
import br.com.caethas.atto.atto.modules.membro.repository.MembroRepository
import br.com.caethas.atto.atto.shared.base.BaseDto
import br.com.caethas.atto.atto.shared.base.BaseMapper

class ParticipacaoGestaoMapper(
) : BaseMapper<ParticipacaoGestaoEntity, ParticipacaoGestaoDto>() {
    override fun toEntity(d: ParticipacaoGestaoDto): ParticipacaoGestaoEntity {
        return ParticipacaoGestaoEntity(
            membro = d.membro,
            cargo = d.cargo,
            dataEntrada = d.dataEntrada,
            dataSaida = d.dataSaida,
            gestao = d.gestao
        ).apply {
            id = d.baseDto.id
            criadoEm = d.baseDto.criadoEm
            atualizadoEm = d.baseDto.atualizadoEm
            deletadoEm = d.baseDto.deletadoEm
            sincronizadoEm = d.baseDto.sincronizadoEm
        }
    }

    override fun toDto(e: ParticipacaoGestaoEntity): ParticipacaoGestaoDto {
        return ParticipacaoGestaoDto(
            baseDto = BaseDto(
                id = e.id,
                criadoEm = e.criadoEm,
                atualizadoEm = e.atualizadoEm,
                deletadoEm = e.deletadoEm,
                sincronizadoEm = e.sincronizadoEm
            ),
            membro = e.membro,
            cargo = e.cargo,
            dataEntrada = e.dataEntrada,
            dataSaida = e.dataSaida,
            gestao = e.gestao
        )
    }

    override fun updateEntity(
        e: ParticipacaoGestaoEntity,
        d: ParticipacaoGestaoDto
    ): ParticipacaoGestaoEntity {

        e.criadoEm = d.baseDto.criadoEm
        e.criadoEm = d.baseDto.criadoEm
        e.deletadoEm = d.baseDto.deletadoEm
        e.sincronizadoEm = d.baseDto.sincronizadoEm

        e.membro = d.membro
        e.cargo = d.cargo
        e.dataEntrada = d.dataEntrada
        e.dataSaida = d.dataSaida

        return e
    }

}