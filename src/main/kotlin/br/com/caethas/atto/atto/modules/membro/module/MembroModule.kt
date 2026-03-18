package br.com.caethas.atto.atto.modules.membro.module

import br.com.caethas.atto.atto.modules.membro.repository.MembroRepository
import br.com.caethas.atto.atto.modules.membro.service.MembroService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MembroModule {

    @Bean
    fun membroService(membroRepository: MembroRepository): MembroService {
        return MembroService(membroRepository)
    }
}