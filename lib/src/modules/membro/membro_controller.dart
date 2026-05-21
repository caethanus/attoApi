import 'package:atto_api/src/modules/membro/entity/membro_entity.dart';
import 'package:atto_api/src/modules/membro/service/membro_service_interface.dart';
import 'package:vaden/vaden.dart';

@Controller('/membros')
class MembroController {
  final IMembroService _service;

  MembroController(this._service);

  @Get('/')
  Future<Response> getAll() async {
    final membros = await _service.getAll();
    return Response.ok(membros);
  }

  @Get('/<id>')
  Future<Response> getById(@Param() String id) async {
    final membro = await _service.getById(id);
    return Response.ok(membro);
  }

  @Post('/')
  Future<Response> create(@Body() MembroEntity membro) async {
    await _service.save(membro);
    return Response.ok(membro);
  }

}