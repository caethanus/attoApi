-- Flyway Migration
-- Version: 7
-- Timestamp: 20260506
-- Description: add_auth_tables

-- Renomear coluna senha para senha_hash
ALTER TABLE usuarios RENAME COLUMN senha TO senha_hash;

-- Adicionar campo ativo
ALTER TABLE usuarios ADD COLUMN ativo BOOLEAN NOT NULL DEFAULT true;

-- Criar tabela de refresh tokens
CREATE TABLE refresh_tokens
(
    id              UUID PRIMARY KEY,
    criado_em       TIMESTAMP NOT NULL,
    atualizado_em   TIMESTAMP,
    deletado_em     TIMESTAMP,
    sincronizado_em TIMESTAMP,
    usuario_id      UUID      NOT NULL,
    token           TEXT      NOT NULL UNIQUE,
    expira_em       TIMESTAMP NOT NULL,
    revogado        BOOLEAN   NOT NULL DEFAULT false,
    CONSTRAINT fk_refresh_token_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);

-- Índices para performance
CREATE INDEX idx_refresh_tokens_token ON refresh_tokens (token);
CREATE INDEX idx_refresh_tokens_usuario_id ON refresh_tokens (usuario_id);
