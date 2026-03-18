package br.com.caethas.atto.atto.shared.base

abstract class BaseMapper<Entity, Request : BaseDto.FromDto, Response : BaseDto.ToDto> {

    abstract fun fromDto(request: Request): Entity

    abstract fun toDto(entity: Entity): Response

    fun toDtoList(entities: List<Entity>): List<Response> {
        return entities.map { toDto(it) }
    }
}