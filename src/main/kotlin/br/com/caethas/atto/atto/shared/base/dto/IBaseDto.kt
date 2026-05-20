package br.com.caethas.atto.atto.shared.base.dto

import br.com.caethas.atto.atto.shared.base.BaseEntity
import java.util.UUID

interface IBaseDto<T : BaseEntity> {
    var id: UUID?
    fun toEntity(): T
}