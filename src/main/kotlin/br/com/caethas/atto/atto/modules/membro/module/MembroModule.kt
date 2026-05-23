package br.com.caethas.atto.atto.modules.membro.module

import br.com.caethas.atto.atto.modules.membro.mapper.MembroMapper
import br.com.caethas.atto.atto.modules.membro.repository.MembroRepository
import br.com.caethas.atto.atto.modules.membro.service.MembroService
import br.com.caethas.atto.atto.modules.usuario.mapper.UsuarioMapper
import br.com.caethas.atto.atto.modules.usuario.repository.UsuarioRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MembroModule {

    @Bean
    fun membroMapper(usuarioRepository: UsuarioRepository, usuarioMapper: UsuarioMapper): MembroMapper {
        return MembroMapper(usuarioRepository, usuarioMapper)
    }

    @Bean
    fun membroService(membroRepository: MembroRepository, membroMapper: MembroMapper): MembroService {
        return MembroService(membroRepository, membroMapper)
    }
}