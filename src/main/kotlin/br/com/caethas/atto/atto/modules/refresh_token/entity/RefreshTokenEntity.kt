package br.com.caethas.atto.atto.modules.refresh_token.entity

import br.com.caethas.atto.atto.modules.usuario.entity.UsuarioEntity
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ForeignKey
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "refresh_tokens")
class RefreshTokenEntity(
    @Column(name = "refresh_token", nullable = false, updatable = true)
    var refreshToken: String,

    @Column(name = "data_hora_expiracao", nullable = false, updatable = true)
    var dataHoraExpiracao: LocalDateTime,

    @Column(name = "data_hora_revogacao", nullable = true, updatable = true)
    var dataHoraRevogacao: LocalDateTime,

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false, foreignKey = ForeignKey(name = "fk_refresh_token_usuario"))
    var usuario: UsuarioEntity
) : BaseEntity()
