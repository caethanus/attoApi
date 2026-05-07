package br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.service

import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.entity.RegistroPresencaEntity
import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.repository.RegistroPresencaRepository
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service

@Service
class RegistroPresencaService(
    repository: RegistroPresencaRepository,
) : BaseService<RegistroPresencaEntity, RegistroPresencaRepository>(
    repository,
)