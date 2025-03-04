package com.example.GerenciadorDePedidos.resource;

import com.example.GerenciadorDePedidos.model.Clientes;
import com.example.GerenciadorDePedidos.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes/")
public class ClientesResource {
    @Autowired
    private ClientesService clientesService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Clientes save(@RequestBody Clientes cliente) {
        return clientesService.save(cliente);
    }

    @GetMapping(value = "listClientes")
    public List<Clientes> listClientes() {
        return clientesService.listClientes();
    }

    @PutMapping(value = "excluirCliente")
    public ResponseEntity excluirCliente(@RequestParam Long clienteId) {
        clientesService.excluirCliente(clienteId);
        return ResponseEntity.ok(clienteId);
    }
}
