package com.example.GerenciadorDePedidos.repository;

import com.example.GerenciadorDePedidos.model.PedidosItens;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidosItensRepository extends JpaRepository<PedidosItens, Long> {

    List<PedidosItens> findPedidosItensByPedidoId(Long pedidoId);
}
