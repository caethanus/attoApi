package br.com.caethas.atto.atto.modules.caixa.entity

import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.entity.TransacaoEntity
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "caixas")
class CaixaEntity(
    @Column(name = "saldo_total", nullable = false, updatable = true)
    var saldoTotal: BigDecimal,

    @OneToMany(
        mappedBy = "caixa",
        fetch = FetchType.LAZY
    )
    @Column(name = "transacoes", nullable = false, updatable = true)
    var transacoes: MutableList<TransacaoEntity> = mutableListOf(),
) : BaseEntity()