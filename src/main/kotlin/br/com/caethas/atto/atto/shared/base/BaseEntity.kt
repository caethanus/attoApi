package br.com.caethas.atto.atto.shared.base

import jakarta.persistence.Column
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDateTime
import java.util.UUID

@MappedSuperclass
abstract class BaseEntity(
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    var id: UUID? = null,

    @Column(name = "criado_em", nullable = false, updatable = true)
    var criadoEm: LocalDateTime? = null,

    @Column(name = "atualizado_em", nullable = true, updatable = true)
    var atualizadoEm: LocalDateTime? = null,

    @Column(name = "deletado_em", nullable = true, updatable = true)
    var deletadoEm: LocalDateTime? = null,
)