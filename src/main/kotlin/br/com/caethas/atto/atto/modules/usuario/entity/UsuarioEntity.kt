package br.com.caethas.atto.atto.modules.usuario.entity

import br.com.caethas.atto.atto.modules.usuario.enums.TipoUsuario
import br.com.caethas.atto.atto.modules.refresh_token.entity.RefreshTokenEntity
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.persistence.Transient
import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.UUID

@Entity
@Table(name = "usuarios")
class UsuarioEntity(
    @Column(name = "login", nullable = false, updatable = false, unique = true)
    var login: String,

    @Column(name = "senha_hash", nullable = false, updatable = true)
    @JsonIgnore // Nunca retorna a senha ao cliente
    var senhaHash: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false)
    var tipoUsuario: TipoUsuario,

    @OneToMany(mappedBy = "usuario", orphanRemoval = true)
    @JsonIgnore // Não serializa a lista de refresh tokens
    var refreshTokens: MutableList<RefreshTokenEntity> = mutableListOf(),

    @Column(name = "ativo", nullable = false)
    var ativo: Boolean = true,

    // Campos de autenticação temporários (não persistem no banco)
    @Transient
    var accessToken: String? = null,

    @Transient
    var refreshToken: String? = null,

    @Transient
    var expiresIn: Long? = null

) : BaseEntity()