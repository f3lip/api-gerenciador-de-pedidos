--liquibase formatted sql
--changeset bruno.lima:1
CREATE TABLE PRODUTOS (
    ID              BIGINT PRIMARY KEY,
    NOME            VARCHAR(255) NOT NULL,
    PRECO           NUMERIC(10,2) NOT NULL,
    FL_EXCLUIDO     BOOLEAN DEFAULT FALSE
);
--rollback not required

--changeset bruno.lima:2
CREATE SEQUENCE SEQ_PRODUTOS START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
--rollback not required