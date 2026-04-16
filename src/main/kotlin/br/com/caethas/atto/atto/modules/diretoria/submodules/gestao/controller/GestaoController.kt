package br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.controller

import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.dto.GestaoDto
import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.entity.GestaoEntity
import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.repository.GestaoRepository
import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.service.GestaoService
import br.com.caethas.atto.atto.shared.base.BaseController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/gestoes")
class GestaoController(service: GestaoService) : BaseController<GestaoEntity, GestaoRepository, GestaoDto>(service) {
}