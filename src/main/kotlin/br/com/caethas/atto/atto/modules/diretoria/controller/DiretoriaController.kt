package br.com.caethas.atto.atto.modules.diretoria.controller

import br.com.caethas.atto.atto.modules.diretoria.dto.DiretoriaFromDto
import br.com.caethas.atto.atto.modules.diretoria.dto.DiretoriaToDto
import br.com.caethas.atto.atto.modules.diretoria.entity.DiretoriaEntity
import br.com.caethas.atto.atto.modules.diretoria.service.DiretoriaService
import br.com.caethas.atto.atto.shared.base.BaseController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/diretorias")
class DiretoriaController(
    service: DiretoriaService
) :
    BaseController<DiretoriaEntity, DiretoriaFromDto, DiretoriaToDto>(
        service
    )