package br.com.caethas.atto.atto.modules.registro_presenca.entity

import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "registros_presenca")
class RegistroPresencaEntity(
    @Column(name = "registro_presenca_id", nullable = false, updatable = false, unique = true)
    var registroPresencaId: UUID? = null,

    @Column(name = "id_membro", nullable = false, updatable = false)
    var membroId: UUID,

    @Column(name = "presente", nullable = false, updatable = true)
    var presente: Boolean = false,

    @Column(name = "id_lista_presenca", nullable = false, updatable = false)
    var listaPresencaId: UUID,

) : BaseEntity() {
    fun toDto() = RegistroPresencaDto(
        id = this.id,
        registroPresencaId = this.registroPresencaId,
        criadoEm = this.criadoEm,
        atualizadoEm = this.atualizadoEm,
        deletadoEm = this.deletadoEm
    )
}