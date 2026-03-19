package br.com.caethas.atto.atto.modules.lista_presenca.entity

import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.entity.RegistroPresencaEntity
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "listas_presenca")
data class ListaPresencaEntity(

    @Column(name = "data_lista_presenca", nullable = false)
    var dataListaPresenca: LocalDateTime,

    @OneToMany
    @JoinColumn(name = "lista_presenca_id") // FK fica na tabela de registros
    var registrosPresenca: MutableList<RegistroPresencaEntity> = mutableListOf()

) : BaseEntity()