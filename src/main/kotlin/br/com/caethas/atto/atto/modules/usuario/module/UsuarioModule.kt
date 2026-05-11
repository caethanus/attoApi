package br.com.caethas.atto.atto.modules.usuario.module

import br.com.caethas.atto.atto.modules.usuario.repository.UsuarioRepository
import br.com.caethas.atto.atto.modules.usuario.service.UsuarioService
import br.com.caethas.atto.atto.modules.usuario.service.AuthenticationService
import br.com.caethas.atto.atto.modules.refresh_token.repository.RefreshTokenRepository
import br.com.caethas.atto.atto.modules.membro.repository.MembroRepository
import br.com.caethas.atto.atto.modules.membro.service.MembroService
import br.com.caethas.atto.atto.shared.security.JwtProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
class   UsuarioModule {

    @Bean
    fun usuarioService(usuarioRepository: UsuarioRepository): UsuarioService {
        return UsuarioService(usuarioRepository)
    }

    @Bean
    fun authenticationService(
        usuarioRepository: UsuarioRepository,
        refreshTokenRepository: RefreshTokenRepository,
        jwtProvider: JwtProvider,
        passwordEncoder: BCryptPasswordEncoder
    ): AuthenticationService {
        return AuthenticationService(usuarioRepository, refreshTokenRepository, jwtProvider, passwordEncoder)
    }
}