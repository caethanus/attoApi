package br.com.caethas.atto.atto.modules.lista_presenca.module

import br.com.caethas.atto.atto.modules.lista_presenca.mapper.ListaPresencaMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ListaPresencaModule {

    @Bean
    fun listaPresencaMapper() : ListaPresencaMapper {
        return ListaPresencaMapper()
    }
}