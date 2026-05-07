package br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.module

import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.repository.GestaoRepository
import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.service.GestaoService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GestaoModule {

    @Bean
    fun gestaoService(
        gestaoRepository: GestaoRepository,
    ): GestaoService {
        return GestaoService(
            repository = gestaoRepository,
        )
    }
}