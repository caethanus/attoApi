package br.com.caethas.atto.atto.modules.sincronizacao.controller

import br.com.caethas.atto.atto.modules.sincronizacao.dto.SincronizacaoDto
import br.com.caethas.atto.atto.modules.sincronizacao.service.SincronizacaoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sync")
class SincronizacaoController(private val sincronizacaoService: SincronizacaoService) {
    @PostMapping
    fun sincronizar(@RequestBody request: SincronizacaoDto): ResponseEntity<Any> {
        return ResponseEntity.ok(sincronizacaoService.sincronizar(request))
    }
}