package br.com.caethas.atto.atto.modules.usuario.service

import br.com.caethas.atto.atto.modules.refresh_token.entity.RefreshTokenEntity
import br.com.caethas.atto.atto.modules.refresh_token.repository.RefreshTokenRepository
import br.com.caethas.atto.atto.modules.usuario.entity.UsuarioEntity
import br.com.caethas.atto.atto.modules.usuario.repository.UsuarioRepository
import br.com.caethas.atto.atto.shared.security.JwtProvider
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.UUID

@Service
class AuthenticationService(
    private val usuarioRepository: UsuarioRepository,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtProvider: JwtProvider,
    private val passwordEncoder: BCryptPasswordEncoder
) {

    fun login(login: String, senha: String): UsuarioEntity {
        val usuario = usuarioRepository.findByLogin(login)
            ?: throw IllegalArgumentException("Usuário ou senha inválidos")

        if (!passwordEncoder.matches(senha, usuario.senha)) {
            throw IllegalArgumentException("Usuário ou senha inválidos")
        }

        if (usuario.deletadoEm != null) {
            throw IllegalArgumentException("Usuário inativo")
        }

        // Gerar tokens
        val accessToken = jwtProvider.generateAccessToken(usuario.id.toString(), usuario.login)
        val refreshTokenString = jwtProvider.generateRefreshToken(usuario.id.toString())

        // Salvar refresh token no banco
        val expiraEm = LocalDateTime.now().plusSeconds(jwtProvider.getAccessTokenExpiration() / 1000)
        val refreshToken = RefreshTokenEntity(
            usuario = usuario,
            token = refreshTokenString,
            expiraEm = expiraEm
        )
        refreshTokenRepository.save(refreshToken)

        // Atribuir aos campos transitórios
        usuario.accessToken = accessToken
        usuario.refreshToken = refreshTokenString
        usuario.expiresIn = jwtProvider.getAccessTokenExpiration()

        return usuario
    }

    fun refreshToken(refreshTokenString: String): UsuarioEntity {
        if (!jwtProvider.validateToken(refreshTokenString)) {
            throw IllegalArgumentException("Refresh token inválido")
        }

        val refreshToken = refreshTokenRepository.findByToken(refreshTokenString)
            ?: throw IllegalArgumentException("Refresh token não encontrado")

        if (refreshToken.revogado || LocalDateTime.now().isAfter(refreshToken.expiraEm)) {
            throw IllegalArgumentException("Refresh token expirado ou revogado")
        }

        val usuario = refreshToken.usuario
        if (usuario.deletadoEm != null) {
            throw IllegalArgumentException("Usuário inativo")
        }

        // Gerar novo access token
        val accessToken = jwtProvider.generateAccessToken(usuario.id.toString(), usuario.login)

        usuario.accessToken = accessToken
        usuario.refreshToken = refreshTokenString
        usuario.expiresIn = jwtProvider.getAccessTokenExpiration()

        return usuario
    }

    fun logout(usuarioId: String) {
        val refreshTokens = refreshTokenRepository.findAllByUsuarioId(UUID.fromString(usuarioId))
        refreshTokens.forEach { it.revogado = true }
        refreshTokenRepository.saveAll(refreshTokens)
    }
}
