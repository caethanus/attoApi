package br.com.caethas.atto.atto.shared.base

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import java.util.UUID

abstract class BaseController<T : BaseEntity, R : BaseRepository<T>>(
    protected val service: BaseService<T, R>
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<T>> =
        ResponseEntity.ok(service.findAll())

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): ResponseEntity<T> =
        runCatching { service.findById(id) }
            .map { ResponseEntity.ok(it) }
            .getOrElse { ResponseEntity.notFound().build() }

    @PostMapping
    fun save(@RequestBody request: T): ResponseEntity<T> =
        ResponseEntity.status(201).body(service.upsert(request))

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody request: T): ResponseEntity<T> =
        ResponseEntity.ok(service.upsert(request))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID): ResponseEntity<Unit> =
        runCatching { service.deleteSoft(id) }
            .fold(
                onSuccess = { ResponseEntity.noContent().build() },
                onFailure = { ResponseEntity.notFound().build() }
            )
}