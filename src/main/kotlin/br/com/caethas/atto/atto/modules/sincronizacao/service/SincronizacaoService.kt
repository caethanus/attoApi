package br.com.caethas.atto.atto.modules.sincronizacao.service

import br.com.caethas.atto.atto.modules.sincronizacao.dto.SincronizacaoDto
import br.com.caethas.atto.atto.modules.sincronizacao.enums.EndpointEnum
import br.com.caethas.atto.atto.shared.base.interfaces.ISyncable
import org.springframework.stereotype.Service

@Service
class SincronizacaoService(
    services: List<ISyncable<*>>
) {
    private val router: Map<EndpointEnum, ISyncable<*>> = services.associateBy { it.endpoint() }

    fun sincronizar(request: SincronizacaoDto): Any {
        val service = router[request.endpoint]
            ?: throw IllegalArgumentException("Endpoint não encontrado: ${request.endpoint}")
        return service.syncUpsert(request.data)
    }
}