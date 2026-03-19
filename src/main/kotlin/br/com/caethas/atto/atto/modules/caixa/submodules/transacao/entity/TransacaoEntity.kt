package br.com.caethas.atto.atto.modules.caixa.submodules.transacao.entity

import br.com.caethas.atto.atto.modules.caixa.entity.CaixaEntity
import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.enums.TipoTransacao
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "transacoes")
class TransacaoEntity(
    @Column(name = "titulo_transacao", nullable = false, updatable = true)
    var tituloTransacao: String,

    @Column(name = "descricao_transacao", nullable = false, updatable = true)
    var descricaoTransacao: String,

    @Column(name = "valor_transacao", nullable = false, updatable = true)
    var valorTransacao: Double,

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_transacao", nullable = false, updatable = false)
    var tipoTransacao: TipoTransacao,

    @Column(name = "documento_vinculado", nullable = true, updatable = true)
    var documentoVinculado: String?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caixa_transacoes_id", nullable = false)
    var caixa: CaixaEntity
) : BaseEntity()