package br.com.caethas.atto.atto.modules.caixa.entity

import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "caixas")
class CaixaEntity(
    @Column(name = "saldo_total", nullable = false, updatable = true)
    val saldoTotal: Double
) : BaseEntity()