import 'package:drift/drift.dart';

class MembroTable extends Table {
  TextColumn get id => text()();

  DateTimeColumn get criadoEm => dateTime().nullable()();

  DateTimeColumn get atualizadoEm => dateTime().nullable()();

  DateTimeColumn get deletadoEm => dateTime().nullable()();

  TextColumn get nomeMembro => text()();

  TextColumn get emailMembro => text().nullable()();

  TextColumn get contatoMembro => text().nullable()();

  TextColumn get enderecoMembro => text().nullable()();

  IntColumn get statusAssociado => integer()();

  IntColumn get quantidadePresenca => integer().withDefault(Constant(0))();

  @override
  Set<Column> get primaryKey => {id};
}
