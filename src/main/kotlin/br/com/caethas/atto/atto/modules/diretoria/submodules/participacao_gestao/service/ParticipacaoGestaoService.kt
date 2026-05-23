package br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.service

import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.dto.ParticipacaoGestaoDto
import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.entity.ParticipacaoGestaoEntity
import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.mapper.ParticipacaoGestaoMapper
import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.repository.ParticipacaoGestaoRepository
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service

@Service
class ParticipacaoGestaoService(
    repository: ParticipacaoGestaoRepository,
    mapper: ParticipacaoGestaoMapper
) :
    BaseService<ParticipacaoGestaoEntity, ParticipacaoGestaoRepository, ParticipacaoGestaoDto>(
        repository, mapper
    )