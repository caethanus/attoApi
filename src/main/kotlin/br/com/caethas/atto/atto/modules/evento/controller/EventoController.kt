package br.com.caethas.atto.atto.modules.evento.controller

import br.com.caethas.atto.atto.modules.evento.dto.EventoFromDto
import br.com.caethas.atto.atto.modules.evento.dto.EventoToDto
import br.com.caethas.atto.atto.modules.evento.entity.EventoEntity
import br.com.caethas.atto.atto.shared.base.BaseController
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("eventos")
class EventoController(service: BaseService<EventoEntity, *, EventoFromDto, EventoToDto>) :
    BaseController<EventoEntity, EventoFromDto, EventoToDto>(
        service
    ) {
}