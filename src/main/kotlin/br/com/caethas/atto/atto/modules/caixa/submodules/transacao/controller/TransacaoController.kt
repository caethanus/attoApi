package br.com.caethas.atto.atto.modules.caixa.submodules.transacao.controller

import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.dto.TransacaoDto
import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.entity.TransacaoEntity
import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.repository.TransacaoRepository
import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.service.TransacaoService
import br.com.caethas.atto.atto.shared.base.BaseController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("transacoes")
class TransacaoController(service: TransacaoService) :
    BaseController<TransacaoEntity, TransacaoRepository, TransacaoDto>(
        service
    ) {
}