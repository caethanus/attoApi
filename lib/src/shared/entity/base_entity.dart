import 'package:vaden/vaden.dart';

@DTO()
class BaseEntity {
  String id;
  DateTime? criadoEm;
  DateTime? atualizadoEm;
  DateTime? deletadoEm;

  BaseEntity({required this.id, required this.criadoEm, required this.atualizadoEm, required this.deletadoEm});
}
