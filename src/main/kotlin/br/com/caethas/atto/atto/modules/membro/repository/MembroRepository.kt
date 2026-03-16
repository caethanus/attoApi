package br.com.caethas.atto.atto.modules.membro.repository

import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.shared.base.BaseRepository
import org.springframework.stereotype.Repository

@Repository
interface MembroRepository : BaseRepository<MembroEntity>