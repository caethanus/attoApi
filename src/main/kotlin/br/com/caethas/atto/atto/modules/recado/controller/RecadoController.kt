package br.com.caethas.atto.atto.modules.recado.controller

import br.com.caethas.atto.atto.modules.recado.dto.RecadoDto
import br.com.caethas.atto.atto.modules.recado.entity.RecadoEntity
import br.com.caethas.atto.atto.modules.recado.repository.RecadoRepository
import br.com.caethas.atto.atto.modules.recado.service.RecadoService
import br.com.caethas.atto.atto.shared.base.BaseController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("recados")
class RecadoController(service: RecadoService) : BaseController<RecadoEntity, RecadoRepository, RecadoDto>(service)