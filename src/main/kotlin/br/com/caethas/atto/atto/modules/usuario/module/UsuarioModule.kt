package br.com.caethas.atto.atto.modules.usuario.module

import br.com.caethas.atto.atto.modules.usuario.mapper.UsuarioMapper
import br.com.caethas.atto.atto.modules.usuario.repository.UsuarioRepository
import br.com.caethas.atto.atto.modules.usuario.service.UsuarioService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UsuarioModule {

    @Bean
    fun usuarioMapper(): UsuarioMapper {
        return UsuarioMapper()
    }

    @Bean
    fun usuarioService(usuarioRepository: UsuarioRepository, usuarioMapper: UsuarioMapper): UsuarioService {
        return UsuarioService(usuarioRepository, usuarioMapper)
    }
}