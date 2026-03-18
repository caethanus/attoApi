package br.com.caethas.atto.atto.modules.diretoria.entity

import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.entity.GestaoEntity
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "diretorias")
data class DiretoriaEntity(
    @Column(name = "nome_diretoria", nullable = false, updatable = true)
    var nomeDiretoria: String,

    @Column(name = "informacoes_diretoria", nullable = false, updatable = true)
    var informacoesDiretoria: String,

    @Column(name = "email_diretoria", nullable = true, updatable = true)
    var emailDiretoria: String?,

    @Column(name = "contato_diretoria", nullable = true, updatable = true)
    var contatoDiretoria: String?,

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "diretoria_gestao_id", nullable = false, updatable = true)
    var gestoes: MutableList<GestaoEntity> = mutableListOf()

) : BaseEntity()