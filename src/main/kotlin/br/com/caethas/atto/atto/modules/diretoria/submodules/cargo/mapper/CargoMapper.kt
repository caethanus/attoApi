package br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.mapper

import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.dto.CargoFromDto
import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.dto.CargoToDto
import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.entity.CargoEntity
import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.repository.CargoRepository
import br.com.caethas.atto.atto.shared.base.BaseMapper


class CargoMapper : BaseMapper<CargoEntity, CargoFromDto, CargoToDto>(){
    override fun fromDto(request: CargoFromDto): CargoEntity {
        return CargoEntity(
            tituloCargo = request.tituloCargo,
            descricaoCargo = request.descricaoCargo
        )
    }

    override fun toDto(entity: CargoEntity): CargoToDto {
        return CargoToDto(
            id = entity.id,
            criadoEm = entity.criadoEm,
            atualizadoEm = entity.atualizadoEm,
            deletadoEm = entity.deletadoEm,
            sincronizadoEm = entity.sincronizadoEm,
            tituloCargo = entity.tituloCargo,
            descricaoCargo = entity.descricaoCargo,
        )
    }
}