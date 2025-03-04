--liquibase formatted sql
--changeset bruno.lima:1
CREATE TABLE PEDIDOS (
    ID              BIGINT PRIMARY KEY,
    NRO_PEDIDO      BIGINT NOT NULL,
    I_CLIENTES      BIGINT,
    SITUACAO        VARCHAR(25),
    FL_EXCLUIDO     BOOLEAN DEFAULT FALSE,
    CONSTRAINT FK_PEDIDOS_CLIENTES FOREIGN KEY (I_CLIENTES) REFERENCES CLIENTES(id)
);
--rollback not required

--changeset bruno.lima:2
CREATE SEQUENCE SEQ_PEDIDOS START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
--rollback not required

--changeset bruno.lima:3
CREATE SEQUENCE SEQ_NRO_PEDIDO START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
--rollback not required