// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'app_database.dart';

// ignore_for_file: type=lint
class $MembroTableTable extends MembroTable
    with TableInfo<$MembroTableTable, MembroTableData> {
  @override
  final GeneratedDatabase attachedDatabase;
  final String? _alias;
  $MembroTableTable(this.attachedDatabase, [this._alias]);
  static const VerificationMeta _idMeta = const VerificationMeta('id');
  @override
  late final GeneratedColumn<String> id = GeneratedColumn<String>(
      'id', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _criadoEmMeta =
      const VerificationMeta('criadoEm');
  @override
  late final GeneratedColumn<DateTime> criadoEm = GeneratedColumn<DateTime>(
      'criado_em', aliasedName, true,
      type: DriftSqlType.dateTime, requiredDuringInsert: false);
  static const VerificationMeta _atualizadoEmMeta =
      const VerificationMeta('atualizadoEm');
  @override
  late final GeneratedColumn<DateTime> atualizadoEm = GeneratedColumn<DateTime>(
      'atualizado_em', aliasedName, true,
      type: DriftSqlType.dateTime, requiredDuringInsert: false);
  static const VerificationMeta _deletadoEmMeta =
      const VerificationMeta('deletadoEm');
  @override
  late final GeneratedColumn<DateTime> deletadoEm = GeneratedColumn<DateTime>(
      'deletado_em', aliasedName, true,
      type: DriftSqlType.dateTime, requiredDuringInsert: false);
  static const VerificationMeta _nomeMembroMeta =
      const VerificationMeta('nomeMembro');
  @override
  late final GeneratedColumn<String> nomeMembro = GeneratedColumn<String>(
      'nome_membro', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _emailMembroMeta =
      const VerificationMeta('emailMembro');
  @override
  late final GeneratedColumn<String> emailMembro = GeneratedColumn<String>(
      'email_membro', aliasedName, true,
      type: DriftSqlType.string, requiredDuringInsert: false);
  static const VerificationMeta _contatoMembroMeta =
      const VerificationMeta('contatoMembro');
  @override
  late final GeneratedColumn<String> contatoMembro = GeneratedColumn<String>(
      'contato_membro', aliasedName, true,
      type: DriftSqlType.string, requiredDuringInsert: false);
  static const VerificationMeta _enderecoMembroMeta =
      const VerificationMeta('enderecoMembro');
  @override
  late final GeneratedColumn<String> enderecoMembro = GeneratedColumn<String>(
      'endereco_membro', aliasedName, true,
      type: DriftSqlType.string, requiredDuringInsert: false);
  static const VerificationMeta _statusAssociadoMeta =
      const VerificationMeta('statusAssociado');
  @override
  late final GeneratedColumn<int> statusAssociado = GeneratedColumn<int>(
      'status_associado', aliasedName, false,
      type: DriftSqlType.int, requiredDuringInsert: true);
  static const VerificationMeta _quantidadePresencaMeta =
      const VerificationMeta('quantidadePresenca');
  @override
  late final GeneratedColumn<int> quantidadePresenca = GeneratedColumn<int>(
      'quantidade_presenca', aliasedName, false,
      type: DriftSqlType.int,
      requiredDuringInsert: false,
      defaultValue: Constant(0));
  @override
  List<GeneratedColumn> get $columns => [
        id,
        criadoEm,
        atualizadoEm,
        deletadoEm,
        nomeMembro,
        emailMembro,
        contatoMembro,
        enderecoMembro,
        statusAssociado,
        quantidadePresenca
      ];
  @override
  String get aliasedName => _alias ?? actualTableName;
  @override
  String get actualTableName => $name;
  static const String $name = 'membro_table';
  @override
  VerificationContext validateIntegrity(Insertable<MembroTableData> instance,
      {bool isInserting = false}) {
    final context = VerificationContext();
    final data = instance.toColumns(true);
    if (data.containsKey('id')) {
      context.handle(_idMeta, id.isAcceptableOrUnknown(data['id']!, _idMeta));
    } else if (isInserting) {
      context.missing(_idMeta);
    }
    if (data.containsKey('criado_em')) {
      context.handle(_criadoEmMeta,
          criadoEm.isAcceptableOrUnknown(data['criado_em']!, _criadoEmMeta));
    }
    if (data.containsKey('atualizado_em')) {
      context.handle(
          _atualizadoEmMeta,
          atualizadoEm.isAcceptableOrUnknown(
              data['atualizado_em']!, _atualizadoEmMeta));
    }
    if (data.containsKey('deletado_em')) {
      context.handle(
          _deletadoEmMeta,
          deletadoEm.isAcceptableOrUnknown(
              data['deletado_em']!, _deletadoEmMeta));
    }
    if (data.containsKey('nome_membro')) {
      context.handle(
          _nomeMembroMeta,
          nomeMembro.isAcceptableOrUnknown(
              data['nome_membro']!, _nomeMembroMeta));
    } else if (isInserting) {
      context.missing(_nomeMembroMeta);
    }
    if (data.containsKey('email_membro')) {
      context.handle(
          _emailMembroMeta,
          emailMembro.isAcceptableOrUnknown(
              data['email_membro']!, _emailMembroMeta));
    }
    if (data.containsKey('contato_membro')) {
      context.handle(
          _contatoMembroMeta,
          contatoMembro.isAcceptableOrUnknown(
              data['contato_membro']!, _contatoMembroMeta));
    }
    if (data.containsKey('endereco_membro')) {
      context.handle(
          _enderecoMembroMeta,
          enderecoMembro.isAcceptableOrUnknown(
              data['endereco_membro']!, _enderecoMembroMeta));
    }
    if (data.containsKey('status_associado')) {
      context.handle(
          _statusAssociadoMeta,
          statusAssociado.isAcceptableOrUnknown(
              data['status_associado']!, _statusAssociadoMeta));
    } else if (isInserting) {
      context.missing(_statusAssociadoMeta);
    }
    if (data.containsKey('quantidade_presenca')) {
      context.handle(
          _quantidadePresencaMeta,
          quantidadePresenca.isAcceptableOrUnknown(
              data['quantidade_presenca']!, _quantidadePresencaMeta));
    }
    return context;
  }

  @override
  Set<GeneratedColumn> get $primaryKey => {id};
  @override
  MembroTableData map(Map<String, dynamic> data, {String? tablePrefix}) {
    final effectivePrefix = tablePrefix != null ? '$tablePrefix.' : '';
    return MembroTableData(
      id: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}id'])!,
      criadoEm: attachedDatabase.typeMapping
          .read(DriftSqlType.dateTime, data['${effectivePrefix}criado_em']),
      atualizadoEm: attachedDatabase.typeMapping
          .read(DriftSqlType.dateTime, data['${effectivePrefix}atualizado_em']),
      deletadoEm: attachedDatabase.typeMapping
          .read(DriftSqlType.dateTime, data['${effectivePrefix}deletado_em']),
      nomeMembro: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}nome_membro'])!,
      emailMembro: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}email_membro']),
      contatoMembro: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}contato_membro']),
      enderecoMembro: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}endereco_membro']),
      statusAssociado: attachedDatabase.typeMapping
          .read(DriftSqlType.int, data['${effectivePrefix}status_associado'])!,
      quantidadePresenca: attachedDatabase.typeMapping.read(
          DriftSqlType.int, data['${effectivePrefix}quantidade_presenca'])!,
    );
  }

  @override
  $MembroTableTable createAlias(String alias) {
    return $MembroTableTable(attachedDatabase, alias);
  }
}

