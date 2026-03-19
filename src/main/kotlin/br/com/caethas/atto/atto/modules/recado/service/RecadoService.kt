package br.com.caethas.atto.atto.modules.recado.service

import br.com.caethas.atto.atto.modules.recado.dto.RecadoFromDto
import br.com.caethas.atto.atto.modules.recado.dto.RecadoToDto
import br.com.caethas.atto.atto.modules.recado.entity.RecadoEntity
import br.com.caethas.atto.atto.modules.recado.repository.RecadoRepository
import br.com.caethas.atto.atto.shared.base.BaseMapper
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service

@Service
class RecadoService(repository: RecadoRepository, mapper: BaseMapper<RecadoEntity, RecadoFromDto, RecadoToDto>) :
    BaseService<RecadoEntity, RecadoRepository, RecadoFromDto, RecadoToDto>(
        repository, mapper,
    )