package br.com.caethas.atto.atto.modules.registro_presenca.controller

import br.com.caethas.atto.atto.modules.registro_presenca.entity.RegistroPresencaEntity
import br.com.caethas.atto.atto.modules.registro_presenca.repository.RegistroPresencaRepository
import br.com.caethas.atto.atto.modules.registro_presenca.service.RegistroPresencaService
import br.com.caethas.atto.atto.shared.base.BaseController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/registros-presenca")
class RegistroPresencaController(service: RegistroPresencaService) :
    BaseController<RegistroPresencaEntity, RegistroPresencaRepository>(service) {

    @GetMapping("externos/{registroPresencaId}")
    fun findByRegistroPresencaId(@PathVariable registroPresencaId: UUID): ResponseEntity<RegistroPresencaEntity> =
        runCatching { service.findById(registroPresencaId) }
            .map { ResponseEntity.ok(it) }
            .getOrElse { ResponseEntity.notFound().build() }
}
