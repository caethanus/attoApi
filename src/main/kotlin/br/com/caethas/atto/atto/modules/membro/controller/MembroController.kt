package br.com.caethas.atto.atto.modules.membro.controller

import br.com.caethas.atto.atto.modules.membro.dto.MembroDto
import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.modules.membro.repository.MembroRepository
import br.com.caethas.atto.atto.modules.membro.service.MembroService
import br.com.caethas.atto.atto.shared.base.BaseController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/membros")
class MembroController(service: MembroService) : BaseController<MembroEntity, MembroRepository, MembroDto>(service) {
}