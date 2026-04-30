package br.com.caethas.atto.atto.modules.lista_presenca.module

import br.com.caethas.atto.atto.modules.lista_presenca.repository.ListaPresencaRepository
import br.com.caethas.atto.atto.modules.lista_presenca.service.ListaPresencaService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ListaPresencaModule {

    @Bean
    fun listaPresencaService(listaPresencaRepository: ListaPresencaRepository): ListaPresencaService {
        return ListaPresencaService(listaPresencaRepository)
    }
}