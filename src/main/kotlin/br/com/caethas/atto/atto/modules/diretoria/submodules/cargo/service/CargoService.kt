package br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.service

import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.dto.CargoFromDto
import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.dto.CargoToDto
import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.entity.CargoEntity
import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.mapper.CargoMapper
import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.repository.CargoRepository
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service

@Service
class CargoService(override val repository: CargoRepository, override val mapper: CargoMapper) :
    BaseService<CargoEntity, CargoRepository, CargoFromDto, CargoToDto>(repository, mapper)