package br.com.caethas.atto.atto.modules.caixa.module

import br.com.caethas.atto.atto.modules.caixa.mapper.CaixaMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CaixaModule {

    @Bean
    fun caixaMapper(): CaixaMapper {
        return CaixaMapper()
    }
}