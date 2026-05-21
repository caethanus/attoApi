import 'package:atto_api/src/shared/entity/base_entity.dart';

abstract class IBaseService<E extends BaseEntity> {
  Future<E> saveOrUpdate(E entity);

  Future<List<E>> getAll({bool deleted = false});

  Future<E?> getById(String id);

  Future<void> save(E entity);

  Future<void> update(E entity);

  Future<void> delete(E entity);
}
