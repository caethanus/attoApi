package br.com.caethas.atto.atto.shared.base

import br.com.caethas.atto.atto.shared.base.`interface`.IBaseService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import java.util.UUID

abstract class BaseController<T : BaseEntity, S : IBaseService<T>>(protected val service: S) {

    @GetMapping
    fun findAll(): List<T> = service.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): ResponseEntity<T> {
        val entity = try {
            service.findById(id)
        } catch (e: RuntimeException) {
            return ResponseEntity.notFound().build()
        }
        return ResponseEntity.ok(entity)
    }

    @PostMapping
    fun save(@RequestBody entity: T): ResponseEntity<T> = ResponseEntity.status(201).body(service.upsert(entity))

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody entity: T): ResponseEntity<T> {
        entity.id = id
        return ResponseEntity.ok(service.upsert(entity))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID): ResponseEntity<Unit> {
        return try {
            service.deleteSoft(id)
            ResponseEntity.noContent().build()
        } catch (e: RuntimeException) {
            ResponseEntity.notFound().build()
        }
    }
}