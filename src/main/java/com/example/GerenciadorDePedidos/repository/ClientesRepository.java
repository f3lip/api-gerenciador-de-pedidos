package com.example.GerenciadorDePedidos.repository;

import com.example.GerenciadorDePedidos.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long> { }
