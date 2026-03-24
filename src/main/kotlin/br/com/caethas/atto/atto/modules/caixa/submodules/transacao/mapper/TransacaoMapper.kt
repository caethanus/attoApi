package br.com.caethas.atto.atto.modules.caixa.submodules.transacao.mapper

import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.dto.TransacaoDto
import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.entity.TransacaoEntity
import br.com.caethas.atto.atto.shared.base.BaseMapper

class TransacaoMapper() : BaseMapper<TransacaoEntity, TransacaoDto>() {
    override fun toEntity(d: TransacaoDto): TransacaoEntity {
        return TransacaoEntity(
            tituloTransacao = d.tituloTransacao,
            descricaoTransacao = d.descricaoTransacao,
            valorTransacao = d.valorTransacao,
            tipoTransacao = d.tipoTransacao,
            documentoVinculado = d.documentoVinculado,
            caixa = d.caixa
        ).apply {
            id = d.baseDto.id
            criadoEm = d.baseDto.criadoEm
            atualizadoEm = d.baseDto.atualizadoEm
            deletadoEm = d.baseDto.deletadoEm
            sincronizadoEm = d.baseDto.sincronizadoEm
        }
    }

    override fun toDto(e: TransacaoEntity): TransacaoDto {
        TODO("Not yet implemented")
    }

    override fun updateEntity(
        e: TransacaoEntity,
        d: TransacaoDto
    ): TransacaoEntity {
        e.criadoEm = d.baseDto.criadoEm
        e.criadoEm = d.baseDto.criadoEm
        e.deletadoEm = d.baseDto.deletadoEm
        e.sincronizadoEm = d.baseDto.sincronizadoEm

        return e
    }

}