class MembroTableData extends DataClass implements Insertable<MembroTableData> {
  final String id;
  final DateTime? criadoEm;
  final DateTime? atualizadoEm;
  final DateTime? deletadoEm;
  final String nomeMembro;
  final String? emailMembro;
  final String? contatoMembro;
  final String? enderecoMembro;
  final int statusAssociado;
  final int quantidadePresenca;
  const MembroTableData(
      {required this.id,
      this.criadoEm,
      this.atualizadoEm,
      this.deletadoEm,
      required this.nomeMembro,
      this.emailMembro,
      this.contatoMembro,
      this.enderecoMembro,
      required this.statusAssociado,
      required this.quantidadePresenca});
  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    map['id'] = Variable<String>(id);
    if (!nullToAbsent || criadoEm != null) {
      map['criado_em'] = Variable<DateTime>(criadoEm);
    }
    if (!nullToAbsent || atualizadoEm != null) {
      map['atualizado_em'] = Variable<DateTime>(atualizadoEm);
    }
    if (!nullToAbsent || deletadoEm != null) {
      map['deletado_em'] = Variable<DateTime>(deletadoEm);
    }
    map['nome_membro'] = Variable<String>(nomeMembro);
    if (!nullToAbsent || emailMembro != null) {
      map['email_membro'] = Variable<String>(emailMembro);
    }
    if (!nullToAbsent || contatoMembro != null) {
      map['contato_membro'] = Variable<String>(contatoMembro);
    }
    if (!nullToAbsent || enderecoMembro != null) {
      map['endereco_membro'] = Variable<String>(enderecoMembro);
    }
    map['status_associado'] = Variable<int>(statusAssociado);
    map['quantidade_presenca'] = Variable<int>(quantidadePresenca);
    return map;
  }

  MembroTableCompanion toCompanion(bool nullToAbsent) {
    return MembroTableCompanion(
      id: Value(id),
      criadoEm: criadoEm == null && nullToAbsent
          ? const Value.absent()
          : Value(criadoEm),
      atualizadoEm: atualizadoEm == null && nullToAbsent
          ? const Value.absent()
          : Value(atualizadoEm),
      deletadoEm: deletadoEm == null && nullToAbsent
          ? const Value.absent()
          : Value(deletadoEm),
      nomeMembro: Value(nomeMembro),
      emailMembro: emailMembro == null && nullToAbsent
          ? const Value.absent()
          : Value(emailMembro),
      contatoMembro: contatoMembro == null && nullToAbsent
          ? const Value.absent()
          : Value(contatoMembro),
      enderecoMembro: enderecoMembro == null && nullToAbsent
          ? const Value.absent()
          : Value(enderecoMembro),
      statusAssociado: Value(statusAssociado),
      quantidadePresenca: Value(quantidadePresenca),
    );
  }

  factory MembroTableData.fromJson(Map<String, dynamic> json,
      {ValueSerializer? serializer}) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return MembroTableData(
      id: serializer.fromJson<String>(json['id']),
      criadoEm: serializer.fromJson<DateTime?>(json['criadoEm']),
      atualizadoEm: serializer.fromJson<DateTime?>(json['atualizadoEm']),
      deletadoEm: serializer.fromJson<DateTime?>(json['deletadoEm']),
      nomeMembro: serializer.fromJson<String>(json['nomeMembro']),
      emailMembro: serializer.fromJson<String?>(json['emailMembro']),
      contatoMembro: serializer.fromJson<String?>(json['contatoMembro']),
      enderecoMembro: serializer.fromJson<String?>(json['enderecoMembro']),
      statusAssociado: serializer.fromJson<int>(json['statusAssociado']),
      quantidadePresenca: serializer.fromJson<int>(json['quantidadePresenca']),
    );
  }
  @override
  Map<String, dynamic> toJson({ValueSerializer? serializer}) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return <String, dynamic>{
      'id': serializer.toJson<String>(id),
      'criadoEm': serializer.toJson<DateTime?>(criadoEm),
      'atualizadoEm': serializer.toJson<DateTime?>(atualizadoEm),
      'deletadoEm': serializer.toJson<DateTime?>(deletadoEm),
      'nomeMembro': serializer.toJson<String>(nomeMembro),
      'emailMembro': serializer.toJson<String?>(emailMembro),
      'contatoMembro': serializer.toJson<String?>(contatoMembro),
      'enderecoMembro': serializer.toJson<String?>(enderecoMembro),
      'statusAssociado': serializer.toJson<int>(statusAssociado),
      'quantidadePresenca': serializer.toJson<int>(quantidadePresenca),
    };
  }

  MembroTableData copyWith(
          {String? id,
          Value<DateTime?> criadoEm = const Value.absent(),
          Value<DateTime?> atualizadoEm = const Value.absent(),
          Value<DateTime?> deletadoEm = const Value.absent(),
          String? nomeMembro,
          Value<String?> emailMembro = const Value.absent(),
          Value<String?> contatoMembro = const Value.absent(),
          Value<String?> enderecoMembro = const Value.absent(),
          int? statusAssociado,
          int? quantidadePresenca}) =>
      MembroTableData(
        id: id ?? this.id,
        criadoEm: criadoEm.present ? criadoEm.value : this.criadoEm,
        atualizadoEm:
            atualizadoEm.present ? atualizadoEm.value : this.atualizadoEm,
        deletadoEm: deletadoEm.present ? deletadoEm.value : this.deletadoEm,
        nomeMembro: nomeMembro ?? this.nomeMembro,
        emailMembro: emailMembro.present ? emailMembro.value : this.emailMembro,
        contatoMembro:
            contatoMembro.present ? contatoMembro.value : this.contatoMembro,
        enderecoMembro:
            enderecoMembro.present ? enderecoMembro.value : this.enderecoMembro,
        statusAssociado: statusAssociado ?? this.statusAssociado,
        quantidadePresenca: quantidadePresenca ?? this.quantidadePresenca,
      );
  MembroTableData copyWithCompanion(MembroTableCompanion data) {
    return MembroTableData(
      id: data.id.present ? data.id.value : this.id,
      criadoEm: data.criadoEm.present ? data.criadoEm.value : this.criadoEm,
      atualizadoEm: data.atualizadoEm.present
          ? data.atualizadoEm.value
          : this.atualizadoEm,
      deletadoEm:
          data.deletadoEm.present ? data.deletadoEm.value : this.deletadoEm,
      nomeMembro:
          data.nomeMembro.present ? data.nomeMembro.value : this.nomeMembro,
      emailMembro:
          data.emailMembro.present ? data.emailMembro.value : this.emailMembro,
      contatoMembro: data.contatoMembro.present
          ? data.contatoMembro.value
          : this.contatoMembro,
      enderecoMembro: data.enderecoMembro.present
          ? data.enderecoMembro.value
          : this.enderecoMembro,
      statusAssociado: data.statusAssociado.present
          ? data.statusAssociado.value
          : this.statusAssociado,
      quantidadePresenca: data.quantidadePresenca.present
          ? data.quantidadePresenca.value
          : this.quantidadePresenca,
    );
  }

  @override
  String toString() {
    return (StringBuffer('MembroTableData(')
          ..write('id: $id, ')
          ..write('criadoEm: $criadoEm, ')
          ..write('atualizadoEm: $atualizadoEm, ')
          ..write('deletadoEm: $deletadoEm, ')
          ..write('nomeMembro: $nomeMembro, ')
          ..write('emailMembro: $emailMembro, ')
          ..write('contatoMembro: $contatoMembro, ')
          ..write('enderecoMembro: $enderecoMembro, ')
          ..write('statusAssociado: $statusAssociado, ')
          ..write('quantidadePresenca: $quantidadePresenca')
          ..write(')'))
        .toString();
  }

  @override
  int get hashCode => Object.hash(
      id,
      criadoEm,
      atualizadoEm,
      deletadoEm,
      nomeMembro,
      emailMembro,
      contatoMembro,
      enderecoMembro,
      statusAssociado,
      quantidadePresenca);
  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      (other is MembroTableData &&
          other.id == this.id &&
          other.criadoEm == this.criadoEm &&
          other.atualizadoEm == this.atualizadoEm &&
          other.deletadoEm == this.deletadoEm &&
          other.nomeMembro == this.nomeMembro &&
          other.emailMembro == this.emailMembro &&
          other.contatoMembro == this.contatoMembro &&
          other.enderecoMembro == this.enderecoMembro &&
          other.statusAssociado == this.statusAssociado &&
          other.quantidadePresenca == this.quantidadePresenca);
}

