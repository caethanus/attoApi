-- Flyway Migration
-- Version: 1
-- Timestamp: 20260511_2147
-- Description: create_membro_table
-- Created at: 2026-05-11T21:47:55.425945800

-- Write your SQL below
CREATE TABLE IF NOT EXISTS membros (
                                       id               UUID        NOT NULL,
                                       membros_id       UUID        NOT NULL UNIQUE,
                                       criado_em        TIMESTAMP   NOT NULL,
                                       atualizado_em    TIMESTAMP,
                                       deletado_em      TIMESTAMP,
                                       nome_membro      VARCHAR     NOT NULL,
                                       email_membro     VARCHAR,
                                       contato_membro   VARCHAR,
                                       endereco_membro  VARCHAR,
                                       status_associado INTEGER     NOT NULL,

                                       CONSTRAINT pk_membros PRIMARY KEY (id),
                                       CONSTRAINT uk_membros_membros_id UNIQUE (membros_id)
    );

