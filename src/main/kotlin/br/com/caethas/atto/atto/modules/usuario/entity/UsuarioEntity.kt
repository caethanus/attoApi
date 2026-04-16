package br.com.caethas.atto.atto.modules.usuario.entity

import br.com.caethas.atto.atto.modules.usuario.enums.TipoUsuario
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table

@Entity
@Table(name = "usuarios")
class UsuarioEntity(
    @Column(name = "login", nullable = false, updatable = true)
    var login: String,

    @Column(name = "senha", nullable = false, updatable = true)
    var senha: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false, updatable = true)
    var tipoUsuario: TipoUsuario
) : BaseEntity()