package br.com.caethas.atto.atto.shared.base

import java.time.LocalDateTime
import java.util.UUID

data class BaseDto(
    val id: UUID?,
    val criadoEm: LocalDateTime?,
    val atualizadoEm: LocalDateTime?,
    val deletadoEm: LocalDateTime?,
    val sincronizadoEm: LocalDateTime?
)