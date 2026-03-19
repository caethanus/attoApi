package br.com.caethas.atto.atto.modules.recado.mapper

import br.com.caethas.atto.atto.modules.recado.dto.RecadoFromDto
import br.com.caethas.atto.atto.modules.recado.dto.RecadoToDto
import br.com.caethas.atto.atto.modules.recado.entity.RecadoEntity
import br.com.caethas.atto.atto.shared.base.BaseMapper

class RecadoMapper : BaseMapper<RecadoEntity, RecadoFromDto, RecadoToDto>() {
    override fun fromDto(request: RecadoFromDto): RecadoEntity {
        return RecadoEntity(
            tituloString = request.tituloString,
            descricaoRecado = request.descricaoRecado,
            autorRecado = request.autorRecado,
            recadoUrgente = request.recadoUrgente
        )
    }

    override fun toDto(entity: RecadoEntity): RecadoToDto {
        return RecadoToDto(
            id = entity.id,
            criadoEm = entity.criadoEm,
            atualizadoEm = entity.atualizadoEm,
            deletadoEm = entity.deletadoEm,
            sincronizadoEm = entity.sincronizadoEm,
            tituloString = entity.tituloString,
            descricaoRecado = entity.descricaoRecado,
            autorRecado = entity.autorRecado,
            recadoUrgente = entity.recadoUrgente
        )
    }
}