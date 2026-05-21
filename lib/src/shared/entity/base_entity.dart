import 'package:atto_api/src/shared/dto/base_dto.dart';
import 'package:auto_mapper/auto_mapper_annotation.dart';
import 'package:vaden/vaden.dart';

@DTO()
@AutoMap(target: BaseDto)
class BaseEntity {
  String id;
  DateTime? criadoEm;
  DateTime? atualizadoEm;
  DateTime? deletadoEm;

  BaseEntity({required this.id, required this.criadoEm, required this.atualizadoEm, required this.deletadoEm});
}