class MembroTableCompanion extends UpdateCompanion<MembroTableData> {
  final Value<String> id;
  final Value<DateTime?> criadoEm;
  final Value<DateTime?> atualizadoEm;
  final Value<DateTime?> deletadoEm;
  final Value<String> nomeMembro;
  final Value<String?> emailMembro;
  final Value<String?> contatoMembro;
  final Value<String?> enderecoMembro;
  final Value<int> statusAssociado;
  final Value<int> quantidadePresenca;
  final Value<int> rowid;
  const MembroTableCompanion({
    this.id = const Value.absent(),
    this.criadoEm = const Value.absent(),
    this.atualizadoEm = const Value.absent(),
    this.deletadoEm = const Value.absent(),
    this.nomeMembro = const Value.absent(),
    this.emailMembro = const Value.absent(),
    this.contatoMembro = const Value.absent(),
    this.enderecoMembro = const Value.absent(),
    this.statusAssociado = const Value.absent(),
    this.quantidadePresenca = const Value.absent(),
    this.rowid = const Value.absent(),
  });
  MembroTableCompanion.insert({
    required String id,
    this.criadoEm = const Value.absent(),
    this.atualizadoEm = const Value.absent(),
    this.deletadoEm = const Value.absent(),
    required String nomeMembro,
    this.emailMembro = const Value.absent(),
    this.contatoMembro = const Value.absent(),
    this.enderecoMembro = const Value.absent(),
    required int statusAssociado,
    this.quantidadePresenca = const Value.absent(),
    this.rowid = const Value.absent(),
  })  : id = Value(id),
        nomeMembro = Value(nomeMembro),
        statusAssociado = Value(statusAssociado);
  static Insertable<MembroTableData> custom({
    Expression<String>? id,
    Expression<DateTime>? criadoEm,
    Expression<DateTime>? atualizadoEm,
    Expression<DateTime>? deletadoEm,
    Expression<String>? nomeMembro,
    Expression<String>? emailMembro,
    Expression<String>? contatoMembro,
    Expression<String>? enderecoMembro,
    Expression<int>? statusAssociado,
    Expression<int>? quantidadePresenca,
    Expression<int>? rowid,
  }) {
    return RawValuesInsertable({
      if (id != null) 'id': id,
      if (criadoEm != null) 'criado_em': criadoEm,
      if (atualizadoEm != null) 'atualizado_em': atualizadoEm,
      if (deletadoEm != null) 'deletado_em': deletadoEm,
      if (nomeMembro != null) 'nome_membro': nomeMembro,
      if (emailMembro != null) 'email_membro': emailMembro,
      if (contatoMembro != null) 'contato_membro': contatoMembro,
      if (enderecoMembro != null) 'endereco_membro': enderecoMembro,
      if (statusAssociado != null) 'status_associado': statusAssociado,
      if (quantidadePresenca != null) 'quantidade_presenca': quantidadePresenca,
      if (rowid != null) 'rowid': rowid,
    });
  }

