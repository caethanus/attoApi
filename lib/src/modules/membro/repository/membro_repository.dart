import 'package:atto_api/config/drift/app_database.dart';
import 'package:atto_api/src/modules/membro/database/table/membro_table.dart';
import 'package:atto_api/src/modules/membro/entity/membro_entity.dart';
import 'package:atto_api/src/modules/membro/enums/status_associado.dart';
import 'package:atto_api/src/modules/membro/repository/membro_repository_interface.dart';
import 'package:atto_api/src/shared/repository/base_repository.dart';
import 'package:drift/drift.dart';
import 'package:vaden/vaden.dart';

@Repository()
class MembroRepository extends BaseRepository<MembroEntity, MembroTableData, MembroTableCompanion> implements IMembroRepository {

  final AppDatabase _db;

  MembroRepository(this._db) : super(_db);

  @override
  MembroEntity fromRow(MembroTableData row) => MembroEntity(
    id:                 row.id,
    nomeMembro:         row.nomeMembro,
    emailMembro:        row.emailMembro,
    contatoMembro:      row.contatoMembro,
    enderecoMembro:     row.enderecoMembro,
    statusAssociado:    StatusAssociado.fromValue(row.statusAssociado),
    quantidadePresenca: row.quantidadePresenca,
    criadoEm:           row.criadoEm,
    atualizadoEm:       row.atualizadoEm,
    deletadoEm:         row.deletadoEm,
  );

  @override
  TableInfo<MembroTable, MembroTableData> get table => _db.membroTable;

  @override
  MembroTableCompanion toCompanion(MembroEntity e) => MembroTableCompanion(
    id:                 Value(e.id),
    nomeMembro:         Value(e.nomeMembro),
    emailMembro:        Value(e.emailMembro),
    contatoMembro:      Value(e.contatoMembro),
    enderecoMembro:     Value(e.enderecoMembro),
    statusAssociado:    Value(e.statusAssociado.value),
    quantidadePresenca: Value(e.quantidadePresenca),
    criadoEm:           Value(e.criadoEm!),
    atualizadoEm:       Value(e.atualizadoEm),
    deletadoEm:         Value(e.deletadoEm),
  );
}