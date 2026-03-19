package br.com.caethas.atto.atto.modules.evento.dto

import br.com.caethas.atto.atto.modules.evento.enums.StatusEvento
import br.com.caethas.atto.atto.shared.base.BaseDto
import java.time.LocalDateTime
import java.util.UUID

class EventoFromDto(
    var tituloEvento: String,
    var descricaoEvento: String,
    val dataHoraRealizacaoEvento: LocalDateTime,
    val dataHoraFinalEvento: LocalDateTime,
    var localEvento: String,
    var quantidadeParticipantes: Int?,
    var statusEvento: StatusEvento
    //TODO: ADICIONAR A ENTIDADE DO CAIXA E DA LISTA DE PRESENÇA QUANDO FOR IMPLEMENTADO
) : BaseDto.FromDto()

class EventoToDto(
    override val id: UUID?,
    override val criadoEm: LocalDateTime?,
    override val atualizadoEm: LocalDateTime?,
    override val deletadoEm: LocalDateTime?,
    override val sincronizadoEm: LocalDateTime?,
    var tituloEvento: String,
    var descricaoEvento: String,
    val dataHoraRealizacaoEvento: LocalDateTime,
    val dataHoraFinalEvento: LocalDateTime,
    var localEvento: String,
    var quantidadeParticipantes: Int?,
    var statusEvento: StatusEvento
) : BaseDto.ToDto(
    id, criadoEm, atualizadoEm, deletadoEm, sincronizadoEm

)