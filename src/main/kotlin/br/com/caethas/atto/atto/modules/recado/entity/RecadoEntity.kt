package br.com.caethas.atto.atto.modules.recado.entity

import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "recados")
class RecadoEntity(
    @Column(name = "titulo_string", nullable = false, updatable = true)
    var tituloString: String,

    @Column(name = "descricao_recado", nullable = false, updatable = true)
    var descricaoRecado: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recado_autor_recado_id", nullable = false, updatable = true)
    var autorRecado: MembroEntity,

    @Column(name = "recado_urgente", nullable = false, updatable = true)
    var recadoUrgente: Boolean
) : BaseEntity()