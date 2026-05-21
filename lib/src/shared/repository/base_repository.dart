// lib/src/shared/repository/base_repository.dart
import 'package:atto_api/src/shared/entity/base_entity.dart';
import 'package:drift/drift.dart';
import 'base_repository_interface.dart';

// E = sua entidade (User, Product…)
// D = o tipo gerado pelo Drift pra linha do banco (UserData, ProductData…)
// C = o tipo gerado pelo Drift pra inserção (UserCompanion, ProductCompanion…)
abstract class BaseRepository<E extends BaseEntity, D extends DataClass, C extends UpdateCompanion<D>>
    implements IBaseRepository<E> {

  final DatabaseAccessor db;
  abstract final TableInfo<Table, D> table;

  BaseRepository(this.db);

  E fromRow(D row);       // Drift row → sua entidade
  C toCompanion(E entity); // sua entidade → Drift companion

  @override
  Future<void> save(E entity) async {
    await db.into(table).insert(toCompanion(entity));
  }

  @override
  Future<void> update(E entity) async {
    await (db.update(table)
      ..where((t) => (t as dynamic).id.equals(entity.id)))
        .write(toCompanion(entity));
  }

  @override
  Future<E?> getById(String id) async {
    final row = await (db.select(table)
      ..where((t) => (t as dynamic).id.equals(id)))
        .getSingleOrNull();
    return row == null ? null : fromRow(row);
  }

  @override
  Future<List<E>> getAll({bool deleted = false}) async {
    final rows = await (db.select(table)
      ..where((t) => deleted
          ? const Constant(true)
          : (t as dynamic).deletadoEm.isNull()))
        .get();
    return rows.map(fromRow).toList();
  }

  @override
  Future<void> delete(E entity) async {
    await (db.delete(table)
      ..where((t) => (t as dynamic).id.equals(entity.id)))
        .go();
  }

  Future<List<E>> query(Expression<bool> Function(dynamic t) filter) async {
    final rows = await (db.select(table)..where(filter)).get();
    return rows.map(fromRow).toList();
  }

  Future<E?> queryOne(Expression<bool> Function(dynamic t) filter) async {
    final results = await query(filter);
    return results.isEmpty ? null : results.first;
  }
}