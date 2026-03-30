package br.com.caethas.atto.atto.modules.caixa.dto

import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.entity.TransacaoEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import java.math.BigDecimal

data class CaixaDto(
    val baseDto: BaseDto,
    val saldoTotal: BigDecimal,
    var transacoes: MutableList<TransacaoEntity> = mutableListOf(),
)