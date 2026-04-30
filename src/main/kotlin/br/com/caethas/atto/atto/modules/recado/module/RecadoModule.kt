package br.com.caethas.atto.atto.modules.recado.module

import br.com.caethas.atto.atto.modules.recado.repository.RecadoRepository
import br.com.caethas.atto.atto.modules.recado.service.RecadoService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RecadoModule {

    @Bean
    fun recadoService(recadoRepository: RecadoRepository): RecadoService {
        return RecadoService(recadoRepository)
    }
}