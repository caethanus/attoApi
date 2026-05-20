package br.com.caethas.atto.atto.modules.usuario.repository

import br.com.caethas.atto.atto.modules.usuario.entity.UsuarioEntity
import br.com.caethas.atto.atto.shared.base.BaseRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository : BaseRepository<UsuarioEntity>