package br.com.caethas.atto.atto.modules.refresh_token.repository

import br.com.caethas.atto.atto.modules.refresh_token.entity.RefreshTokenEntity
import br.com.caethas.atto.atto.shared.base.BaseRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface RefreshTokenRepository : BaseRepository<RefreshTokenEntity> {
    fun findByToken(token: String): RefreshTokenEntity?
    fun findAllByUsuarioId(usuarioId: UUID): List<RefreshTokenEntity>
}
