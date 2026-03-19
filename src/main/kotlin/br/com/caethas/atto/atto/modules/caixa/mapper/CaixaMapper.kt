package br.com.caethas.atto.atto.modules.caixa.mapper

import br.com.caethas.atto.atto.modules.caixa.dto.CaixaFromDto
import br.com.caethas.atto.atto.modules.caixa.dto.CaixaToDto
import br.com.caethas.atto.atto.modules.caixa.entity.CaixaEntity
import br.com.caethas.atto.atto.shared.base.BaseMapper

class CaixaMapper : BaseMapper<CaixaEntity, CaixaFromDto, CaixaToDto>() {
    override fun fromDto(request: CaixaFromDto): CaixaEntity {
        return CaixaEntity(
            saldoTotal = request.saldoTotal,
        )
    }

    override fun toDto(entity: CaixaEntity): CaixaToDto {
        return CaixaToDto(
            id = entity.id,
            criadoEm = entity.criadoEm,
            atualizadoEm = entity.atualizadoEm,
            deletadoEm = entity.deletadoEm,
            sincronizadoEm = entity.sincronizadoEm,
            saldoTotal = entity.saldoTotal
        )
    }
}