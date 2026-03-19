package br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.controller

import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.dto.RegistroPresencaFromDto
import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.dto.RegistroPresencaToDto
import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.entity.RegistroPresencaEntity
import br.com.caethas.atto.atto.shared.base.BaseController
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("registros_presenca")
class RegistroPresencaController(service: BaseService<RegistroPresencaEntity, *, RegistroPresencaFromDto, RegistroPresencaToDto>) :
    BaseController<RegistroPresencaEntity, RegistroPresencaFromDto, RegistroPresencaToDto>(
        service

    )