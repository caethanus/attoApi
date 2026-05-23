import 'package:atto_api/src/shared/entity/base_entity.dart';
import 'package:vaden/vaden.dart';
import 'package:auto_mapper/auto_mapper_annotation.dart';

@DTO()
@AutoMap(target: BaseEntity)
class BaseDto {
  String id;
  DateTime? criadoEm;
  DateTime? atualizadoEm;
  DateTime? deletadoEm;

  BaseDto({required this.id, required this.criadoEm, required this.atualizadoEm, required this.deletadoEm});
}