package br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.service

import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.dto.RegistroPresencaFromDto
import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.dto.RegistroPresencaToDto
import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.entity.RegistroPresencaEntity
import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.mapper.RegistroPresencaMapper
import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.repository.RegistroPresencaRepository
import br.com.caethas.atto.atto.shared.base.BaseMapper
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service

@Service
class RegistroPresencaService(
    repository: RegistroPresencaRepository,
    mapper: RegistroPresencaMapper
) : BaseService<RegistroPresencaEntity, RegistroPresencaRepository, RegistroPresencaFromDto, RegistroPresencaToDto>(
    repository, mapper,
)