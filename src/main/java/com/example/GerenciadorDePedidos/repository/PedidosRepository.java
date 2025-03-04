package com.example.GerenciadorDePedidos.repository;

import com.example.GerenciadorDePedidos.model.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
    List<Pedidos> findPedidosBySituacao(String situacao);

    @Query(value = "SELECT * FROM PEDIDOS WHERE FL_EXCLUIDO IS NULL OR NOT FL_EXCLUIDO", nativeQuery = true)
    List<Pedidos> findAll();

    @Query(value = "SELECT nextval('SEQ_NRO_PEDIDO')", nativeQuery = true)
    Long getNextNroPedido();

    @Modifying
    @Query(value = "UPDATE PEDIDOS SET SITUACAO = :situacao WHERE ID = :pedidoId", nativeQuery = true)
    void atualizarSituacaoPedido(@Param("pedidoId") Long pedidoId, @Param("situacao") String situacao);

    @Modifying
    @Query(value = "UPDATE PEDIDOS SET FL_EXCLUIDO = TRUE WHERE ID = :pedidoId", nativeQuery = true)
    void excluirPedido(@Param("pedidoId") Long pedidoId);


}
