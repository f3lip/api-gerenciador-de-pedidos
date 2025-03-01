package com.example.GerenciadorDePedidos.resource;

import com.example.GerenciadorDePedidos.model.Pedidos;
import com.example.GerenciadorDePedidos.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidosResource {
    @Autowired
    private PedidosService pedidosService;

    @PostMapping
    public Pedidos save(@RequestBody Pedidos pedido) {
        return pedidosService.save(pedido);
    }
}
