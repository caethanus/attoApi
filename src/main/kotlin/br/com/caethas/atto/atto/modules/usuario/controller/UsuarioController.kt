package br.com.caethas.atto.atto.modules.usuario.controller

import br.com.caethas.atto.atto.modules.usuario.dto.UsuarioFromDto
import br.com.caethas.atto.atto.modules.usuario.dto.UsuarioToDto
import br.com.caethas.atto.atto.modules.usuario.entity.UsuarioEntity
import br.com.caethas.atto.atto.modules.usuario.service.UsuarioService
import br.com.caethas.atto.atto.shared.base.BaseController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuarios")
class UsuarioController(service: UsuarioService) :
    BaseController<UsuarioEntity, UsuarioFromDto, UsuarioToDto>(service)