package br.com.caethas.atto.atto.modules.recado.module

import br.com.caethas.atto.atto.modules.recado.mapper.RecadoMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RecadoModule {

    @Bean
    fun recadoMapper(): RecadoMapper {
        return RecadoMapper()
    }
}