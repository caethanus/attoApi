package br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.entity

import br.com.caethas.atto.atto.modules.lista_presenca.entity.ListaPresencaEntity
import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "registros_presencas")
data class RegistroPresencaEntity(

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membro_id", nullable = true, updatable = true)
    var membro: MembroEntity,

    @Column(name = "presente", nullable = false)
    var presente: Boolean,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lista_presenca_id", nullable = false, updatable = true)
    var listaPresenca: ListaPresencaEntity

) : BaseEntity()