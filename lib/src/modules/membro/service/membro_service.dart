import 'package:atto_api/src/modules/membro/entity/membro_entity.dart';
import 'package:atto_api/src/modules/membro/repository/membro_repository_interface.dart';
import 'package:atto_api/src/modules/membro/service/membro_service_interface.dart';
import 'package:atto_api/src/shared/service/base_service.dart';
import 'package:vaden/vaden.dart';

@Service()
class MembroService extends BaseService<MembroEntity> implements IMembroService {
  final IMembroRepository repository;
  MembroService(this.repository) : super(repository);

  @override
  Future<MembroEntity> saveOrUpdate(MembroEntity entity) async {
    return await repository.saveOrUpdate(entity);
  }
  
}