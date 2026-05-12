package br.com.caethas.atto.atto.shared.base.interfaces

import br.com.caethas.atto.atto.modules.sincronizacao.enums.EndpointEnum

interface ISyncable<DTO> {
    fun syncUpsert(data: Map<String, Any>): Any
    fun endpoint(): EndpointEnum
}