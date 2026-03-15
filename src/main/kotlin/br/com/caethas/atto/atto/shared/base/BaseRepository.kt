package br.com.caethas.atto.atto.shared.base

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import java.util.UUID

@NoRepositoryBean
interface BaseRepository<T : BaseEntity> : JpaRepository<T, UUID> {
    fun deleteSoft(entity: T);
}