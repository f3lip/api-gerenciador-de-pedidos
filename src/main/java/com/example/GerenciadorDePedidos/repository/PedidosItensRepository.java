package com.example.GerenciadorDePedidos.repository;

import com.example.GerenciadorDePedidos.model.PedidosItens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface PedidosItensRepository extends JpaRepository<PedidosItens, Long> {

    @Query(value = "SELECT * FROM PEDIDOS_ITENS WHERE I_PEDIDOS = :pedidoId AND (FL_EXCLUIDO IS NULL OR NOT FL_EXCLUIDO)", nativeQuery = true)
    List<PedidosItens> findPedidosItensByPedidoId(@Param(value = "pedidoId") Long pedidoId);
}
