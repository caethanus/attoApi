package br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.mapper

import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.repository.CargoRepository
import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.dto.ParticipacaoGestaoFromDto
import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.dto.ParticipacaoGestaoToDto
import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.entity.ParticipacaoGestaoEntity
import br.com.caethas.atto.atto.modules.membro.repository.MembroRepository
import br.com.caethas.atto.atto.shared.base.BaseMapper

class ParticipacaoGestaoMapper(
    private val membroRepository: MembroRepository,
    private val cargoRepository: CargoRepository
) : BaseMapper<ParticipacaoGestaoEntity, ParticipacaoGestaoFromDto, ParticipacaoGestaoToDto>() {
    override fun fromDto(request: ParticipacaoGestaoFromDto): ParticipacaoGestaoEntity {
        return ParticipacaoGestaoEntity(
            membro = membroRepository.findById(request.membroId).orElseThrow(),
            cargo = cargoRepository.findById(request.cargoId).orElseThrow(),
            dataEntrada = request.dataEntrada,
            dataSaida = request.dataSaida
        )
    }

    override fun toDto(entity: ParticipacaoGestaoEntity): ParticipacaoGestaoToDto {
        return ParticipacaoGestaoToDto(
            id = entity.id,
            criadoEm = entity.criadoEm,
            atualizadoEm = entity.atualizadoEm,
            deletadoEm = entity.deletadoEm,
            sincronizadoEm = entity.sincronizadoEm,
            membro = entity.membro,
            cargo = entity.cargo,
            dataEntrada = entity.dataEntrada,
            dataSaida = entity.dataSaida
        )
    }
}