package br.com.caethas.atto.atto.modules.evento.dto

import br.com.caethas.atto.atto.modules.caixa.entity.CaixaEntity
import br.com.caethas.atto.atto.modules.evento.enums.StatusEvento
import br.com.caethas.atto.atto.modules.lista_presenca.entity.ListaPresencaEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import java.time.LocalDateTime

data class EventoDto(
    val baseDto: BaseDto,
    var tituloEvento: String,
    var descricaoEvento: String,
    val dataHoraRealizacaoEvento: LocalDateTime,
    val dataHoraFinalizacaoEvento: LocalDateTime,
    var localEvento: String,
    var quantidadeParticipantes: Int?,
    var statusEvento: StatusEvento,
    var caixa: CaixaEntity?,
    var listaPresenca: ListaPresencaEntity?
)