  MembroTableCompanion copyWith(
      {Value<String>? id,
      Value<DateTime?>? criadoEm,
      Value<DateTime?>? atualizadoEm,
      Value<DateTime?>? deletadoEm,
      Value<String>? nomeMembro,
      Value<String?>? emailMembro,
      Value<String?>? contatoMembro,
      Value<String?>? enderecoMembro,
      Value<int>? statusAssociado,
      Value<int>? quantidadePresenca,
      Value<int>? rowid}) {
    return MembroTableCompanion(
      id: id ?? this.id,
      criadoEm: criadoEm ?? this.criadoEm,
      atualizadoEm: atualizadoEm ?? this.atualizadoEm,
      deletadoEm: deletadoEm ?? this.deletadoEm,
      nomeMembro: nomeMembro ?? this.nomeMembro,
      emailMembro: emailMembro ?? this.emailMembro,
      contatoMembro: contatoMembro ?? this.contatoMembro,
      enderecoMembro: enderecoMembro ?? this.enderecoMembro,
      statusAssociado: statusAssociado ?? this.statusAssociado,
      quantidadePresenca: quantidadePresenca ?? this.quantidadePresenca,
      rowid: rowid ?? this.rowid,
    );
  }

  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (id.present) {
      map['id'] = Variable<String>(id.value);
    }
    if (criadoEm.present) {
      map['criado_em'] = Variable<DateTime>(criadoEm.value);
    }
    if (atualizadoEm.present) {
      map['atualizado_em'] = Variable<DateTime>(atualizadoEm.value);
    }
    if (deletadoEm.present) {
      map['deletado_em'] = Variable<DateTime>(deletadoEm.value);
    }
    if (nomeMembro.present) {
      map['nome_membro'] = Variable<String>(nomeMembro.value);
    }
    if (emailMembro.present) {
      map['email_membro'] = Variable<String>(emailMembro.value);
    }
    if (contatoMembro.present) {
      map['contato_membro'] = Variable<String>(contatoMembro.value);
    }
    if (enderecoMembro.present) {
      map['endereco_membro'] = Variable<String>(enderecoMembro.value);
    }
    if (statusAssociado.present) {
      map['status_associado'] = Variable<int>(statusAssociado.value);
    }
    if (quantidadePresenca.present) {
      map['quantidade_presenca'] = Variable<int>(quantidadePresenca.value);
    }
    if (rowid.present) {
      map['rowid'] = Variable<int>(rowid.value);
    }
    return map;
  }

  @override
  String toString() {
    return (StringBuffer('MembroTableCompanion(')
          ..write('id: $id, ')
          ..write('criadoEm: $criadoEm, ')
          ..write('atualizadoEm: $atualizadoEm, ')
          ..write('deletadoEm: $deletadoEm, ')
          ..write('nomeMembro: $nomeMembro, ')
          ..write('emailMembro: $emailMembro, ')
          ..write('contatoMembro: $contatoMembro, ')
          ..write('enderecoMembro: $enderecoMembro, ')
          ..write('statusAssociado: $statusAssociado, ')
          ..write('quantidadePresenca: $quantidadePresenca, ')
          ..write('rowid: $rowid')
          ..write(')'))
        .toString();
  }
}

