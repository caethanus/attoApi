package br.com.caethas.atto.atto.modules.evento.service

import br.com.caethas.atto.atto.modules.evento.entity.EventoEntity
import br.com.caethas.atto.atto.modules.evento.repository.EventoRepository
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service

@Service
class EventoService(repository: EventoRepository) :
    BaseService<EventoEntity, EventoRepository>(repository)
