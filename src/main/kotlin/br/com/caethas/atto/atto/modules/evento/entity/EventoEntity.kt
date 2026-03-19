package br.com.caethas.atto.atto.modules.evento.entity

import br.com.caethas.atto.atto.modules.caixa.entity.CaixaEntity
import br.com.caethas.atto.atto.modules.evento.enums.StatusEvento
import br.com.caethas.atto.atto.modules.lista_presenca.entity.ListaPresencaEntity
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "eventos")
class EventoEntity(
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
    var statusEvento: StatusEvento,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caixa_id", nullable = true, unique = true, updatable = true)
    var caixa: CaixaEntity?,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lista_presenca_id", nullable = true, unique = true, updatable = true)
    var listaPresenca: ListaPresencaEntity?

) : BaseEntity()