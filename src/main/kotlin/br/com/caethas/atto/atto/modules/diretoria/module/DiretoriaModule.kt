package br.com.caethas.atto.atto.modules.diretoria.module

import br.com.caethas.atto.atto.modules.diretoria.repository.DiretoriaRepository
import br.com.caethas.atto.atto.modules.diretoria.service.DiretoriaService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DiretoriaModule {

    @Bean
    fun diretoriaService(
        diretoriaRepository: DiretoriaRepository
    ): DiretoriaService {
        return DiretoriaService(
            repository = diretoriaRepository
        )
    }
}