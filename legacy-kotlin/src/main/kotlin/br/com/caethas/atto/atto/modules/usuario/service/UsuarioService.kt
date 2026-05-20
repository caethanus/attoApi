package br.com.caethas.atto.atto.modules.usuario.service

import br.com.caethas.atto.atto.modules.usuario.entity.UsuarioEntity
import br.com.caethas.atto.atto.modules.usuario.repository.UsuarioRepository
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service

@Service
class UsuarioService(override val repository: UsuarioRepository) :
    BaseService<UsuarioEntity, UsuarioRepository>(repository)