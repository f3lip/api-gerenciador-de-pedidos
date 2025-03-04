package com.example.GerenciadorDePedidos.model;

import jakarta.persistence.*;

@Entity
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENTES")
    @SequenceGenerator(name = "SEQ_CLIENTES", sequenceName = "SEQ_CLIENTES", allocationSize = 1)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "FL_EXCLUIDO")
    private Boolean excluido = Boolean.FALSE;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Boolean getExcluido() {
        return excluido;
    }

    public Clientes() {}

    public Clientes(Builder builder) {
        this.id = builder.id;
        this.nome = builder.nome;
        this.excluido = builder.excluido;
    }
    public static class Builder {
        private Long id;
        private String nome;
        private Boolean excluido;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder excluido(Boolean excluido) {
            this.excluido = excluido;
            return this;
        }

        public Clientes build() { return new Clientes(this); }
    }
}
