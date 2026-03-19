package br.com.caethas.atto.atto.modules.evento.module

import br.com.caethas.atto.atto.modules.evento.mapper.EventoMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class EventoModule {

    @Bean
    fun eventoMapper(): EventoMapper {
        return EventoMapper()
    }
}