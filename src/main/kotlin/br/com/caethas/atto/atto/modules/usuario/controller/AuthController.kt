package br.com.caethas.atto.atto.modules.usuario.controller

import br.com.caethas.atto.atto.modules.usuario.entity.UsuarioEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService
) {

    /**
     * POST /auth/login
     * Body: { "login": "usuario", "senha": "senha123" }
     * Response: UsuarioEntity com accessToken, refreshToken e expiresIn
     */
    @PostMapping("/login")
    fun login(@RequestBody request: Map<String, String>): ResponseEntity<UsuarioEntity> {
        return try {
            val login = request["login"] ?: return ResponseEntity.badRequest().build()
            val senha = request["senha"] ?: return ResponseEntity.badRequest().build()

            if (login.isBlank() || senha.isBlank()) {
                return ResponseEntity.badRequest().build()
            }

            val usuario = authService.login(login, senha)
            ResponseEntity.ok(usuario)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
    }

    /**
     * POST /auth/refresh-token
     * Body: { "refreshToken": "token_aqui" }
     * Response: UsuarioEntity com novo accessToken
     */
    @PostMapping("/refresh-token")
    fun refreshToken(@RequestBody request: Map<String, String>): ResponseEntity<UsuarioEntity> {
        return try {
            val refreshToken = request["refreshToken"] ?: return ResponseEntity.badRequest().build()

            if (refreshToken.isBlank()) {
                return ResponseEntity.badRequest().build()
            }

            val usuario = authService.refreshAccessToken(refreshToken)
            ResponseEntity.ok(usuario)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
    }

    /**
     * POST /auth/logout
     * Body: { "usuarioId": "uuid" }
     */
    @PostMapping("/logout")
    fun logout(@RequestBody request: Map<String, String>): ResponseEntity<Unit> {
        return try {
            val usuarioIdStr = request["usuarioId"] ?: return ResponseEntity.badRequest().build()
            val usuarioId = UUID.fromString(usuarioIdStr)
            
            authService.logout(usuarioId)
            ResponseEntity.noContent().build()
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
    }
}
