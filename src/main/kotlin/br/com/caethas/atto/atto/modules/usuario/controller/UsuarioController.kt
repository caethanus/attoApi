package br.com.caethas.atto.atto.modules.usuario.controller

import BaseController
import br.com.caethas.atto.atto.modules.usuario.entity.UsuarioEntity
import br.com.caethas.atto.atto.modules.usuario.service.UsuarioService
import br.com.caethas.atto.atto.shared.base.BaseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuarios")
class UsuarioController(service: UsuarioService) : BaseController<UsuarioEntity>(service) {
}