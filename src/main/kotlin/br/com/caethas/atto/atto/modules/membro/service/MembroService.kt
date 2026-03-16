package br.com.caethas.atto.atto.modules.membro.service

import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.modules.membro.repository.MembroRepository
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service

@Service
class MembroService(override val repository: MembroRepository) :
    BaseService<MembroEntity, MembroRepository>(repository) {
}