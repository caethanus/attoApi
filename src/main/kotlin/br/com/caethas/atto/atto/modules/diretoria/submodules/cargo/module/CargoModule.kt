package br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.module

import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.mapper.CargoMapper
import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.repository.CargoRepository
import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.service.CargoService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CargoModule {

    @Bean
    fun cargoMapper(): CargoMapper {
        return CargoMapper()
    }

    @Bean
    fun cargoService(
        repository: CargoRepository,
        mapper: CargoMapper
    ): CargoService {
        return CargoService(repository, mapper)
    }
}