import 'package:atto_api/src/modules/membro/entity/membro_entity.dart';
import 'package:atto_api/src/modules/membro/enums/status_associado.dart';
import 'package:atto_api/src/shared/dto/base_dto.dart';
import 'package:auto_mapper/auto_mapper_annotation.dart';
import 'package:vaden/vaden.dart';

@DTO()
@AutoMap(target: MembroEntity)
class MembroDto extends BaseDto {
  final String nomeMembro;
  final String? emailMembro;
  final String? contatoMembro;
  final String? enderecoMembro;
  final StatusAssociado statusAssociado;
  final int quantidadePresenca;

  MembroDto({
    required super.id,
    required super.criadoEm,
    required super.atualizadoEm,
    required super.deletadoEm,
    required this.nomeMembro,
    required this.emailMembro,
    required this.contatoMembro,
    required this.enderecoMembro,
    required this.statusAssociado,
    required this.quantidadePresenca,
  });
}
