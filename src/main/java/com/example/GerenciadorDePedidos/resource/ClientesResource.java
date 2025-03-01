package com.example.GerenciadorDePedidos.resource;

import com.example.GerenciadorDePedidos.model.Clientes;
import com.example.GerenciadorDePedidos.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClientesResource {
    @Autowired
    private ClientesService clientesService;

    @PostMapping
    public Clientes save(@RequestBody Clientes cliente) {
        return clientesService.save(cliente);
    }
}
