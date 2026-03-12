package br.com.caethas.atto.atto.shared.base

import br.com.caethas.atto.atto.shared.base.`interface`.IBaseService
import java.time.LocalDateTime
import java.util.UUID

abstract class BaseService<T : BaseEntity, R : BaseRepository<T>>(protected val repository: R) : IBaseService<T> {
    override fun upsert(entity: T): T {
        if (entity.id == null) {
            entity.id = UUID.randomUUID()
            entity.criadoEm = LocalDateTime.now()
        }
        entity.atualizadoEm = LocalDateTime.now()
        return repository.save(entity)
    }

    override fun findById(id: UUID): T =
        repository.findById(id).orElseThrow { RuntimeException("Entidade não encontrada") }

    override fun findAll(): List<T> = repository.findAll()

    override fun deleteSoft(id: UUID) {
        val entity = repository.findById(id).orElseThrow()
        entity.deletadoEm = LocalDateTime.now()
        repository.save(entity)
    }

}