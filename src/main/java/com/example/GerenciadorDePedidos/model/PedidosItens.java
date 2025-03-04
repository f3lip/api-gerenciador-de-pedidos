package com.example.GerenciadorDePedidos.model;

import jakarta.persistence.*;

@Entity
public class PedidosItens {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PEDIDOS_ITENS")
    @SequenceGenerator(name = "SEQ_PEDIDOS_ITENS", sequenceName = "SEQ_PEDIDOS_ITENS", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "I_PRODUTOS")
    private Produtos produto;

    @ManyToOne
    @JoinColumn(name = "I_PEDIDOS")

    private Pedidos pedido;

    @Column(name = "QUANTIDADE")
    private Integer quantidade;

    @Column(name = "FL_EXCLUIDO")
    private Boolean excluido = Boolean.FALSE;

    public Long getId() {
        return id;
    }

    public Produtos getProduto() {
        return produto;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Boolean getExcluido() {
        return excluido;
    }

    public PedidosItens() {}

    public PedidosItens(Builder builder) {
        this.id = builder.id;
        this.produto = builder.produto;
        this.pedido = builder.pedido;
        this.quantidade = builder.quantidade;
        this.excluido = builder.excluido;
    }

    public static class Builder {
        private Long id;
        private Produtos produto;
        private Pedidos pedido;
        private Integer quantidade;
        private Boolean excluido;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder produto(Produtos produto) {
            this.produto = produto;
            return this;
        }

        public Builder pedido(Pedidos pedido) {
            this.pedido = pedido;
            return this;
        }

        public Builder quantidade(Integer quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public Builder excluido(Boolean excluido) {
            this.excluido = excluido;
            return this;
        }

        public PedidosItens build() { return new PedidosItens(this); }
    }
}
