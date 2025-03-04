package com.example.GerenciadorDePedidos.dto;

public class ResumoVendasDTO {
    private Long totalPedidos;
    private Double valorTotalFaturado;
    private Long totalProdutosVendidos;

    public Long getTotalPedidos() {
        return totalPedidos;
    }

    public void setTotalPedidos(Long totalPedidos) {
        this.totalPedidos = totalPedidos;
    }

    public Double getValorTotalFaturado() {
        return valorTotalFaturado;
    }

    public void setValorTotalFaturado(Double valorTotalFaturado) {
        this.valorTotalFaturado = valorTotalFaturado;
    }

    public Long getTotalProdutosVendidos() {
        return totalProdutosVendidos;
    }

    public void setTotalProdutosVendidos(Long totalProdutosVendidos) {
        this.totalProdutosVendidos = totalProdutosVendidos;
    }
}
