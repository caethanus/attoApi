-- Flyway Migration
-- Version: 5
-- Timestamp: 20260319_0030
-- Description: create_last_tables
-- Created at: 2026-03-19T00:30:37.457194800

-- Tabela de Recados
CREATE TABLE recados
(
    id                     UUID PRIMARY KEY,
    criado_em              TIMESTAMP NOT NULL,
    atualizado_em          TIMESTAMP,
    deletado_em            TIMESTAMP,
    sincronizado_em        TIMESTAMP,
    titulo_string          TEXT      NOT NULL,
    descricao_recado       TEXT      NOT NULL,
    recado_autor_recado_id UUID      NOT NULL,
    recado_urgente         BOOLEAN   NOT NULL,

    FOREIGN KEY (recado_autor_recado_id) REFERENCES membros (id)
);

-- Tabela de Caixas
CREATE TABLE caixas
(
    id              UUID PRIMARY KEY,
    criado_em       TIMESTAMP        NOT NULL,
    atualizado_em   TIMESTAMP,
    deletado_em     TIMESTAMP,
    sincronizado_em TIMESTAMP,
    saldo_total     DOUBLE PRECISION NOT NULL,

    CHECK (saldo_total >= 0)
);

-- Tabela de Eventos
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
    data_hora_finalizacao_evento TIMESTAMP NOT NULL,
    local_evento                 TEXT      NOT NULL,
    quantidade_participantes     INTEGER,
    status_evento                TEXT      NOT NULL,

    CHECK (data_hora_finalizacao_evento > data_hora_realizacao_evento)
);

-- Tabela de Transações
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
    caixa_transacoes_id UUID             NOT NULL,

    FOREIGN KEY (caixa_transacoes_id) REFERENCES caixas (id)
);