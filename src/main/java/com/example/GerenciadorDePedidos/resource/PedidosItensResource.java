package com.example.GerenciadorDePedidos.resource;

import com.example.GerenciadorDePedidos.model.PedidosItens;
import com.example.GerenciadorDePedidos.service.PedidosItensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidosItens/")
public class PedidosItensResource {
    @Autowired
    private PedidosItensService pedidosItensService;

    @PostMapping
    public PedidosItens save(@RequestBody PedidosItens pedidoItem) {
        return pedidosItensService.save(pedidoItem);
    }

    @GetMapping("listPedidosItens")
    public List<PedidosItens> listPedidos(@RequestParam Long pedidoId) {
        return pedidosItensService.listPedidosItensByPedido(pedidoId);
    }
}
