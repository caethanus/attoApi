package br.com.caethas.atto.atto.modules.caixa.module

import br.com.caethas.atto.atto.modules.caixa.mapper.CaixaMapper
import br.com.caethas.atto.atto.modules.caixa.repository.CaixaRepository
import br.com.caethas.atto.atto.modules.caixa.service.CaixaService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CaixaModule {

    @Bean
    fun caixaMapper(): CaixaMapper {
        return CaixaMapper()
    }

    @Bean
    fun caixaService(caixaRepository: CaixaRepository, caixaMapper: CaixaMapper): CaixaService {
        return CaixaService(
            repository = caixaRepository,
            mapper = caixaMapper
        )
    }
}