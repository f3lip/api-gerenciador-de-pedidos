package com.example.GerenciadorDePedidos.resource;

import com.example.GerenciadorDePedidos.model.Pedidos;
import com.example.GerenciadorDePedidos.model.Produtos;
import com.example.GerenciadorDePedidos.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidosResource {
    @Autowired
    private PedidosService pedidosService;

    @PostMapping
    public Pedidos save(@RequestBody Pedidos pedido) {
        return pedidosService.save(pedido);
    }

    @GetMapping(value = "listPedidos")
    public List<Pedidos> listPedidos() {
        return pedidosService.listPedidos();
    }
}
