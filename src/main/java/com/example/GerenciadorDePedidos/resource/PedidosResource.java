package com.example.GerenciadorDePedidos.resource;

import com.example.GerenciadorDePedidos.model.Pedidos;
import com.example.GerenciadorDePedidos.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos/")
public class PedidosResource {
    @Autowired
    private PedidosService pedidosService;

    @PostMapping
    public Pedidos save(@RequestBody Pedidos pedido) {
        return pedidosService.save(pedido);
    }

    @PutMapping(value = "finalizarPedido")
    public ResponseEntity finalizarPedido(@RequestParam Long pedidoId) {
        pedidosService.finalizarPedido(pedidoId);
        return ResponseEntity.ok(pedidoId);
    }

    @PutMapping(value = "cancelarPedido")
    public ResponseEntity cancelarPedido(@RequestParam Long pedidoId) {
        pedidosService.cancelarPedido(pedidoId);
        return ResponseEntity.ok(pedidoId);

    }

    @PutMapping(value = "excluirPedido")
    public ResponseEntity excluirPedido(@RequestParam Long pedidoId) {
        pedidosService.excluirPedido(pedidoId);
        return ResponseEntity.ok(pedidoId);
    }

    @GetMapping(value = "listPedidos")
    public List<Pedidos> listPedidos() {
        return pedidosService.listPedidos();
    }
}
