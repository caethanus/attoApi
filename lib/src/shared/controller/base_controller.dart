import 'package:atto_api/src/shared/dto/base_dto.dart';
import 'package:atto_api/src/shared/entity/base_entity.dart';
import 'package:atto_api/src/shared/service/base_service_interface.dart';
import 'package:auto_mapper/auto_mapper.dart';
import 'package:vaden/vaden.dart';

abstract class BaseController<D extends BaseDto, E extends BaseEntity, S extends IBaseService<E>> extends MapperController<D, E> {
  final S _service;

  BaseController(this._service);

  Future<Response> getAll() async {
    try {
      final entities = await _service.getAll();
      return Response.ok(dtoListFromEntityList(entities));
    } catch (e) {
      return Response.internalServerError(body: {'error': e.toString()});
    }
  }

  Future<Response> getById(String id) async {
    try {
      final entity = await _service.getById(id);
      if (entity == null) {
        return Response(404, body: {'error': 'Not found'});
      }
      return Response.ok(dtoFromEntity(entity));
    } catch (e) {
      return Response.internalServerError(body: {'error': e.toString()});
    }
  }

  Future<Response> save(E entity) async {
    try {
      await _service.save(entity);
      return Response.ok({'message': 'Created successfully'});
    } catch (e) {
      return Response.internalServerError(body: {'error': e.toString()});
    }
  }

  Future<Response> update(String id, E entity) async {
    try {
      await _service.update(entity);
      return Response.ok({'message': 'Updated successfully'});
    } catch (e) {
      return Response.internalServerError(body: {'error': e.toString()});
    }
  }

  Future<Response> delete(E entity) async {
    try {
      await _service.delete(entity);
      return Response.ok({'message': 'Deleted successfully'});
    } catch (e) {
      return Response.internalServerError(body: {'error': e.toString()});
    }
  }

  Future<Response> saveOrUpdate(D dto) async {
    try {
      final saved = await _service.saveOrUpdate(entityFromDto(dto));
      return Response.ok(dtoFromEntity(saved));
    } catch (e) {
      return Response.internalServerError(body: {'error': e.toString()});
    }
  }
}

class MapperController<D extends BaseDto, E extends BaseEntity> {
  D dtoFromEntity(E entity) {
    return AutoMapper.convert(entity);
  }

  E entityFromDto(D dto) {
    return AutoMapper.convert(dto);
  }

  List<D> dtoListFromEntityList(List<E> entities) {
    return entities.map((entity) => dtoFromEntity(entity)).toList();
  }

  List<E> entityListFromDtoList(List<D> dtos) {
    return dtos.map((dto) => entityFromDto(dto)).toList();
  }
}
