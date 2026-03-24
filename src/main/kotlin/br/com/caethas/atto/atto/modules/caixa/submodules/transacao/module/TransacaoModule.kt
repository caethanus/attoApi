package br.com.caethas.atto.atto.modules.caixa.submodules.transacao.module

import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.mapper.TransacaoMapper
import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.service.TransacaoService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TransacaoModule {

    @Bean
    fun transacaoMapper(): TransacaoMapper {
        return TransacaoMapper()
    }
    
    @Bean
    fun transacaoService() : TransacaoService {
        return TransacaoService(
            repository = ,
            mapper = 
        )
    }
}