abstract class _$AppDatabase extends GeneratedDatabase {
  _$AppDatabase(QueryExecutor e) : super(e);
  $AppDatabaseManager get managers => $AppDatabaseManager(this);
  late final $MembroTableTable membroTable = $MembroTableTable(this);
  @override
  Iterable<TableInfo<Table, Object?>> get allTables =>
      allSchemaEntities.whereType<TableInfo<Table, Object?>>();
  @override
  List<DatabaseSchemaEntity> get allSchemaEntities => [membroTable];
}

typedef $$MembroTableTableCreateCompanionBuilder = MembroTableCompanion
    Function({
  required String id,
  Value<DateTime?> criadoEm,
  Value<DateTime?> atualizadoEm,
  Value<DateTime?> deletadoEm,
  required String nomeMembro,
  Value<String?> emailMembro,
  Value<String?> contatoMembro,
  Value<String?> enderecoMembro,
  required int statusAssociado,
  Value<int> quantidadePresenca,
  Value<int> rowid,
});
typedef $$MembroTableTableUpdateCompanionBuilder = MembroTableCompanion
    Function({
  Value<String> id,
  Value<DateTime?> criadoEm,
  Value<DateTime?> atualizadoEm,
  Value<DateTime?> deletadoEm,
  Value<String> nomeMembro,
  Value<String?> emailMembro,
  Value<String?> contatoMembro,
  Value<String?> enderecoMembro,
  Value<int> statusAssociado,
  Value<int> quantidadePresenca,
  Value<int> rowid,
});

