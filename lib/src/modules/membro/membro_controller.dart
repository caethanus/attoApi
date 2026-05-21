import 'package:atto_api/src/modules/membro/dto/membro_dto.dart';
import 'package:atto_api/src/modules/membro/entity/membro_entity.dart';
import 'package:atto_api/src/modules/membro/service/membro_service_interface.dart';
import 'package:atto_api/src/shared/controller/base_controller.dart';
import 'package:vaden/vaden.dart';

@Api(tag: 'Membro', description: 'Gerenciamento de membros e requisições relacionadas a membros.')
@Controller('/membros')
class MembroController extends BaseController<MembroDto, MembroEntity, IMembroService> {

  MembroController(IMembroService service) : super(service);

  @Get('/')
  Future<Response> getAll() => super.getAll();

  @Get('/<id>')
  Future<Response> getById(@Param() String id) => super.getById(id);

  @Post('/')
  Future<Response> create(@Body() MembroDto membro) async {
    final entity = entityFromDto(membro);
    return await super.save(entity);
  }
}