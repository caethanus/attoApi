package br.com.caethas.atto.atto.modules.caixa.submodules.transacao.mapper

import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.dto.TransacaoFromDto
import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.dto.TransacaoToDto
import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.entity.TransacaoEntity
import br.com.caethas.atto.atto.shared.base.BaseMapper

class TransacaoMapper() : BaseMapper<TransacaoEntity, TransacaoFromDto, TransacaoToDto>() {
    override fun fromDto(request: TransacaoFromDto): TransacaoEntity {
        return TransacaoEntity(
            tituloTransacao = request.tituloTransacao,
            descricaoTransacao = request.descricaoTransacao,
            valorTransacao = request.valorTransacao,
            tipoTransacao = request.tipoTransacao,
            documentoVinculado = request.documentoVinculado,
            caixa = request.caixa,
        )
    }

    override fun toDto(entity: TransacaoEntity): TransacaoToDto {
        return TransacaoToDto(
            id = entity.id,
            criadoEm = entity.criadoEm,
            atualizadoEm = entity.atualizadoEm,
            deletadoEm = entity.deletadoEm,
            sincronizadoEm = entity.sincronizadoEm,
            tituloTransacao = entity.tituloTransacao,
            descricaoTransacao = entity.descricaoTransacao,
            valorTransacao = entity.valorTransacao,
            tipoTransacao = entity.tipoTransacao,
            documentoVinculado = entity.documentoVinculado
        )
    }
}