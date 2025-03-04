package com.example.GerenciadorDePedidos.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pedidos {
    public final static String SITUACAO_FINALIZADO = "Finalizado";
    public final static String SITUACAO_EM_ANDAMENTO = "Em andamento";
    public final static String SITUACAO_CANCELADO = "Cancelado";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PEDIDOS")
    @SequenceGenerator(name = "SEQ_PEDIDOS", sequenceName = "SEQ_PEDIDOS", allocationSize = 1)
    private Long id;

    @SequenceGenerator(name = "SEQ_NRO_PEDIDO", sequenceName = "SEQ_NRO_PEDIDO", allocationSize = 1)
    @Column(name = "NRO_PEDIDO")
    private Long nroPedido;

    @ManyToOne
    @JoinColumn(name = "I_CLIENTES")
    private Clientes cliente;

    @Column(name = "SITUACAO")
    private String situacao;

    @Column(name = "FL_EXCLUIDO")
    private Boolean excluido = Boolean.FALSE;

    @Transient
    private List<PedidosItens> pedidosItens;

    public Long getId() {
        return id;
    }

    public Long getNroPedido() {
        return nroPedido;
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

    public List<PedidosItens> getPedidosItens() {
        return pedidosItens;
    }

    public Pedidos() {}

    public Pedidos(Builder builder) {
        this.id = builder.id;
        this.nroPedido = builder.nroPedido;
        this.cliente = builder.cliente;
        this.situacao = builder.situacao;
        this.excluido = builder.excluido;
    }

    public static class Builder {
        private Long id;
        private Long nroPedido;
        private Clientes cliente;
        private String situacao;
        private Boolean excluido;
        private List<PedidosItens> pedidosItens;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

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

        public Builder pedidosItens(List<PedidosItens> pedidosItens) {
            this.pedidosItens = pedidosItens;
            return this;
        }

        public Pedidos build() { return new Pedidos(this); }
    }
}
