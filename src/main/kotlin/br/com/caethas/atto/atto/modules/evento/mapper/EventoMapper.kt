package br.com.caethas.atto.atto.modules.evento.mapper

import br.com.caethas.atto.atto.modules.evento.dto.EventoFromDto
import br.com.caethas.atto.atto.modules.evento.dto.EventoToDto
import br.com.caethas.atto.atto.modules.evento.entity.EventoEntity
import br.com.caethas.atto.atto.shared.base.BaseMapper

class EventoMapper : BaseMapper<EventoEntity, EventoFromDto, EventoToDto>() {
    override fun fromDto(request: EventoFromDto): EventoEntity {
        return EventoEntity(
            tituloEvento = request.tituloEvento,
            descricaoEvento = request.descricaoEvento,
            dataHoraRealizacaoEvento = request.dataHoraRealizacaoEvento,
            dataHoraFinalizacaoEvento = request.dataHoraFinalEvento,
            localEvento = request.localEvento,
            quantidadeParticipantes = request.quantidadeParticipantes,
            statusEvento = request.statusEvento,
            caixa = request.caixa,
            listaPresenca = request.listaPresenca,
        )
    }

    override fun toDto(entity: EventoEntity): EventoToDto {
        return EventoToDto(
            id = entity.id,
            criadoEm = entity.criadoEm,
            atualizadoEm = entity.atualizadoEm,
            deletadoEm = entity.deletadoEm,
            sincronizadoEm = entity.sincronizadoEm,
            tituloEvento = entity.tituloEvento,
            descricaoEvento = entity.descricaoEvento,
            dataHoraRealizacaoEvento = entity.dataHoraRealizacaoEvento,
            dataHoraFinalEvento = entity.dataHoraFinalizacaoEvento,
            localEvento = entity.localEvento,
            quantidadeParticipantes = entity.quantidadeParticipantes,
            statusEvento = entity.statusEvento
        )
    }
}