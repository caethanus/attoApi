package br.com.caethas.atto.atto.modules.usuario.controller

import br.com.caethas.atto.atto.modules.usuario.entity.UsuarioEntity
import br.com.caethas.atto.atto.modules.usuario.repository.UsuarioRepository
import br.com.caethas.atto.atto.modules.usuario.service.AuthenticationService
import br.com.caethas.atto.atto.modules.usuario.service.UsuarioService
import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.modules.membro.enums.StatusAssociado
import br.com.caethas.atto.atto.modules.membro.service.MembroService
import br.com.caethas.atto.atto.shared.base.BaseController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class CadastroUsuarioRequest(
    val login: String,
    val senha: String,
    val tipoUsuario: String
)

@RestController
@RequestMapping("/usuarios")
class UsuarioController(
    service: UsuarioService,
    private val authenticationService: AuthenticationService,
    private val membroService: MembroService
) : BaseController<UsuarioEntity, UsuarioRepository>(service) {

    @PostMapping("/cadastro")
    fun cadastro(@RequestBody request: CadastroUsuarioRequest): ResponseEntity<UsuarioEntity> {
        return try {
            // 1. Salvar novo usuário (UsuarioService faz hash da senha)
            val novoUsuario = UsuarioEntity(
                login = request.login,
                senha = request.senha,
                tipoUsuario = br.com.caethas.atto.atto.modules.usuario.enums.TipoUsuario.valueOf(request.tipoUsuario)
            )
            val usuarioSalvo = service.upsert(novoUsuario)

            // 2. Criar membro associado ao usuário
            val novoMembro = MembroEntity(
                usuario = usuarioSalvo,
                nomeMembro = request.login,
                emailMembro = null,
                contatoMembro = null,
                enderecoMembro = null,
                statusAssociado = StatusAssociado.ATIVO
            )
            membroService.upsert(novoMembro)

            // 3. Autenticar imediatamente (gerar tokens)
            val usuarioAutenticado = authenticationService.login(request.login, request.senha)

            ResponseEntity.status(201).body(usuarioAutenticado)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.status(400).build()
        } catch (e: Exception) {
            ResponseEntity.status(500).build()
        }
    }

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
