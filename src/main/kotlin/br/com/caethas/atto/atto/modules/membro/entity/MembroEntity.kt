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

@Entity
@Table(name = "membros")
data class MembroEntity(
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    var usuario: UsuarioEntity,

    @Column(name = "nome_membro")
    var nomeMembro: String,

    @Column(name = "email_membro")
    var emailMembro: String?,

    @Column(name = "contato_membro")
    var contatoMembro: String?,

    @Column(name = "endereco_membro")
    var enderecoMembro: String?,

    @Enumerated(EnumType.STRING)
    @Column(name = "status_associado")
    var statusAssociado: StatusAssociado,
) : BaseEntity()