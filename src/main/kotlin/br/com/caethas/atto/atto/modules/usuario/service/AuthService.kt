package br.com.caethas.atto.atto.modules.usuario.service

import br.com.caethas.atto.atto.modules.refresh_token.entity.RefreshTokenEntity
import br.com.caethas.atto.atto.modules.refresh_token.repository.RefreshTokenRepository
import br.com.caethas.atto.atto.modules.usuario.entity.UsuarioEntity
import br.com.caethas.atto.atto.modules.usuario.repository.UsuarioRepository
import br.com.caethas.atto.atto.shared.config.JwtConfig
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.UUID

@Service
class AuthService(
    private val usuarioRepository: UsuarioRepository,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtConfig: JwtConfig,
    private val passwordEncoder: BCryptPasswordEncoder
) {

    /**
     * Realiza login do usuário
     * Retorna: UsuarioEntity com accessToken, refreshToken e expiresIn preenchidos
     */
    fun login(login: String, senha: String): UsuarioEntity {
        // Busca usuário pelo login
        val usuario = usuarioRepository.findByLogin(login)
            ?: throw IllegalArgumentException("Usuário ou senha inválidos")

        // Verifica se está ativo
        if (!usuario.ativo) {
            throw IllegalArgumentException("Usuário inativo")
        }

        // Valida senha com BCrypt
        if (!passwordEncoder.matches(senha, usuario.senhaHash)) {
            throw IllegalArgumentException("Usuário ou senha inválidos")
        }

        // Gera tokens
        val accessToken = jwtConfig.generateAccessToken(usuario.id!!, usuario.login)
        val refreshToken = jwtConfig.generateRefreshToken(usuario.id!!)

        // Salva refresh token no banco
        val refreshTokenEntity = RefreshTokenEntity(
            refreshToken = refreshToken,
            dataHoraExpiracao = jwtConfig.getExpirationDate(refreshToken),
            dataHoraRevogacao = null,
            usuario = usuario
        )
        refreshTokenRepository.save(refreshTokenEntity)

        // Preenche campos temporários do usuário com tokens
        usuario.accessToken = accessToken
        usuario.refreshToken = refreshToken
        usuario.expiresIn = jwtConfig.accessTokenExpiration

        return usuario
    }

    /**
     * Renova o access token usando refresh token
     * Retorna: UsuarioEntity com novo accessToken
     */
    fun refreshAccessToken(refreshTokenString: String): UsuarioEntity {
        // Valida refresh token JWT
        if (!jwtConfig.isTokenValid(refreshTokenString) || !jwtConfig.isRefreshToken(refreshTokenString)) {
            throw IllegalArgumentException("Refresh token inválido ou expirado")
        }

        val usuarioId = jwtConfig.extractUsuarioId(refreshTokenString)

        // Busca refresh token no banco
        val refreshTokenEntity = refreshTokenRepository.findByRefreshTokenAndUsuarioId(
            refreshTokenString,
            usuarioId
        ) ?: throw IllegalArgumentException("Refresh token não encontrado")

        // Verifica revogação
        if (refreshTokenEntity.dataHoraRevogacao != null) {
            throw IllegalArgumentException("Refresh token foi revogado")
        }

        // Busca usuário
        val usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow { IllegalArgumentException("Usuário não encontrado") }

        // Gera novo access token
        val newAccessToken = jwtConfig.generateAccessToken(usuario.id!!, usuario.login)

        // Preenche campos temporários
        usuario.accessToken = newAccessToken
        usuario.refreshToken = refreshTokenString
        usuario.expiresIn = jwtConfig.accessTokenExpiration

        return usuario
    }

    /**
     * Revoga todos os refresh tokens do usuário (logout)
     */
    fun logout(usuarioId: UUID) {
        val refreshTokens = refreshTokenRepository.findAllByUsuarioId(usuarioId)
        val now = LocalDateTime.now()
        
        refreshTokens.forEach { token ->
            token.dataHoraRevogacao = now
        }
        
        refreshTokenRepository.saveAll(refreshTokens)
    }
}
