package br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.module

import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.repository.ParticipacaoGestaoRepository
import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.service.ParticipacaoGestaoService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ParticipacaoGestaoModule {

    @Bean
    fun participacaoGestaoService(
        participacaoGestaoRepository: ParticipacaoGestaoRepository,
    ): ParticipacaoGestaoService {
        return ParticipacaoGestaoService(
            repository = participacaoGestaoRepository,
        )
    }
}