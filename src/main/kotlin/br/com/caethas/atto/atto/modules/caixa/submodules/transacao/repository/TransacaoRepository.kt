package br.com.caethas.atto.atto.modules.caixa.submodules.transacao.repository

import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.entity.TransacaoEntity
import br.com.caethas.atto.atto.shared.base.BaseRepository
import org.springframework.stereotype.Repository

@Repository
interface TransacaoRepository : BaseRepository<TransacaoEntity>