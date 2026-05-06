-- Flyway Migration
-- Version: 7
-- Timestamp: 20250506_0030
-- Description: add_auth_tables
-- Created at: 2026-05-06T00:30:00

-- Create refresh_tokens table
CREATE TABLE refresh_tokens
(
    refresh_token           TEXT      NOT NULL UNIQUE,
    data_hora_expiracao  TIMESTAMP NOT NULL,
    data_hora_revogacao  TIMESTAMP NOT NULL,
    usuario_id      UUID      NOT NULL,

    CONSTRAINT fk_refresh_token_usuario
        FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);

