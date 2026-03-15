package br.com.caethas.atto.atto.shared.base.`interface`

import br.com.caethas.atto.atto.shared.base.BaseEntity
import java.util.UUID

interface IBaseService<T : BaseEntity> {
    fun upsert(entity : T) : T
    fun findById(id: UUID) : T
    fun findAll(): List<T>
    fun deleteSoft(id: UUID)
}