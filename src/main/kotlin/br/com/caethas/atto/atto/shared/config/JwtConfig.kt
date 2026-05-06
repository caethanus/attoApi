package br.com.caethas.atto.atto.shared.config

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date
import java.util.UUID

@Component
class JwtConfig(
    @Value("\${jwt.secret-key:MySecureSecretKeyWithAtLeast256BitsOfLengthForHS256}")
    val secretKey: String,

    @Value("\${jwt.access-token-expiration:900000}")
    val accessTokenExpiration: Long, // ms

    @Value("\${jwt.refresh-token-expiration:604800000}")
    val refreshTokenExpiration: Long // ms
) {
    private val key = Keys.hmacShaKeyFor(secretKey.toByteArray())

    /**
     * Gera um novo Access Token (JWT)
     */
    fun generateAccessToken(usuarioId: UUID, login: String): String {
        val issuedAt = Date()
        val expiresAt = Date(issuedAt.time + accessTokenExpiration)

        return Jwts.builder()
            .subject(usuarioId.toString())
            .claim("login", login)
            .issuedAt(issuedAt)
            .expiration(expiresAt)
            .signWith(key, SignatureAlgorithm.HS256)
            .compact()
    }

    /**
     * Gera um novo Refresh Token
     */
    fun generateRefreshToken(usuarioId: UUID): String {
        val issuedAt = Date()
        val expiresAt = Date(issuedAt.time + refreshTokenExpiration)

        return Jwts.builder()
            .subject(usuarioId.toString())
            .claim("type", "refresh")
            .issuedAt(issuedAt)
            .expiration(expiresAt)
            .signWith(key, SignatureAlgorithm.HS256)
            .compact()
    }

    /**
     * Extrai o UsuarioId do token
     */
    fun extractUsuarioId(token: String): UUID {
        return UUID.fromString(getAllClaims(token).subject)
    }

    /**
     * Valida se o token é válido
     */
    fun isTokenValid(token: String): Boolean {
        return try {
            val claims = getAllClaims(token)
            !claims.expiration.before(Date())
        } catch (e: Exception) {
            false
        }
    }

    /**
     * Valida se é um refresh token
     */
    fun isRefreshToken(token: String): Boolean {
        return try {
            val claims = getAllClaims(token)
            claims.get("type", String::class.java) == "refresh"
        } catch (e: Exception) {
            false
        }
    }

    /**
     * Extrai data de expiração
     */
    fun getExpirationDate(token: String): LocalDateTime {
        return getAllClaims(token).expiration.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime()
    }

    private fun getAllClaims(token: String): Claims {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .body
    }
}
