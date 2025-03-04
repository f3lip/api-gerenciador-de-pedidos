package com.example.GerenciadorDePedidos.service;

import com.example.GerenciadorDePedidos.model.Pedidos;
import com.example.GerenciadorDePedidos.model.PedidosItens;
import com.example.GerenciadorDePedidos.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidosService {
    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private PedidosItensService pedidosItensService;

    @Transactional
    public Pedidos save(Pedidos pedido) {
        List<PedidosItens> pedidosItensList = pedido.getPedidosItens();
        pedido = pedidosRepository.save(new Pedidos.Builder()
                .id(pedido.getId())
                .nroPedido(pedido.getId() == null ? pedidosRepository.getNextNroPedido() : pedido.getNroPedido())
                .cliente(pedido.getCliente())
                .situacao(Pedidos.SITUACAO_EM_ANDAMENTO)
                .build());
        List<PedidosItens> pedidosItensSalvarList = new ArrayList<>();
        for(PedidosItens pedidoItem : pedidosItensList) {
            pedidosItensSalvarList.add(new PedidosItens.Builder()
                    .id(pedidoItem.getId())
                    .pedido(pedido)
                    .produto(pedidoItem.getProduto())
                    .quantidade(pedidoItem.getQuantidade())
                    .excluido(pedidoItem.getExcluido())
                    .build());
        }
        pedidosItensService.save(pedidosItensSalvarList);
        return pedido;
    }

    @Transactional
    public void finalizarPedido(Long pedidoId) {
        pedidosRepository.atualizarSituacaoPedido(pedidoId, Pedidos.SITUACAO_FINALIZADO);
    }

    @Transactional
    public void cancelarPedido(Long pedidoId) {
        pedidosRepository.atualizarSituacaoPedido(pedidoId, Pedidos.SITUACAO_CANCELADO);
    }

    @Transactional
    public void excluirPedido(Long pedidoId) {
        pedidosRepository.excluirPedido(pedidoId);
    }
    public List<Pedidos> listPedidos() {
        return pedidosRepository.findAll();
    }

    public List<Pedidos> listPedidosBySituacao(String situacao) {
        return pedidosRepository.findPedidosBySituacao(situacao);
    }
}
