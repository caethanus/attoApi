package br.com.caethas.atto.atto.modules.refresh_token.entity

import br.com.caethas.atto.atto.modules.usuario.entity.UsuarioEntity
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "refresh_tokens")
class RefreshTokenEntity(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    var usuario: UsuarioEntity,

    @Column(name = "token", nullable = false, unique = true)
    var token: String,

    @Column(name = "expira_em", nullable = false)
    var expiraEm: LocalDateTime,

    @Column(name = "revogado", nullable = false)
    var revogado: Boolean = false
) : BaseEntity()
