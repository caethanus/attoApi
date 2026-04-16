package br.com.caethas.atto.atto.modules.evento.mapper

import br.com.caethas.atto.atto.modules.evento.dto.EventoDto
import br.com.caethas.atto.atto.modules.evento.entity.EventoEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import br.com.caethas.atto.atto.shared.base.BaseMapper

class EventoMapper : BaseMapper<EventoEntity, EventoDto>() {
    override fun toEntity(d: EventoDto): EventoEntity {
        return EventoEntity(
            tituloEvento = d.tituloEvento,
            descricaoEvento = d.descricaoEvento,
            dataHoraRealizacaoEvento = d.dataHoraRealizacaoEvento,
            dataHoraFinalizacaoEvento = d.dataHoraFinalizacaoEvento,
            localEvento = d.localEvento,
            quantidadeParticipantes = d.quantidadeParticipantes,
            statusEvento = d.statusEvento,
            caixa = d.caixa,
            listaPresenca = d.listaPresenca
        ).apply {
            id = d.baseDto.id
            criadoEm = d.baseDto.criadoEm
            atualizadoEm = d.baseDto.atualizadoEm
            deletadoEm = d.baseDto.deletadoEm
            sincronizadoEm = d.baseDto.sincronizadoEm
        }
    }

    override fun toDto(e: EventoEntity): EventoDto {
        return EventoDto(
            baseDto = BaseDto(
                id = e.id,
                criadoEm =e.criadoEm,
                atualizadoEm = e.atualizadoEm,
                deletadoEm = e.deletadoEm,
                sincronizadoEm = e.sincronizadoEm
            ),
            tituloEvento = e.tituloEvento,
            descricaoEvento = e.descricaoEvento,
            dataHoraRealizacaoEvento = e.dataHoraRealizacaoEvento,
            dataHoraFinalizacaoEvento = e.dataHoraFinalizacaoEvento,
            localEvento = e.localEvento,
            quantidadeParticipantes = e.quantidadeParticipantes,
            statusEvento = e.statusEvento,
            caixa = e.caixa,
            listaPresenca = e.listaPresenca
        )
    }

    override fun updateEntity(
        e: EventoEntity,
        d: EventoDto
    ): EventoEntity {
        e.criadoEm = d.baseDto.criadoEm
        e.criadoEm = d.baseDto.criadoEm
        e.deletadoEm = d.baseDto.deletadoEm
        e.sincronizadoEm = d.baseDto.sincronizadoEm

        e.tituloEvento = d.tituloEvento
        e.descricaoEvento = d.descricaoEvento
        e.dataHoraRealizacaoEvento = d.dataHoraRealizacaoEvento
        e.dataHoraFinalizacaoEvento = d.dataHoraFinalizacaoEvento
        e.localEvento = d.localEvento
        e.quantidadeParticipantes = d.quantidadeParticipantes
        e.statusEvento = d.statusEvento
        e.caixa = d.caixa
        e.listaPresenca = d.listaPresenca

        return e
    }

}