package br.com.caethas.atto.atto.modules.caixa.submodules.transacao.module

import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.mapper.TransacaoMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TransacaoModule {

    @Bean
    fun transacaoMapper(): TransacaoMapper {
        return TransacaoMapper()
    }
}