package br.com.caethas.atto.atto.modules.membro.service

import br.com.caethas.atto.atto.modules.membro.dto.MembroDto
import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.modules.membro.repository.MembroRepository
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service
import java.util.*

@Service
class MembroService(
    repository: MembroRepository
) : BaseService<MembroEntity, MembroRepository>(repository) {

    /**
     * Busca membro pelo ID externo (membrosId) vindo do app
     */
    fun findByMembrosId(membrosId: UUID): MembroEntity =
        (repository as MembroRepository).findByMembrosId(membrosId)
            .orElseThrow { RuntimeException("Membro não encontrado com membrosId: $membrosId") }
}
