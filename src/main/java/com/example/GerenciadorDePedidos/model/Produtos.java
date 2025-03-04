package com.example.GerenciadorDePedidos.model;

import jakarta.persistence.*;

@Entity
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUTOS")
    @SequenceGenerator(name = "SEQ_PRODUTOS", sequenceName = "SEQ_PRODUTOS", allocationSize = 1)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "PRECO")
    private Double preco;

    @Column(name = "FL_EXCLUIDO")
    private Boolean excluido = Boolean.FALSE;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Boolean getExcluido() {
        return excluido;
    }

    public Produtos() {}

    public Produtos(Builder builder) {
        this.id = builder.id;
        this.nome = builder.nome;
        this.preco = builder.preco;
        this.excluido = builder.excluido;
    }
    public static class Builder {
        private Long id;
        private String nome;
        private Double preco;
        private Boolean excluido;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder preco(Double preco) {
            this.preco = preco;
            return this;
        }

        public Builder excluido(Boolean excluido) {
            this.excluido = excluido;
            return this;
        }

        public Produtos build() { return new Produtos(this); }
    }
}
