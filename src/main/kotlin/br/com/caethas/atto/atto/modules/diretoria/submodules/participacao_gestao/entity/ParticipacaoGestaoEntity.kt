package br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.entity

import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.entity.CargoEntity
import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "participacoes_gestao")
data class ParticipacaoGestaoEntity(
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "membro")
    var membro: MembroEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "cargo")
    var cargo: CargoEntity,

    @Column(name = "data_entrada")
    var dataEntrada: LocalDateTime,

    @Column(name = "data_saida")
    var dataSaida: LocalDateTime?
) : BaseEntity()