package br.com.caethas.atto.atto.modules.membro.repository

import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.shared.base.BaseRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MembroRepository : BaseRepository<MembroEntity> {
    /**
     * Busca membro pelo ID externo (membrosId) vindo do app
     */
    fun findByMembrosId(membrosId: UUID): Optional<MembroEntity>
}
