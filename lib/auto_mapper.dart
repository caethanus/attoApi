// GENERATED CODE - DO NOT MODIFY BY HAND
import 'package:auto_mapper/auto_mapper.dart';

import 'package:atto_api/src/shared/entity/base_entity.dart';
import 'package:atto_api/src/shared/dto/base_dto.dart';

class GeneratedMappings {
  static void register() {
    AutoMapper.add<BaseDto, BaseEntity>((BaseDto source) => BaseEntity(id: source.id, criadoEm: source.criadoEm, atualizadoEm: source.atualizadoEm, deletadoEm: source.deletadoEm));

    AutoMapper.add<BaseEntity, BaseDto>((BaseEntity source) => BaseDto(id: source.id, criadoEm: source.criadoEm, atualizadoEm: source.atualizadoEm, deletadoEm: source.deletadoEm));
  }
}
