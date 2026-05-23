package br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.controller

import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.dto.RegistroPresencaDto
import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.entity.RegistroPresencaEntity
import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.repository.RegistroPresencaRepository
import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.service.RegistroPresencaService
import br.com.caethas.atto.atto.shared.base.BaseController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("registros_presenca")
class RegistroPresencaController(service: RegistroPresencaService) :
    BaseController<RegistroPresencaEntity, RegistroPresencaRepository, RegistroPresencaDto>(
        service

    )