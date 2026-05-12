package br.com.caethas.atto.atto.modules.membro.service

import br.com.caethas.atto.atto.modules.membro.dto.MembroDto
import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.modules.membro.repository.MembroRepository
import br.com.caethas.atto.atto.modules.sincronizacao.enums.EndpointEnum
import br.com.caethas.atto.atto.shared.base.BaseService
import br.com.caethas.atto.atto.shared.base.interfaces.ISyncable
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service
import kotlin.jvm.java

@Service
class MembroService(
    repository: MembroRepository,
    private val objectMapper: ObjectMapper
) : BaseService<MembroEntity, MembroRepository>(repository), ISyncable<MembroDto> {

    override fun syncUpsert(data: Map<String, Any>): Any {
        println("DATA RECEBIDO: $data")  // veja se o id está no Map
        val dto = objectMapper.convertValue(data, MembroDto::class.java)
        println("DTO ID: ${dto.id}")     // veja se o convertValue mapeou
        println("DTO CRIADO EM: ${dto.criadoEm}")     // veja se o convertValue mapeou
        return upsert(dto.toEntity()).toDto()
    }

    override fun endpoint() = EndpointEnum.MEMBROS
}