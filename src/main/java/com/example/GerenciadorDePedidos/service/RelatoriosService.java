package com.example.GerenciadorDePedidos.service;

import com.example.GerenciadorDePedidos.dto.ResumoVendasDTO;
import com.example.GerenciadorDePedidos.model.Pedidos;
import com.example.GerenciadorDePedidos.repository.PedidosRepository;
import com.example.GerenciadorDePedidos.repository.RelatoriosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatoriosService {
    @Autowired
    private RelatoriosRepository relatoriosRepository;

    @Autowired
    private PedidosRepository pedidosRepository;

    public ResumoVendasDTO relatorioResumoVendas() {
        return relatoriosRepository.relatorioResumoVendas();
    }

    public List<Pedidos> relatorioPedidosPendentes() {
        return pedidosRepository.findPedidosBySituacao(Pedidos.SITUACAO_EM_ANDAMENTO);
    }
}
