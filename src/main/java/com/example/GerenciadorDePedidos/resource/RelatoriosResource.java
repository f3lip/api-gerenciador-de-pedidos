package com.example.GerenciadorDePedidos.resource;

import com.example.GerenciadorDePedidos.model.Pedidos;
import com.example.GerenciadorDePedidos.model.Produtos;
import com.example.GerenciadorDePedidos.dto.ResumoVendasDTO;
import com.example.GerenciadorDePedidos.service.RelatoriosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorios/")
public class RelatoriosResource {
    @Autowired
    private RelatoriosService relatoriosService;

    @GetMapping(value = "resumoVendas")
    public ResumoVendasDTO resumoVendas() {
        return relatoriosService.relatorioResumoVendas();
    }

    @GetMapping(value = "pedidosPendentes")
    public List<Pedidos> pedidosPendentes() {
        return relatoriosService.relatorioPedidosPendentes();
    }
}
