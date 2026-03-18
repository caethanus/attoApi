package br.com.caethas.atto.atto.modules.membro.entity

import br.com.caethas.atto.atto.modules.membro.enums.StatusAssociado
import br.com.caethas.atto.atto.modules.usuario.entity.UsuarioEntity
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import org.hibernate.sql.results.graph.Fetch

@Entity
@Table(name = "membros")
data class MembroEntity(
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membro_usuario_id", nullable = false)
    var usuario: UsuarioEntity,

    @Column(name = "nome_membro", nullable = false, updatable = true)
    var nomeMembro: String,

    @Column(name = "email_membro", nullable = true, updatable = true)
    var emailMembro: String?,

    @Column(name = "contato_membro", nullable = true, updatable = true)
    var contatoMembro: String?,

    @Column(name = "endereco_membro", nullable = true, updatable = true)
    var enderecoMembro: String?,

    @Enumerated(EnumType.STRING)
    @Column(name = "status_associado", nullable = false, updatable = true)
    var statusAssociado: StatusAssociado,
) : BaseEntity()