package br.com.caethas.atto.atto.modules.diretoria.module

import br.com.caethas.atto.atto.modules.diretoria.mapper.DiretoriaMapper
import br.com.caethas.atto.atto.modules.diretoria.repository.DiretoriaRepository
import br.com.caethas.atto.atto.modules.diretoria.service.DiretoriaService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DiretoriaModule {

    @Bean
    fun diretoriaMapper(): DiretoriaMapper {
        return DiretoriaMapper()
    }

    @Bean
    fun diretoriaService(
        diretoriaRepository: DiretoriaRepository,
        diretoriaMapper: DiretoriaMapper
    ): DiretoriaService {
        return DiretoriaService(
            repository = diretoriaRepository,
            mapper = diretoriaMapper
        )
    }
}