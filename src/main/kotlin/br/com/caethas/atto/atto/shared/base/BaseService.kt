package br.com.caethas.atto.atto.shared.base

import java.time.LocalDateTime
import java.util.UUID

abstract class BaseService<T : BaseEntity, R : BaseRepository<T>, Req : BaseDto.FromDto, Res : BaseDto.ToDto>(
    protected open val repository: R,
    protected open val mapper: BaseMapper<T, Req, Res>
) {

    open fun upsert(request: Req): Res {
        val entity = mapper.fromDto(request)

        if (entity.id == null) {
            entity.criadoEm = LocalDateTime.now()
        } else {
            entity.atualizadoEm = LocalDateTime.now()
        }

        return mapper.toDto(repository.save(entity))
    }

    open fun findById(id: UUID): Res =
        mapper.toDto(
            repository.findById(id).orElseThrow { RuntimeException("Entidade não encontrada") }
        )

    open fun findAll(): List<Res> =
        mapper.toDtoList(repository.findAll())

    open fun deleteSoft(id: UUID) {
        val entity = repository.findById(id).orElseThrow {
            RuntimeException("Entidade não encontrada para exclusão.")
        }
        entity.deletadoEm = LocalDateTime.now()
        repository.save(entity)
    }
}