class $$MembroTableTableFilterComposer
    extends Composer<_$AppDatabase, $MembroTableTable> {
  $$MembroTableTableFilterComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnFilters<String> get id => $composableBuilder(
      column: $table.id, builder: (column) => ColumnFilters(column));

  ColumnFilters<DateTime> get criadoEm => $composableBuilder(
      column: $table.criadoEm, builder: (column) => ColumnFilters(column));

  ColumnFilters<DateTime> get atualizadoEm => $composableBuilder(
      column: $table.atualizadoEm, builder: (column) => ColumnFilters(column));

  ColumnFilters<DateTime> get deletadoEm => $composableBuilder(
      column: $table.deletadoEm, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get nomeMembro => $composableBuilder(
      column: $table.nomeMembro, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get emailMembro => $composableBuilder(
      column: $table.emailMembro, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get contatoMembro => $composableBuilder(
      column: $table.contatoMembro, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get enderecoMembro => $composableBuilder(
      column: $table.enderecoMembro,
      builder: (column) => ColumnFilters(column));

  ColumnFilters<int> get statusAssociado => $composableBuilder(
      column: $table.statusAssociado,
      builder: (column) => ColumnFilters(column));

  ColumnFilters<int> get quantidadePresenca => $composableBuilder(
      column: $table.quantidadePresenca,
      builder: (column) => ColumnFilters(column));
}

class $$MembroTableTableOrderingComposer
    extends Composer<_$AppDatabase, $MembroTableTable> {
  $$MembroTableTableOrderingComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnOrderings<String> get id => $composableBuilder(
      column: $table.id, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<DateTime> get criadoEm => $composableBuilder(
      column: $table.criadoEm, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<DateTime> get atualizadoEm => $composableBuilder(
      column: $table.atualizadoEm,
      builder: (column) => ColumnOrderings(column));

  ColumnOrderings<DateTime> get deletadoEm => $composableBuilder(
      column: $table.deletadoEm, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get nomeMembro => $composableBuilder(
      column: $table.nomeMembro, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get emailMembro => $composableBuilder(
      column: $table.emailMembro, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get contatoMembro => $composableBuilder(
      column: $table.contatoMembro,
      builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get enderecoMembro => $composableBuilder(
      column: $table.enderecoMembro,
      builder: (column) => ColumnOrderings(column));

  ColumnOrderings<int> get statusAssociado => $composableBuilder(
      column: $table.statusAssociado,
      builder: (column) => ColumnOrderings(column));

  ColumnOrderings<int> get quantidadePresenca => $composableBuilder(
      column: $table.quantidadePresenca,
      builder: (column) => ColumnOrderings(column));
}

class $$MembroTableTableAnnotationComposer
    extends Composer<_$AppDatabase, $MembroTableTable> {
  $$MembroTableTableAnnotationComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  GeneratedColumn<String> get id =>
      $composableBuilder(column: $table.id, builder: (column) => column);

  GeneratedColumn<DateTime> get criadoEm =>
      $composableBuilder(column: $table.criadoEm, builder: (column) => column);

  GeneratedColumn<DateTime> get atualizadoEm => $composableBuilder(
      column: $table.atualizadoEm, builder: (column) => column);

  GeneratedColumn<DateTime> get deletadoEm => $composableBuilder(
      column: $table.deletadoEm, builder: (column) => column);

  GeneratedColumn<String> get nomeMembro => $composableBuilder(
      column: $table.nomeMembro, builder: (column) => column);

  GeneratedColumn<String> get emailMembro => $composableBuilder(
      column: $table.emailMembro, builder: (column) => column);

  GeneratedColumn<String> get contatoMembro => $composableBuilder(
      column: $table.contatoMembro, builder: (column) => column);

  GeneratedColumn<String> get enderecoMembro => $composableBuilder(
      column: $table.enderecoMembro, builder: (column) => column);

  GeneratedColumn<int> get statusAssociado => $composableBuilder(
      column: $table.statusAssociado, builder: (column) => column);

  GeneratedColumn<int> get quantidadePresenca => $composableBuilder(
      column: $table.quantidadePresenca, builder: (column) => column);
}

class $$MembroTableTableTableManager extends RootTableManager<
    _$AppDatabase,
    $MembroTableTable,
    MembroTableData,
    $$MembroTableTableFilterComposer,
    $$MembroTableTableOrderingComposer,
    $$MembroTableTableAnnotationComposer,
    $$MembroTableTableCreateCompanionBuilder,
    $$MembroTableTableUpdateCompanionBuilder,
    (
      MembroTableData,
      BaseReferences<_$AppDatabase, $MembroTableTable, MembroTableData>
    ),
    MembroTableData,
    PrefetchHooks Function()> {
  $$MembroTableTableTableManager(_$AppDatabase db, $MembroTableTable table)
      : super(TableManagerState(
          db: db,
          table: table,
          createFilteringComposer: () =>
              $$MembroTableTableFilterComposer($db: db, $table: table),
          createOrderingComposer: () =>
              $$MembroTableTableOrderingComposer($db: db, $table: table),
          createComputedFieldComposer: () =>
              $$MembroTableTableAnnotationComposer($db: db, $table: table),
          updateCompanionCallback: ({
            Value<String> id = const Value.absent(),
            Value<DateTime?> criadoEm = const Value.absent(),
            Value<DateTime?> atualizadoEm = const Value.absent(),
            Value<DateTime?> deletadoEm = const Value.absent(),
            Value<String> nomeMembro = const Value.absent(),
            Value<String?> emailMembro = const Value.absent(),
            Value<String?> contatoMembro = const Value.absent(),
            Value<String?> enderecoMembro = const Value.absent(),
            Value<int> statusAssociado = const Value.absent(),
            Value<int> quantidadePresenca = const Value.absent(),
            Value<int> rowid = const Value.absent(),
          }) =>
              MembroTableCompanion(
            id: id,
            criadoEm: criadoEm,
            atualizadoEm: atualizadoEm,
            deletadoEm: deletadoEm,
            nomeMembro: nomeMembro,
            emailMembro: emailMembro,
            contatoMembro: contatoMembro,
            enderecoMembro: enderecoMembro,
            statusAssociado: statusAssociado,
            quantidadePresenca: quantidadePresenca,
            rowid: rowid,
          ),
          createCompanionCallback: ({
            required String id,
            Value<DateTime?> criadoEm = const Value.absent(),
            Value<DateTime?> atualizadoEm = const Value.absent(),
            Value<DateTime?> deletadoEm = const Value.absent(),
            required String nomeMembro,
            Value<String?> emailMembro = const Value.absent(),
            Value<String?> contatoMembro = const Value.absent(),
            Value<String?> enderecoMembro = const Value.absent(),
            required int statusAssociado,
            Value<int> quantidadePresenca = const Value.absent(),
            Value<int> rowid = const Value.absent(),
          }) =>
              MembroTableCompanion.insert(
            id: id,
            criadoEm: criadoEm,
            atualizadoEm: atualizadoEm,
            deletadoEm: deletadoEm,
            nomeMembro: nomeMembro,
            emailMembro: emailMembro,
            contatoMembro: contatoMembro,
            enderecoMembro: enderecoMembro,
            statusAssociado: statusAssociado,
            quantidadePresenca: quantidadePresenca,
            rowid: rowid,
          ),
          withReferenceMapper: (p0) => p0
              .map((e) => (e.readTable(table), BaseReferences(db, table, e)))
              .toList(),
          prefetchHooksCallback: null,
        ));
}

typedef $$MembroTableTableProcessedTableManager = ProcessedTableManager<
    _$AppDatabase,
    $MembroTableTable,
    MembroTableData,
    $$MembroTableTableFilterComposer,
    $$MembroTableTableOrderingComposer,
    $$MembroTableTableAnnotationComposer,
    $$MembroTableTableCreateCompanionBuilder,
    $$MembroTableTableUpdateCompanionBuilder,
    (
      MembroTableData,
      BaseReferences<_$AppDatabase, $MembroTableTable, MembroTableData>
    ),
    MembroTableData,
    PrefetchHooks Function()>;

class $AppDatabaseManager {
  final _$AppDatabase _db;
  $AppDatabaseManager(this._db);
  $$MembroTableTableTableManager get membroTable =>
      $$MembroTableTableTableManager(_db, _db.membroTable);
}
