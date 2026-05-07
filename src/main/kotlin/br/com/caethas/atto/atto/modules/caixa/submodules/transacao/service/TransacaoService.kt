package br.com.caethas.atto.atto.modules.caixa.submodules.transacao.service

import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.entity.TransacaoEntity
import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.repository.TransacaoRepository
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service

@Service
class TransacaoService(
    repository: TransacaoRepository,
) : BaseService<TransacaoEntity, TransacaoRepository>(
    repository,
)