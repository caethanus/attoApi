package br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.entity

import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "cargos")
class CargoEntity(
    @Column(name = "titulo_cargo", nullable = false, updatable = true)
    var tituloCargo: String,

    @Column(name = "descricao_cargo", nullable = true, updatable = true)
    var descricaoCargo: String?
    
) : BaseEntity()