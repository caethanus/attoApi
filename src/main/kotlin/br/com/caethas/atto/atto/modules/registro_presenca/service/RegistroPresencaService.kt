package br.com.caethas.atto.atto.modules.registro_presenca.service

import br.com.caethas.atto.atto.modules.registro_presenca.entity.RegistroPresencaEntity
import br.com.caethas.atto.atto.modules.registro_presenca.repository.RegistroPresencaRepository
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class RegistroPresencaService(repository: RegistroPresencaRepository) :
    BaseService<RegistroPresencaEntity, RegistroPresencaRepository>(repository) {

    /**
     * Busca registros de presença por ID da lista de presença
     */
    fun findByListaPresencaId(listaPresencaId: UUID): RegistroPresencaEntity =
        repository.findByListaPresencaId(listaPresencaId)
            .firstOrNull()
            ?: throw RuntimeException("Nenhum registro de presença encontrado para listaPresencaId: $listaPresencaId")
}