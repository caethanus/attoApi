package br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.entity

import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.entity.CargoEntity
import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.entity.GestaoEntity
import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "participacoes_gestao")
class ParticipacaoGestaoEntity(
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membro_id", nullable = true, updatable = true)
    var membro: MembroEntity,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargo_id", nullable = false, updatable = true)
    var cargo: CargoEntity,

    @Column(name = "data_entrada", nullable = false, updatable = true)
    var dataEntrada: LocalDateTime,

    @Column(name = "data_saida", nullable = true, updatable = true)
    var dataSaida: LocalDateTime?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gestao_id", nullable = false, updatable = true)
    var gestao: GestaoEntity
) : BaseEntity()