package br.com.caethas.atto.atto.shared.base.dto

import jakarta.persistence.MappedSuperclass
import java.time.LocalDateTime
import java.util.UUID

@MappedSuperclass
abstract class BaseDto(
    var id: UUID? = null,

    var criadoEm: LocalDateTime? = null,

    var atualizadoEm: LocalDateTime? = null,

    var deletadoEm: LocalDateTime? = null,
)