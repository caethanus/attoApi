package br.com.caethas.atto.atto.modules.lista_presenca.entity

import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.entity.RegistroPresencaEntity
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "listas_presenca")
data class ListaPresencaEntity(
    @Column(name = "data_lista_presenca")
    var dataListaPresenca: LocalDateTime,

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "registros_presenca")
    var registrosPresenca: MutableList<RegistroPresencaEntity>,
    //TODO: Tem que adicionar o evento quando ele for desenvolvido
) : BaseEntity()