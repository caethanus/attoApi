package br.com.caethas.atto.atto.shared.base

import java.time.LocalDateTime
import java.util.UUID

abstract class BaseDto {

    abstract class FromDto

    abstract class ToDto(
        open val id: UUID?,
        open val criadoEm: LocalDateTime?,
        open val atualizadoEm: LocalDateTime?,
        open val deletadoEm: LocalDateTime?,
        open val sincronizadoEm: LocalDateTime?,
    )
}