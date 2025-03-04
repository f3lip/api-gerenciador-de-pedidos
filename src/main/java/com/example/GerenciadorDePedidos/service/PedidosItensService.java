package com.example.GerenciadorDePedidos.service;

import com.example.GerenciadorDePedidos.model.PedidosItens;
import com.example.GerenciadorDePedidos.repository.PedidosItensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidosItensService {
    @Autowired
    private PedidosItensRepository pedidosItensRepository;

    @Transactional
    public PedidosItens save(PedidosItens pedidoItem) {
        return pedidosItensRepository.save(pedidoItem);
    }

    @Transactional
    public void save(List<PedidosItens> pedidosItensList) {
        pedidosItensRepository.saveAll(pedidosItensList);
    }

    public List<PedidosItens> listPedidosItensByPedido(Long pedidoId) {
        return pedidosItensRepository.findPedidosItensByPedidoId(pedidoId);
    }
}
