package br.com.caethas.atto.atto.modules.caixa.mapper

import br.com.caethas.atto.atto.modules.caixa.dto.CaixaDto
import br.com.caethas.atto.atto.modules.caixa.entity.CaixaEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import br.com.caethas.atto.atto.shared.base.BaseMapper

class CaixaMapper : BaseMapper<CaixaEntity, CaixaDto>() {
    override fun toEntity(d: CaixaDto): CaixaEntity {
        return CaixaEntity(
            saldoTotal = d.saldoTotal,
            transacoes = d.transacoes
        ).apply {
            id = d.baseDto.id
            criadoEm = d.baseDto.criadoEm
            atualizadoEm = d.baseDto.atualizadoEm
            deletadoEm = d.baseDto.deletadoEm
            sincronizadoEm = d.baseDto.sincronizadoEm
        }
    }

    override fun toDto(e: CaixaEntity): CaixaDto {
        return CaixaDto(
            baseDto = BaseDto(
                id = e.id,
                criadoEm = e.criadoEm,
                atualizadoEm = e.atualizadoEm,
                deletadoEm = e.deletadoEm,
                sincronizadoEm = e.sincronizadoEm
            ),
            saldoTotal = e.saldoTotal,
            transacoes = e.transacoes
        )
    }

    override fun updateEntity(
        e: CaixaEntity,
        d: CaixaDto
    ): CaixaEntity {
        e.criadoEm = d.baseDto.criadoEm
        e.atualizadoEm = d.baseDto.atualizadoEm
        e.deletadoEm = d.baseDto.deletadoEm
        e.sincronizadoEm = d.baseDto.sincronizadoEm

        e.saldoTotal = d.saldoTotal
        e.transacoes = d.transacoes

        return e;
    }

}