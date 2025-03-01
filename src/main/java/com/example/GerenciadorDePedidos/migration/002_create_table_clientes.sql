--liquibase formatted sql
--changeset bruno.lima:1
CREATE TABLE CLIENTES (
    ID              BIGINT PRIMARY KEY,
    NOME            VARCHAR(255) NOT NULL,
    FL_EXCLUIDO     BOOLEAN DEFAULT FALSE
);
--rollback not required

--changeset bruno.lima:2
CREATE SEQUENCE SEQ_CLIENTES START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
--rollback not required