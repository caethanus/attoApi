-- Flyway Migration
-- Version: 7
-- Timestamp: 20260506
-- Description: add_auth_tables

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

INSERT INTO usuarios (id, criado_em, atualizado_em, deletado_em, sincronizado_em, login, senha, tipo_usuario)
VALUES ('00000000-0000-0000-0000-000000000001', CURRENT_TIMESTAMP, NULL, NULL, NULL, 'admin',
        '$2a$10$yUkLEVgaZs2qYNLVe6ydBe4WAgwxW4/Ii2ND/zSQY2PZ4QvHgvwdC', 'ADMIN');

-- Índices para performance
CREATE INDEX idx_refresh_tokens_token ON refresh_tokens (token);
CREATE INDEX idx_refresh_tokens_usuario_id ON refresh_tokens (usuario_id);
