-- Flyway Migration
-- Version: 1
-- Timestamp: 20260312_2105
-- Description: create_test_usuario
-- Created at: 2026-03-12T21:05:39.178148400

CREATE TABLE usuarios
(
    id              UUID PRIMARY KEY,
    criado_em       TIMESTAMP NOT NULL,
    atualizado_em   TIMESTAMP,
    deletado_em     TIMESTAMP,
    sincronizado_em TIMESTAMP,
    login           TEXT NOT NULL,
    senha           TEXT NOT NULL,
    tipo_usuario    TEXT NOT NULL
);
