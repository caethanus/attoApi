package br.com.caethas.atto.atto.modules.usuario.controller

import br.com.caethas.atto.atto.modules.usuario.entity.UsuarioEntity
import br.com.caethas.atto.atto.modules.usuario.repository.UsuarioRepository
import br.com.caethas.atto.atto.modules.usuario.service.AuthenticationService
import br.com.caethas.atto.atto.modules.usuario.service.UsuarioService
import br.com.caethas.atto.atto.shared.base.BaseController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuarios")
class UsuarioController(
    service: UsuarioService,
    private val authenticationService: AuthenticationService
) : BaseController<UsuarioEntity, UsuarioRepository>(service) {

    @PostMapping("/login")
    fun login(@RequestBody usuario: UsuarioEntity): ResponseEntity<UsuarioEntity> {
        return try {
            val usuarioAutenticado = authenticationService.login(usuario.login, usuario.senha ?: "")
            ResponseEntity.ok(usuarioAutenticado)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.status(401).build()
        } catch (e: Exception) {
            ResponseEntity.status(500).build()
        }
    }

    @PostMapping("/refresh-token")
    fun refreshToken(@RequestBody usuario: UsuarioEntity): ResponseEntity<UsuarioEntity> {
        return try {
            val refreshToken = usuario.refreshToken ?: return ResponseEntity.badRequest().build()
            val usuarioAtualizado = authenticationService.refreshToken(refreshToken)
            ResponseEntity.ok(usuarioAtualizado)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.status(401).build()
        } catch (e: Exception) {
            ResponseEntity.status(500).build()
        }
    }

    @PostMapping("/logout")
    fun logout(@RequestBody usuario: UsuarioEntity): ResponseEntity<Unit> {
        return try {
            val usuarioId = usuario.id ?: return ResponseEntity.badRequest().build()
            authenticationService.logout(usuarioId.toString())
            ResponseEntity.ok().build()
        } catch (e: Exception) {
            ResponseEntity.status(500).build()
        }
    }
}
