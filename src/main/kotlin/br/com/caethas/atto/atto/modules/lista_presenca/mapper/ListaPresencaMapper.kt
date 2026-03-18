package br.com.caethas.atto.atto.modules.lista_presenca.mapper

import br.com.caethas.atto.atto.modules.lista_presenca.dto.ListaPresencaFromDto
import br.com.caethas.atto.atto.modules.lista_presenca.dto.ListaPresencaToDto
import br.com.caethas.atto.atto.modules.lista_presenca.entity.ListaPresencaEntity
import br.com.caethas.atto.atto.shared.base.BaseMapper

class ListaPresencaMapper() : BaseMapper<ListaPresencaEntity, ListaPresencaFromDto, ListaPresencaToDto>() {
    override fun fromDto(request: ListaPresencaFromDto): ListaPresencaEntity {
        return ListaPresencaEntity(
            dataListaPresenca = request.dataListaPresenca,
            registrosPresenca = request.registrosPresenca
        )
    }

    override fun toDto(entity: ListaPresencaEntity): ListaPresencaToDto {
        return ListaPresencaToDto(
            id = entity.id,
            criadoEm = entity.criadoEm,
            atualizadoEm = entity.atualizadoEm,
            deletadoEm = entity.deletadoEm,
            sincronizadoEm = entity.sincronizadoEm,
            dataListaPresenca = entity.dataListaPresenca,
            registrosPresenca = entity.registrosPresenca
        )
    }
}