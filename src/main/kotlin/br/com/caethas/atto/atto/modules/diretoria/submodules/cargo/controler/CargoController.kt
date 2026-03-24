package br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.controler

import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.dto.CargoDto
import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.entity.CargoEntity
import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.repository.CargoRepository
import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.service.CargoService
import br.com.caethas.atto.atto.shared.base.BaseController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cargos")
class CargoController(service: CargoService) :
    BaseController<CargoEntity, CargoRepository, CargoDto>(service)