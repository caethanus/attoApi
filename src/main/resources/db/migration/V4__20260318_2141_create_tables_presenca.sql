-- Flyway Migration
-- Version: 4
-- Timestamp: 20260318_2141
-- Description: create_tables_presenca
-- Created at: 2026-03-18T21:41:22.168682400

CREATE TABLE listas_presenca
(
    id                    UUID PRIMARY KEY,
    criado_em             TIMESTAMP NOT NULL,
    atualizado_em         TIMESTAMP,
    deletado_em           TIMESTAMP,
    sincronizado_em       TIMESTAMP,
    data_lista_presenca   TIMESTAMP NOT NULL
);

CREATE TABLE registros_presencas
(
    id                  UUID PRIMARY KEY,
    criado_em           TIMESTAMP NOT NULL,
    atualizado_em       TIMESTAMP,
    deletado_em         TIMESTAMP,
    sincronizado_em     TIMESTAMP,

    membro_id           UUID NOT NULL,
    lista_presenca_id   UUID NOT NULL,
    presente            BOOLEAN NOT NULL,

    CONSTRAINT fk_registro_membro
        FOREIGN KEY (membro_id) REFERENCES membros (id),

    CONSTRAINT fk_registro_lista
        FOREIGN KEY (lista_presenca_id) REFERENCES listas_presenca (id)
);
