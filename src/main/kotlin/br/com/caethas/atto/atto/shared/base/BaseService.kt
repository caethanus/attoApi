package br.com.caethas.atto.atto.shared.base

import java.time.LocalDateTime
import java.util.UUID

abstract class BaseService<T : BaseEntity, R : BaseRepository<T>>(protected open val repository: R) {
    open fun upsert(entity: T): T {
        if (entity.id == null) {
            entity.criadoEm = LocalDateTime.now()
        } else {
            entity.atualizadoEm = LocalDateTime.now()
        }
        return repository.save(entity)
    }

    open fun findById(id: UUID): T =
        repository.findById(id).orElseThrow { RuntimeException("Entidade não encontrada") }

    open fun findAll(): List<T> = repository.findAll()

    open fun deleteSoft(id: UUID) {
        val entity = repository.findById(id).orElseThrow {
            RuntimeException("Entidade não encontrada para exclusão.")
        }
        entity.deletadoEm = LocalDateTime.now()
        repository.save(entity)
    }

}