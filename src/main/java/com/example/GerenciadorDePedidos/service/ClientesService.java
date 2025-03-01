package com.example.GerenciadorDePedidos.service;

import com.example.GerenciadorDePedidos.model.Clientes;
import com.example.GerenciadorDePedidos.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {
    @Autowired
    private ClientesRepository clientesRepository;

    @Transactional
    public Clientes save(Clientes cliente) {
        return clientesRepository.save(cliente);
    }

    public List<Clientes> listClientes() {
        return clientesRepository.findAll();
    }

    public Optional<Clientes> findCliente(Long idCliente) {
        return clientesRepository.findById(idCliente);
    }
}
