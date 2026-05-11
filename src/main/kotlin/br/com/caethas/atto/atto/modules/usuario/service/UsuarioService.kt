package br.com.caethas.atto.atto.modules.usuario.service

import br.com.caethas.atto.atto.modules.usuario.entity.UsuarioEntity
import br.com.caethas.atto.atto.modules.usuario.repository.UsuarioRepository
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    override val repository: UsuarioRepository,
    private val passwordEncoder: BCryptPasswordEncoder = BCryptPasswordEncoder()
) : BaseService<UsuarioEntity, UsuarioRepository>(repository) {

    override fun upsert(entity: UsuarioEntity): UsuarioEntity {
        // Hash da senha se for novo ou se não for hash BCrypt
        if (entity.id == null || !entity.senha.startsWith("\$2a$")) {
            entity.senha = passwordEncoder.encode(entity.senha)
        }
        return super.upsert(entity)
    }
}
