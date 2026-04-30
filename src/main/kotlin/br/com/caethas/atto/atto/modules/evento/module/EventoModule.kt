package br.com.caethas.atto.atto.modules.evento.module

import br.com.caethas.atto.atto.modules.evento.repository.EventoRepository
import br.com.caethas.atto.atto.modules.evento.service.EventoService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class EventoModule {

    @Bean
    fun eventoService(eventoRepository: EventoRepository): EventoService {
        return EventoService(eventoRepository)
    }
}