import 'package:atto_api/src/shared/entity/base_entity.dart';
import 'package:atto_api/src/shared/repository/base_repository_interface.dart';
import 'package:atto_api/src/shared/service/base_service_interface.dart';

abstract class BaseService<E extends BaseEntity> implements IBaseService<E> {
  final IBaseRepository<E> repository;

  BaseService(this.repository);

  @override
  Future<void> save(E entity) => repository.save(entity);

  @override
  Future<void> update(E entity) => repository.update(entity);

  @override
  Future<void> delete(E entity) => repository.delete(entity);

  @override
  Future<List<E>> getAll({bool deleted = false}) => repository.getAll(deleted: deleted);

  @override
  Future<E?> getById(String id) async {
    return await repository.getById(id);
  }
}
