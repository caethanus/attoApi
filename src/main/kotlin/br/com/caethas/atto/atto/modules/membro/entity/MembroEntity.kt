package br.com.caethas.atto.atto.modules.membro.entity

import br.com.caethas.atto.atto.modules.membro.dto.MembroDto
import br.com.caethas.atto.atto.modules.membro.enums.StatusAssociado
import br.com.caethas.atto.atto.shared.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table

@Entity
@Table(name = "membros")
class MembroEntity(
    @Column(name = "nome_membro", nullable = false, updatable = true)
    var nomeMembro: String,

    @Column(name = "email_membro", nullable = true, updatable = true)
    var emailMembro: String?,

    @Column(name = "contato_membro", nullable = true, updatable = true)
    var contatoMembro: String?,

    @Column(name = "endereco_membro", nullable = true, updatable = true)
    var enderecoMembro: String?,

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status_associado", nullable = false, updatable = true)
    var statusAssociado: StatusAssociado,
) : BaseEntity() {
    fun toDto() = MembroDto(
        id = this.id,
        criadoEm = this.criadoEm,
        atualizadoEm = this.atualizadoEm,
        deletadoEm = this.deletadoEm,
        nomeMembro = this.nomeMembro,
        emailMembro = this.emailMembro,
        contatoMembro = this.contatoMembro,
        enderecoMembro = this.enderecoMembro,
        statusAssociado = this.statusAssociado.value
    )
}