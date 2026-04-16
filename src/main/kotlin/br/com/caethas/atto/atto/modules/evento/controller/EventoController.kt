package br.com.caethas.atto.atto.modules.evento.controller

import br.com.caethas.atto.atto.modules.evento.dto.EventoDto
import br.com.caethas.atto.atto.modules.evento.entity.EventoEntity
import br.com.caethas.atto.atto.modules.evento.repository.EventoRepository
import br.com.caethas.atto.atto.modules.evento.service.EventoService
import br.com.caethas.atto.atto.shared.base.BaseController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("eventos")
class EventoController(service: EventoService) :
    BaseController<EventoEntity, EventoRepository, EventoDto>(
        service
    )