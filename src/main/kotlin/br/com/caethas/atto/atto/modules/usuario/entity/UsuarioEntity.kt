package br.com.caethas.atto.atto.modules.usuario.entity

import br.com.caethas.atto.atto.modules.usuario.enums.TipoUsuario
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table

@Entity
@Table(name = "usuario")
class UsuarioEntity(
    @Column(name = "login")
    var login: String,

    @Column(name = "senha")
    var senha: String,

    @Enumerated(EnumType.STRING)
    var tipoUsuario: TipoUsuario
) : BaseEntity()