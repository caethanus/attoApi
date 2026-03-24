package br.com.caethas.atto.atto.modules.caixa.submodules.transacao.service

import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.dto.TransacaoDto
import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.dto.TransacaoFromDto
import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.dto.TransacaoToDto
import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.entity.TransacaoEntity
import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.mapper.TransacaoMapper
import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.repository.TransacaoRepository
import br.com.caethas.atto.atto.shared.base.BaseMapper
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service

@Service
class TransacaoService(
    repository: TransacaoRepository,
    mapper: TransacaoMapper
) : BaseService<TransacaoEntity, TransacaoRepository, TransacaoDto>(
    repository, mapper,
)