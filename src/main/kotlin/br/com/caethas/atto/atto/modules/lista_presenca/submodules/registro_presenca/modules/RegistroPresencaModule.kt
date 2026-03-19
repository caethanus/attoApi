package br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.modules

import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.mapper.RegistroPresencaMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RegistroPresencaModule {

    @Bean
    fun registroPresencaMapper(): RegistroPresencaMapper {
        return RegistroPresencaMapper()
    }
}