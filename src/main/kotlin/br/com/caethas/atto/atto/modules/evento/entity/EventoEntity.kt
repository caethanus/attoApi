package br.com.caethas.atto.atto.modules.evento.entity

import br.com.caethas.atto.atto.modules.evento.enums.StatusEvento
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "eventos")
data class EventoEntity(
    @Column(name = "titulo_evento", nullable = false, updatable = true)
    var tituloEvento: String,

    @Column("descricao_evento", nullable = false, updatable = true)
    var descricaoEvento: String,

    @Column(name = "data_hora_realizacao_evento", nullable = false, updatable = true)
    val dataHoraRealizacaoEvento: LocalDateTime,

    @Column(name = "data_hora_final_evento", nullable = false, updatable = true)
    val dataHoraFinalEvento: LocalDateTime,

    @Column(name = "local_evento", nullable = false, updatable = true)
    var localEvento: String,

    @Column(name = "quantidade_participantes", nullable = true, updatable = true)
    var quantidadeParticipantes: Int?,

    @Enumerated(EnumType.STRING)
    @Column(name = "status_evento", nullable = false, updatable = true)
    var statusEvento: StatusEvento

    //TODO: Incluir a entidade do caixa quando for implementada, depois ver a lista de presenca

) : BaseEntity()