package com.example.GerenciadorDePedidos.model;

import jakarta.persistence.*;

@Entity
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PEDIDOS")
    @SequenceGenerator(name = "SEQ_PEDIDOS", sequenceName = "SEQ_PEDIDOS", allocationSize = 1)
    private Long id;

    @Column(name = "NRO_PEDIDO")
    private Long nroPedido;

    @ManyToOne
    @JoinColumn(name = "I_CLIENTES")
    private Clientes cliente;

    @Column(name = "SITUACAO")
    private String situacao;

    @Column(name = "FL_EXCLUIDO")
    private Boolean excluido;

    public Long getId() {
        return id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public String getSituacao() {
        return situacao;
    }

    public Boolean getExcluido() {
        return excluido;
    }

    public Pedidos() {}

    public Pedidos(Builder builder) {
        this.nroPedido = builder.nroPedido;
        this.cliente = builder.cliente;
        this.situacao = builder.situacao;
        this.excluido = builder.excluido;
    }

    public static class Builder {
        private Long nroPedido;
        private Clientes cliente;
        private String situacao;
        private Boolean excluido;

        public Builder nroPedido(Long nroPedido) {
            this.nroPedido = nroPedido;
            return this;
        }

        public Builder cliente(Clientes cliente) {
            this.cliente = cliente;
            return this;
        }

        public Builder situacao(String situacao) {
            this.situacao = situacao;
            return this;
        }

        public Builder excluido(Boolean excluido) {
            this.excluido = excluido;
            return this;
        }

        public Pedidos build() { return new Pedidos(this); }
    }
}
