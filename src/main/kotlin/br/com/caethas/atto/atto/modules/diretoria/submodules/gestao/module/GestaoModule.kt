package br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.module

import br.com.caethas.atto.atto.modules.diretoria.repository.DiretoriaRepository
import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.mapper.GestaoMapper
import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.repository.GestaoRepository
import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.service.GestaoService
import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.repository.ParticipacaoGestaoRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GestaoModule {

    @Bean
    fun gestaoMapper(
        participacaoGestaoRepository: ParticipacaoGestaoRepository,
        diretoriaRepository: DiretoriaRepository
    ): GestaoMapper {
        return GestaoMapper(
            participacaoGestaoRepository = participacaoGestaoRepository,
        )
    }

    @Bean
    fun gestaoService(
        gestaoRepository: GestaoRepository,
        gestaoMapper: GestaoMapper
    ): GestaoService {
        return GestaoService(
            repository = gestaoRepository,
            mapper = gestaoMapper
        )
    }
}