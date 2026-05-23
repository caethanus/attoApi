package br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.mapper

import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.dto.CargoDto
import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.entity.CargoEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import br.com.caethas.atto.atto.shared.base.BaseMapper


class CargoMapper : BaseMapper<CargoEntity, CargoDto>() {
    override fun toEntity(d: CargoDto): CargoEntity {
        return CargoEntity(
            tituloCargo = d.tituloCargo,
            descricaoCargo = d.descricaoCargo
        ).apply {
            id = d.baseDto.id
            criadoEm = d.baseDto.criadoEm
            atualizadoEm = d.baseDto.atualizadoEm
            deletadoEm = d.baseDto.deletadoEm
            sincronizadoEm = d.baseDto.sincronizadoEm
        }
    }

    override fun toDto(e: CargoEntity): CargoDto {
        return CargoDto(
            baseDto = BaseDto(
                id = e.id,
                criadoEm = e.criadoEm,
                atualizadoEm = e.atualizadoEm,
                deletadoEm = e.deletadoEm,
                sincronizadoEm = e.sincronizadoEm
            ),
            tituloCargo = e.tituloCargo,
            descricaoCargo = e.descricaoCargo
        )
    }

    override fun updateEntity(
        e: CargoEntity,
        d: CargoDto
    ): CargoEntity {

        e.criadoEm = d.baseDto.criadoEm
        e.criadoEm = d.baseDto.criadoEm
        e.deletadoEm = d.baseDto.deletadoEm
        e.sincronizadoEm = d.baseDto.sincronizadoEm

        e.tituloCargo = d.tituloCargo
        e.descricaoCargo = d.descricaoCargo

        return e
    }

}