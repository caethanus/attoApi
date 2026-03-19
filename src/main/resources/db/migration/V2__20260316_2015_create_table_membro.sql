-- Flyway Migration
-- Version: 2
-- Timestamp: 20260316_2015
-- Description: create_table_membro
-- Created at: 2026-03-16T20:15:09.247355700

CREATE TABLE membros
(
    id               UUID PRIMARY KEY,
    criado_em        TIMESTAMP NOT NULL,
    atualizado_em    TIMESTAMP,
    deletado_em      TIMESTAMP,
    sincronizado_em  TIMESTAMP,
    nome_membro      TEXT      NOT NULL,
    email_membro     TEXT,
    contato_membro   TEXT,
    endereco_membro  TEXT,
    status_associado TEXT NOT NULL,
    usuario_id       UUID      NOT NULL UNIQUE,
    CONSTRAINT membros_usuarios FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);

