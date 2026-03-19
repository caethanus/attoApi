package br.com.caethas.atto.atto.modules.caixa.entity

import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.entity.TransacaoEntity
import br.com.caethas.atto.atto.modules.evento.entity.EventoEntity
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "caixas")
class CaixaEntity(
    @Column(name = "saldo_total", nullable = false, updatable = true)
    val saldoTotal: Double,

    @OneToMany(
        mappedBy = "caixa",
        fetch = FetchType.LAZY
    )
    @Column(name = "transacoes", nullable = false, updatable = true)
    var transacoes: MutableList<TransacaoEntity> = mutableListOf(),
) : BaseEntity()