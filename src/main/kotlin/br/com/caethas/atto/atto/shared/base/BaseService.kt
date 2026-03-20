package br.com.caethas.atto.atto.shared.base

import java.time.LocalDateTime
import java.util.UUID

abstract class BaseService<T : BaseEntity, R : BaseRepository<T>, D>(
    protected open val repository: R,
    protected open val mapper: BaseMapper<T, D>
) {

    open fun upsert(dto: D): D {
        val entity = mapper.toEntity(dto)

        if (entity.id == null) {
            entity.criadoEm = LocalDateTime.now()
        } else {
            entity.atualizadoEm = LocalDateTime.now()
        }

        return mapper.toDto(repository.save(entity))
    }

    open fun findById(id: UUID): D =
        mapper.toDto(
            repository.findById(id).orElseThrow { RuntimeException("Entidade não encontrada") }
        )

    open fun findAll(): List<D> =
        mapper.toDtoList(repository.findAll())

    open fun deleteSoft(id: UUID) {
        val entity = repository.findById(id).orElseThrow {
            RuntimeException("Entidade não encontrada para exclusão.")
        }
        entity.deletadoEm = LocalDateTime.now()
        repository.save(entity)
    }
}