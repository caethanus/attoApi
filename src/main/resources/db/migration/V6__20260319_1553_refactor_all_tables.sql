-- Flyway Migration
-- Version: 6
-- Timestamp: 20260319_1553
-- Description: refactor_all_tables
-- Created at: 2026-03-19T15:53:21.329662600

DROP TABLE IF EXISTS participacoes_gestao CASCADE;
DROP TABLE IF EXISTS gestoes CASCADE;
DROP TABLE IF EXISTS membros CASCADE;
DROP TABLE IF EXISTS cargos CASCADE;
DROP TABLE IF EXISTS diretorias CASCADE;
DROP TABLE IF EXISTS eventos CASCADE;
DROP TABLE IF EXISTS caixas CASCADE;
DROP TABLE IF EXISTS usuarios CASCADE;
DROP TABLE IF EXISTS listas_presenca CASCADE;
DROP TABLE IF EXISTS transacoes CASCADE;

CREATE TABLE usuarios
(
    id              UUID PRIMARY KEY,
    criado_em       TIMESTAMP NOT NULL,
    atualizado_em   TIMESTAMP,
    deletado_em     TIMESTAMP,
    sincronizado_em TIMESTAMP,
    login           TEXT      NOT NULL,
    senha           TEXT      NOT NULL,
    tipo_usuario    TEXT      NOT NULL
);

CREATE TABLE membros
(
    id               UUID PRIMARY KEY,
    criado_em        TIMESTAMP   NOT NULL,
    atualizado_em    TIMESTAMP,
    deletado_em      TIMESTAMP,
    sincronizado_em  TIMESTAMP,
    nome_membro      TEXT        NOT NULL,
    email_membro     TEXT,
    contato_membro   TEXT,
    endereco_membro  TEXT,
    status_associado TEXT        NOT NULL,

    usuario_id       UUID UNIQUE NOT NULL,

    CONSTRAINT fk_membro_usuario
        FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);

CREATE TABLE cargos
(
    id              UUID PRIMARY KEY,
    criado_em       TIMESTAMP NOT NULL,
    atualizado_em   TIMESTAMP,
    deletado_em     TIMESTAMP,
    sincronizado_em TIMESTAMP,
    titulo_cargo    TEXT      NOT NULL,
    descricao_cargo TEXT
);

CREATE TABLE participacoes_gestao
(
    id              UUID PRIMARY KEY,
    criado_em       TIMESTAMP   NOT NULL,
    atualizado_em   TIMESTAMP,
    deletado_em     TIMESTAMP,
    sincronizado_em TIMESTAMP,
    data_entrada    TIMESTAMP   NOT NULL,
    data_saida      TIMESTAMP,

    cargo_id        UUID UNIQUE NOT NULL,

    membro_id       UUID UNIQUE NOT NULL,

    CONSTRAINT fk_participacoes_gestao_cargo
        FOREIGN KEY (cargo_id) REFERENCES cargos (id),
    CONSTRAINT fk_participacoes_gestao_membro
        FOREIGN KEY (membro_id) REFERENCES membros (id)
);

CREATE TABLE diretorias
(
    id                    UUID PRIMARY KEY,
    criado_em             TIMESTAMP NOT NULL,
    atualizado_em         TIMESTAMP,
    deletado_em           TIMESTAMP,
    sincronizado_em       TIMESTAMP,
    nome_diretoria        TEXT      NOT NULL,
    informacoes_diretoria TEXT      NOT NULL,
    email_diretoria       TEXT,
    contato_diretoria     TEXT
);

CREATE TABLE gestoes
(
    id                 UUID PRIMARY KEY,
    criado_em          TIMESTAMP   NOT NULL,
    atualizado_em      TIMESTAMP,
    deletado_em        TIMESTAMP,
    sincronizado_em    TIMESTAMP,
    data_inicio_gestao TIMESTAMP   NOT NULL,
    data_final_gestao  TIMESTAMP,

    diretoria_id       UUID UNIQUE NOT NULL,

    CONSTRAINT fk_gestao_diretoria
        FOREIGN KEY (diretoria_id) REFERENCES diretorias (id)
);

CREATE TABLE listas_presenca
(
    id                  UUID PRIMARY KEY,
    criado_em           TIMESTAMP NOT NULL,
    atualizado_em       TIMESTAMP,
    deletado_em         TIMESTAMP,
    sincronizado_em     TIMESTAMP,
    data_lista_presenca TIMESTAMP NOT NULL
);

CREATE TABLE registros_presenca
(
    id                UUID PRIMARY KEY,
    criado_em         TIMESTAMP   NOT NULL,
    atualizado_em     TIMESTAMP,
    deletado_em       TIMESTAMP,
    sincronizado_em   TIMESTAMP,
    presente          BOOLEAN     NOT NULL,

    membro_id         UUID UNIQUE NOT NULL,

    lista_presenca_id UUID        NOT NULL,

    CONSTRAINT fk_registros_presenca_membro
        FOREIGN KEY (membro_id) REFERENCES membros (id),

    CONSTRAINT fk_registros_presenca_lista_presenca
        FOREIGN KEY (lista_presenca_id) REFERENCES listas_presenca (id)
);


CREATE TABLE caixas
(
    id              UUID PRIMARY KEY,
    criado_em       TIMESTAMP        NOT NULL,
    atualizado_em   TIMESTAMP,
    deletado_em     TIMESTAMP,
    sincronizado_em TIMESTAMP,
    saldo_total     DOUBLE PRECISION NOT NULL
);

CREATE TABLE transacoes
(
    id                  UUID PRIMARY KEY,
    criado_em           TIMESTAMP        NOT NULL,
    atualizado_em       TIMESTAMP,
    deletado_em         TIMESTAMP,
    sincronizado_em     TIMESTAMP,
    titulo_transacao    TEXT             NOT NULL,
    descricao_transacao TEXT             NOT NULL,
    valor_transacao     DOUBLE PRECISION NOT NULL,
    tipo_transacao      TEXT             NOT NULL,
    documento_vinculado TEXT,

    caixa_id            UUID             NOT NULL,

    CONSTRAINT fk_transacoes_caixa
        FOREIGN KEY (caixa_id) REFERENCES caixas (id)
);

CREATE TABLE eventos
(
    id                           UUID PRIMARY KEY,
    criado_em                    TIMESTAMP NOT NULL,
    atualizado_em                TIMESTAMP,
    deletado_em                  TIMESTAMP,
    sincronizado_em              TIMESTAMP,
    titulo_evento                TEXT      NOT NULL,
    descricao_evento             TEXT      NOT NULL,
    data_hora_realizacao_evento  TIMESTAMP NOT NULL,
    data_hora_finalizacao_evento TIMESTAMP,
    local_evento                 TEXT      NOT NULL,
    quantidade_participantes     INTEGER   NOT NULL,
    status_evento                TEXT      NOT NULL,

    caixa_id                     UUID UNIQUE,

    lista_presenca_id            UUID UNIQUE,

    CONSTRAINT fk_evento_caixa
        FOREIGN KEY (caixa_id)
            REFERENCES caixas (id),

    CONSTRAINT fk_evento_lista
        FOREIGN KEY (lista_presenca_id)
            REFERENCES listas_presenca (id)
);




