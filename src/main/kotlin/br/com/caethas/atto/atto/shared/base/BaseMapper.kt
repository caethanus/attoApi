package br.com.caethas.atto.atto.shared.base

abstract class BaseMapper<Entity, DTO> {

    abstract fun toEntity(d: DTO): Entity

    abstract fun toDto(e: Entity): DTO

    abstract fun updateEntity(e: Entity, d: DTO): Entity

    fun toDtoList(es: List<Entity>): List<DTO> {
        return es.map { toDto(it) }
    }
}