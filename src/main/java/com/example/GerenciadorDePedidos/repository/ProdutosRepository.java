package com.example.GerenciadorDePedidos.repository;

import com.example.GerenciadorDePedidos.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> { }
