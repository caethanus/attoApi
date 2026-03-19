package br.com.caethas.atto.atto.modules.caixa.dto

import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.entity.TransacaoEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

class CaixaFromDto(
    val saldoTotal: BigDecimal,
) : BaseDto.FromDto()

class CaixaToDto(
    override val id: UUID?,
    override val criadoEm: LocalDateTime?,
    override val atualizadoEm: LocalDateTime?,
    override val deletadoEm: LocalDateTime?,
    override val sincronizadoEm: LocalDateTime?,
    val saldoTotal: BigDecimal,
) : BaseDto.ToDto(
    id,
    criadoEm,
    atualizadoEm,
    deletadoEm,
    sincronizadoEm
)