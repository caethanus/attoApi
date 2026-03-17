package br.com.caethas.atto.atto.modules.diretoria.entity

import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.entity.GestaoEntity
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "diretorias")
data class DiretoriaEntity(
    @Column(name = "nome_diretoria")
    var nomeDiretoria: String,

    @Column(name = "informacoes_diretoria")
    var informacoesDiretoria: String,

    @Column(name = "email_diretoria")
    var emailDiretoria: String?,

    @Column(name = "contato_diretoria")
    var contatoDiretoria: String?,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "diretoriaGestao")
    var gestoes: MutableList<GestaoEntity> = mutableListOf()

) : BaseEntity()