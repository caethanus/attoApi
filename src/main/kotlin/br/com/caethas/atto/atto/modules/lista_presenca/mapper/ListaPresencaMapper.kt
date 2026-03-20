package br.com.caethas.atto.atto.modules.lista_presenca.mapper

import ListaPresencaDto
import br.com.caethas.atto.atto.modules.lista_presenca.entity.ListaPresencaEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import br.com.caethas.atto.atto.shared.base.BaseMapper

class ListaPresencaMapper() : BaseMapper<ListaPresencaEntity, ListaPresencaDto>() {
    override fun toEntity(d: ListaPresencaDto): ListaPresencaEntity {
        return ListaPresencaEntity(
            dataListaPresenca = d.dataListaPresenca,
            registrosPresenca = d.registrosPresenca
        ).apply {
            id = d.baseDto.id
            criadoEm = d.baseDto.criadoEm
            atualizadoEm = d.baseDto.atualizadoEm
            deletadoEm = d.baseDto.deletadoEm
            sincronizadoEm = d.baseDto.sincronizadoEm
        }
    }

    override fun toDto(e: ListaPresencaEntity): ListaPresencaDto {
        return ListaPresencaDto(
            baseDto = BaseDto(
                id = e.id,
                criadoEm = e.criadoEm,
                atualizadoEm = e.atualizadoEm,
                deletadoEm = e.deletadoEm,
                sincronizadoEm = e.atualizadoEm
            ),
            dataListaPresenca = e.dataListaPresenca,
            registrosPresenca = e.registrosPresenca
        )
    }

    override fun updateEntity(
        e: ListaPresencaEntity,
        d: ListaPresencaDto
    ): ListaPresencaEntity {

        e.dataListaPresenca = d.dataListaPresenca
        e.registrosPresenca = d.registrosPresenca

        e.criadoEm = d.baseDto.criadoEm
        e.criadoEm = d.baseDto.criadoEm
        e.deletadoEm = d.baseDto.deletadoEm
        e.sincronizadoEm = d.baseDto.sincronizadoEm

        return e
    }

}