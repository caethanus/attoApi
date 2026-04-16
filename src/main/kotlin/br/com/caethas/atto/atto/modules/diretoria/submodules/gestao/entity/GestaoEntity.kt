package br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.entity

import br.com.caethas.atto.atto.modules.diretoria.entity.DiretoriaEntity
import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.entity.ParticipacaoGestaoEntity
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "gestoes")
data class GestaoEntity(
    @Column(name = "data_inicio_gestao", nullable = false, updatable = true)
    var dataInicioGestao: LocalDateTime,

    @Column(name = "data_final_gestao", nullable = true, updatable = true)
    var dataFinalGestao: LocalDateTime?,

    @OneToMany(mappedBy = "gestao", fetch = FetchType.LAZY)
    @Column(name = "membros_gestao", nullable = false, updatable = true)
    var membrosGestao: MutableList<ParticipacaoGestaoEntity> = mutableListOf(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diretoria_id", nullable = false, updatable = true)
    var diretoria: DiretoriaEntity

) : BaseEntity()