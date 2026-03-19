package br.com.caethas.atto.atto.modules.evento.service

import br.com.caethas.atto.atto.modules.evento.dto.EventoFromDto
import br.com.caethas.atto.atto.modules.evento.dto.EventoToDto
import br.com.caethas.atto.atto.modules.evento.entity.EventoEntity
import br.com.caethas.atto.atto.modules.evento.mapper.EventoMapper
import br.com.caethas.atto.atto.modules.evento.repository.EventoRepository
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service

@Service
class EventoService(repository: EventoRepository, mapper: EventoMapper) :
    BaseService<EventoEntity, EventoRepository, EventoFromDto, EventoToDto>(
        repository, mapper,
    )