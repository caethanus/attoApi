package br.com.caethas.atto.atto.modules.refresh_token.service

import br.com.caethas.atto.atto.modules.refresh_token.entity.RefreshTokenEntity
import br.com.caethas.atto.atto.modules.refresh_token.repository.RefreshTokenRepository
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.UUID

@Service
class RefreshTokenService(
    override val repository: RefreshTokenRepository
) : BaseService<RefreshTokenEntity, RefreshTokenRepository>(repository) {

    /**
     * Remove refresh tokens expirados
     */
    fun removeTokensExpirados() {
        val tokensExpirados = repository.findAllExpirados(LocalDateTime.now())
        repository.deleteAll(tokensExpirados)
    }

    /**
     * Revoga um refresh token específico
     */
    fun revogarToken(usuarioId: UUID, refreshToken: String) {
        val token = repository.findByRefreshTokenAndUsuarioId(refreshToken, usuarioId)
        if (token != null) {
            token.dataHoraRevogacao = LocalDateTime.now()
            repository.save(token)
        }
    }
}
