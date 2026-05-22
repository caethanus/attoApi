import 'package:atto_api/src/modules/membro/dto/membro_dto.dart';
import 'package:atto_api/src/modules/membro/enums/status_associado.dart';
import 'package:atto_api/src/shared/entity/base_entity.dart';
import 'package:auto_mapper/auto_mapper_annotation.dart';

@AutoMap(target: MembroDto)
class MembroEntity extends BaseEntity {
  final String nomeMembro;
  final String? emailMembro;
  final String? contatoMembro;
  final String? enderecoMembro;
  final StatusAssociado statusAssociado;
  final int quantidadePresenca;

  MembroEntity({
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

  MembroEntity copyWith({
    String? nomeMembro,
    String? emailMembro,
    String? contatoMembro,
    String? enderecoMembro,
    StatusAssociado? statusAssociado,
    int? quantidadePresenca,
    DateTime? deletadoEm,
  }) {
    return MembroEntity(
      id: id,
      criadoEm: criadoEm,
      atualizadoEm: DateTime.now(),
      deletadoEm: deletadoEm ?? this.deletadoEm,
      nomeMembro: nomeMembro ?? this.nomeMembro,
      emailMembro: emailMembro ?? this.emailMembro,
      contatoMembro: contatoMembro ?? this.contatoMembro,
      enderecoMembro: enderecoMembro ?? this.enderecoMembro,
      statusAssociado: statusAssociado ?? this.statusAssociado,
      quantidadePresenca: quantidadePresenca ?? this.quantidadePresenca,
    );
  }
}
