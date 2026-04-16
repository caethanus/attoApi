package br.com.caethas.atto.atto.modules.recado.mapper

import br.com.caethas.atto.atto.modules.recado.dto.RecadoDto
import br.com.caethas.atto.atto.modules.recado.entity.RecadoEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import br.com.caethas.atto.atto.shared.base.BaseMapper

class RecadoMapper : BaseMapper<RecadoEntity, RecadoDto>() {
    override fun toEntity(d: RecadoDto): RecadoEntity {
        return RecadoEntity(
            tituloString = d.tituloString,
            descricaoRecado = d.descricaoRecado,
            autorRecado = d.autorRecado,
            recadoUrgente = d.recadoUrgente
        ).apply {
            id = d.baseDto.id
            criadoEm = d.baseDto.criadoEm
            atualizadoEm = d.baseDto.atualizadoEm
            deletadoEm = d.baseDto.deletadoEm
            sincronizadoEm = d.baseDto.sincronizadoEm
        }
    }

    override fun toDto(e: RecadoEntity): RecadoDto {
        return RecadoDto(
            baseDto = BaseDto(
                id = e.id,
                criadoEm = e.criadoEm,
                atualizadoEm = e.atualizadoEm,
                deletadoEm = e.deletadoEm,
                sincronizadoEm = e.sincronizadoEm
            ),
            tituloString = e.tituloString,
            descricaoRecado = e.descricaoRecado,
            autorRecado = e.autorRecado,
            recadoUrgente = e.recadoUrgente
        )
    }

    override fun updateEntity(
        e: RecadoEntity,
        d: RecadoDto
    ): RecadoEntity {
        e.tituloString = d.tituloString
        e.descricaoRecado = d.descricaoRecado
        e.autorRecado = d.autorRecado
        e.recadoUrgente = d.recadoUrgente

        e.criadoEm = d.baseDto.criadoEm
        e.criadoEm = d.baseDto.criadoEm
        e.deletadoEm = d.baseDto.deletadoEm
        e.sincronizadoEm = d.baseDto.sincronizadoEm

        return e
    }

}