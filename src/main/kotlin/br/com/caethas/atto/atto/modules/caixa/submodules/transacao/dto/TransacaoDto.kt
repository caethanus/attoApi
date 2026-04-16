package br.com.caethas.atto.atto.modules.caixa.submodules.transacao.dto

import br.com.caethas.atto.atto.modules.caixa.entity.CaixaEntity
import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.enums.TipoTransacao
import br.com.caethas.atto.atto.shared.base.BaseDto
import java.math.BigDecimal

data class TransacaoDto(
    val baseDto: BaseDto,
    var tituloTransacao: String,
    var descricaoTransacao: String,
    var valorTransacao: BigDecimal,
    var tipoTransacao: TipoTransacao,
    var documentoVinculado: String?,
    var caixa: CaixaEntity
)