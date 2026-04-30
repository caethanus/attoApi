package br.com.caethas.atto.atto.modules.usuario.module

import br.com.caethas.atto.atto.modules.usuario.repository.UsuarioRepository
import br.com.caethas.atto.atto.modules.usuario.service.UsuarioService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UsuarioModule {

    @Bean
    fun usuarioService(usuarioRepository: UsuarioRepository): UsuarioService {
        return UsuarioService(usuarioRepository)
    }
}