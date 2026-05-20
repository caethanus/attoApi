package br.com.caethas.atto.atto.modules.membro.entity

import br.com.caethas.atto.atto.modules.membro.dto.MembroDto
import br.com.caethas.atto.atto.modules.membro.enums.StatusAssociado
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "membros")
class MembroEntity(
    @Column(name = "membros_id", nullable = false, updatable = false, unique = true)
    var membrosId: UUID? = null, // ID externo vindo do app

    @Column(name = "nome_membro", nullable = false, updatable = true)
    var nomeMembro: String = "",

    @Column(name = "email_membro", nullable = true, updatable = true)
    var emailMembro: String? = null,

    @Column(name = "contato_membro", nullable = true, updatable = true)
    var contatoMembro: String? = null,

    @Column(name = "endereco_membro", nullable = true, updatable = true)
    var enderecoMembro: String? = null,

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status_associado", nullable = false, updatable = true)
    var statusAssociado: StatusAssociado = StatusAssociado.ATIVO,
) : BaseEntity() {
    fun toDto() = MembroDto(
        id = this.id,
        membrosId = this.membrosId,
        nomeMembro = this.nomeMembro,
        emailMembro = this.emailMembro,
        contatoMembro = this.contatoMembro,
        enderecoMembro = this.enderecoMembro,
        statusAssociado = this.statusAssociado.value,
        criadoEm = this.criadoEm,
        atualizadoEm = this.atualizadoEm,
        deletadoEm = this.deletadoEm
    )
}