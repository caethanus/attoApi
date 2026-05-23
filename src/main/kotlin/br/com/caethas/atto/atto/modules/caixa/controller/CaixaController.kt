package br.com.caethas.atto.atto.modules.caixa.controller

import br.com.caethas.atto.atto.modules.caixa.dto.CaixaDto
import br.com.caethas.atto.atto.modules.caixa.entity.CaixaEntity
import br.com.caethas.atto.atto.modules.caixa.repository.CaixaRepository
import br.com.caethas.atto.atto.modules.caixa.service.CaixaService
import br.com.caethas.atto.atto.shared.base.BaseController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("caixas")
class CaixaController(service: CaixaService) : BaseController<CaixaEntity, CaixaRepository, CaixaDto>(service)