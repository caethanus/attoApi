package br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.entity

import br.com.caethas.atto.atto.modules.diretoria.entity.DiretoriaEntity
import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.entity.ParticipacaoGestaoEntity
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "gestoes")
data class GestaoEntity(
    @Column(name = "data_inicio_gestao")
    var dataInicioGestao: LocalDateTime,

    @Column(name = "data_final_gestao")
    var dataFinalGestao: LocalDateTime?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "presidente_gestao_id")
    var presidenteGestao: ParticipacaoGestaoEntity,

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "membros_gestao_participacao_gestao",
        joinColumns = [JoinColumn(name = "gestao_id")],
        inverseJoinColumns = [JoinColumn(name = "participacao_gestao_id")]
    )
    var membrosGestao: MutableList<ParticipacaoGestaoEntity> = mutableListOf(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diretoria_id")
    var diretoriaGestao: DiretoriaEntity,

    ) : BaseEntity()