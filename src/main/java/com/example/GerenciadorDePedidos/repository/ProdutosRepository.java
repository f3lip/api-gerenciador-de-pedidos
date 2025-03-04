package com.example.GerenciadorDePedidos.repository;

import com.example.GerenciadorDePedidos.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
    @Query(value = "SELECT * FROM PRODUTOS WHERE FL_EXCLUIDO IS NULL OR NOT FL_EXCLUIDO", nativeQuery = true)
    List<Produtos> findAll();

    @Modifying
    @Query(value = "UPDATE PRODUTOS SET FL_EXCLUIDO = TRUE WHERE ID = :produtoId", nativeQuery = true)
    void excluirProduto(@Param("produtoId") Long produtoId);
}
