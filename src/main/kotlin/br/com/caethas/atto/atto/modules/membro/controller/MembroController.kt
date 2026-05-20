package br.com.caethas.atto.atto.modules.membro.controller

import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.modules.membro.repository.MembroRepository
import br.com.caethas.atto.atto.modules.membro.service.MembroService
import br.com.caethas.atto.atto.shared.base.BaseController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/membros")
class MembroController(service: MembroService) : BaseController<MembroEntity, MembroRepository>(service) {

    private val membroService = service

    /**
     * Busca membro pelo ID externo (membrosId)
     * GET /membros/externos/{membrosId}
     */
    @GetMapping("/externos/{membrosId}")
    fun findByMembrosId(@PathVariable membrosId: UUID): ResponseEntity<MembroEntity> =
        runCatching { membroService.findByMembrosId(membrosId) }
            .map { ResponseEntity.ok(it) }
            .getOrElse { ResponseEntity.notFound().build() }
}
