package br.com.caethas.atto.atto.modules.usuario.service

import br.com.caethas.atto.atto.modules.usuario.dto.UsuarioDto
import br.com.caethas.atto.atto.modules.usuario.dto.UsuarioFromDto
import br.com.caethas.atto.atto.modules.usuario.dto.UsuarioToDto
import br.com.caethas.atto.atto.modules.usuario.entity.UsuarioEntity
import br.com.caethas.atto.atto.modules.usuario.mapper.UsuarioMapper
import br.com.caethas.atto.atto.modules.usuario.repository.UsuarioRepository
import br.com.caethas.atto.atto.shared.base.BaseService

class UsuarioService(
    override val repository: UsuarioRepository,
    override val mapper: UsuarioMapper
) : BaseService<UsuarioEntity, UsuarioRepository, UsuarioDto>(repository, mapper)