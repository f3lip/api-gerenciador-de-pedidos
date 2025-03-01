package com.example.GerenciadorDePedidos.service;

import com.example.GerenciadorDePedidos.model.Pedidos;
import com.example.GerenciadorDePedidos.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidosService {
    @Autowired
    private PedidosRepository pedidosRepository;

    @Transactional
    public Pedidos save(Pedidos pedido) {
        return pedidosRepository.save(pedido);
    }

    public List<Pedidos> listPedidosBySituacao(String situacao) {
        return pedidosRepository.findPedidosBySituacao(situacao);
    }
}
