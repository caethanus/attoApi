package br.com.caethas.atto.atto.modules.sincronizacao.dto

import br.com.caethas.atto.atto.modules.sincronizacao.enums.EndpointEnum
import br.com.caethas.atto.atto.modules.sincronizacao.enums.OperationEnum

data class SincronizacaoDto(
    val endpoint: EndpointEnum,
    val operation: OperationEnum,
    val data: Map<String, Any>
)