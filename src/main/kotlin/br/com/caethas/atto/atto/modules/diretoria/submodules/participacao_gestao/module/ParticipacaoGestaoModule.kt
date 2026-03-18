package br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.module

import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.repository.CargoRepository
import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.mapper.ParticipacaoGestaoMapper
import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.repository.ParticipacaoGestaoRepository
import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.service.ParticipacaoGestaoService
import br.com.caethas.atto.atto.modules.membro.repository.MembroRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ParticipacaoGestaoModule {

    @Bean
    fun participacaoGestaoMapper(
        membroRepository: MembroRepository,
        cargoRepository: CargoRepository
    ): ParticipacaoGestaoMapper {
        return ParticipacaoGestaoMapper(
            membroRepository = membroRepository,
            cargoRepository = cargoRepository
        )
    }

    @Bean
    fun participacaoGestaoService(
        participacaoGestaoRepository: ParticipacaoGestaoRepository,
        participacaoGestaoMapper: ParticipacaoGestaoMapper
    ): ParticipacaoGestaoService {
        return ParticipacaoGestaoService(
            repository = participacaoGestaoRepository,
            mapper = participacaoGestaoMapper
        )
    }
}