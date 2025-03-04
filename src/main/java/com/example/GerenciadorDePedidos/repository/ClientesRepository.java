package com.example.GerenciadorDePedidos.repository;

import com.example.GerenciadorDePedidos.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {
    @Query(value = "SELECT * FROM CLIENTES WHERE FL_EXCLUIDO IS NULL OR NOT FL_EXCLUIDO", nativeQuery = true)
    List<Clientes> findAll();

    @Modifying
    @Query(value = "UPDATE CLIENTES SET FL_EXCLUIDO = TRUE WHERE ID = :clienteId", nativeQuery = true)
    void excluirCliente(@Param("clienteId") Long clienteId);
}
