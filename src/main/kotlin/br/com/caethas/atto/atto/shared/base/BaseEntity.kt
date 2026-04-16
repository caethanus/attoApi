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
    @Column(nullable = false, updatable = false)
    var id: UUID? = null,

    @Column(name = "criado_em")
    var criadoEm: LocalDateTime? = null,

    @Column(name = "atualizado_em")
    var atualizadoEm: LocalDateTime? = null,

    @Column(name = "deletado_em")
    var deletadoEm: LocalDateTime? = null,

    @Column(name = "sincronizado_em")
    var sincronizadoEm: LocalDateTime? = null,
)