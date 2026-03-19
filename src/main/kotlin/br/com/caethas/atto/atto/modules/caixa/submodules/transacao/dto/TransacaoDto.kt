package br.com.caethas.atto.atto.modules.caixa.submodules.transacao.dto

import br.com.caethas.atto.atto.modules.caixa.entity.CaixaEntity
import br.com.caethas.atto.atto.modules.caixa.submodules.transacao.enums.TipoTransacao
import br.com.caethas.atto.atto.shared.base.BaseDto
import java.time.LocalDateTime
import java.util.UUID

class TransacaoFromDto(
    val tituloTransacao: String,
    val descricaoTransacao: String,
    val valorTransacao: Double,
    val tipoTransacao: TipoTransacao,
    val documentoVinculado: String?,
    val caixa: CaixaEntity
) : BaseDto.FromDto()

class TransacaoToDto(
    override val id: UUID?,
    override val criadoEm: LocalDateTime?,
    override val atualizadoEm: LocalDateTime?,
    override val deletadoEm: LocalDateTime?,
    override val sincronizadoEm: LocalDateTime?,
    val tituloTransacao: String,
    val descricaoTransacao: String,
    val valorTransacao: Double,
    val tipoTransacao: TipoTransacao,
    val documentoVinculado: String?
) : BaseDto.ToDto(
    id,
    criadoEm,
    atualizadoEm,
    deletadoEm,
    sincronizadoEm
)