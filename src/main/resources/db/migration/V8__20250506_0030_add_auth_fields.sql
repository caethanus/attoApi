-- Adicionar campo ativo
ALTER TABLE usuarios 
ADD COLUMN ativo BOOLEAN NOT NULL DEFAULT true;
