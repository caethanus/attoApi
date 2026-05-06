package br.com.caethas.atto.atto.modules.refresh_token.repository

import br.com.caethas.atto.atto.modules.refresh_token.entity.RefreshTokenEntity
import br.com.caethas.atto.atto.shared.base.BaseRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.util.UUID

@Repository
interface RefreshTokenRepository : BaseRepository<RefreshTokenEntity> {

    fun findByRefreshTokenAndUsuarioId(
        refreshToken: String,
        usuarioId: UUID
    ): RefreshTokenEntity?

    fun findAllByUsuarioId(usuarioId: UUID): List<RefreshTokenEntity>

    @Query("""
        SELECT rt FROM RefreshTokenEntity rt
        WHERE rt.dataHoraExpiracao < :now
        AND rt.dataHoraRevogacao IS NULL
    """)
    fun findAllExpirados(@Param("now") now: LocalDateTime): List<RefreshTokenEntity>
}
