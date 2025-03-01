package com.example.GerenciadorDePedidos.repository;

import com.example.GerenciadorDePedidos.model.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
    List<Pedidos> findPedidosBySituacao(String situacao);
}
