package br.com.caethas.atto.atto.shared.base

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import java.util.UUID

abstract class BaseController<T : BaseEntity, Req : BaseDto.FromDto, Res : BaseDto.ToDto>(
    protected val service: BaseService<T, *, Req, Res>
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<Res>> =
        ResponseEntity.ok(service.findAll())

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): ResponseEntity<Res> =
        runCatching { service.findById(id) }
            .map { ResponseEntity.ok(it) }
            .getOrElse { ResponseEntity.notFound().build() }

    @PostMapping
    fun save(@RequestBody request: Req): ResponseEntity<Res> =
        ResponseEntity.status(201).body(service.upsert(request))

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody request: Req): ResponseEntity<Res> =
        ResponseEntity.ok(service.upsert(request))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID): ResponseEntity<Unit> =
        runCatching { service.deleteSoft(id) }
            .fold(
                onSuccess = { ResponseEntity.noContent().build() },
                onFailure = { ResponseEntity.notFound().build() }
            )
}