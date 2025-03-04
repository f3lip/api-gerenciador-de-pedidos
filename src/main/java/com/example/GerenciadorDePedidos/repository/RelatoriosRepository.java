package com.example.GerenciadorDePedidos.repository;

import com.example.GerenciadorDePedidos.dto.ResumoVendasDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RelatoriosRepository{
    @PersistenceContext
    private EntityManager entityManager;

    public ResumoVendasDTO relatorioResumoVendas() {
        String sql = "SELECT " +
                    "   COUNT(distinct P.ID) AS totalPedidos, " +
                    "   SUM(P2.PRECO * PI.QUANTIDADE) as valorTotalFaturado, " +
                    "   SUM(PI.QUANTIDADE) as totalProdutosVendidos " +
                    "FROM " +
                    "   PEDIDOS_ITENS PI " +
                    "JOIN PEDIDOS P ON " +
                    "   P.ID = PI.I_PEDIDOS " +
                    "   AND (P.FL_EXCLUIDO IS NULL " +
                    "   OR NOT P.FL_EXCLUIDO) " +
                    "JOIN PRODUTOS P2 ON " +
                    "   P2.ID = PI.I_PRODUTOS " +
                    "   AND (P2.FL_EXCLUIDO IS NULL " +
                    "   OR NOT P2.FL_EXCLUIDO) " +
                    "WHERE " +
                    "   (PI.FL_EXCLUIDO IS NULL " +
                    "   OR NOT PI.FL_EXCLUIDO) ";

        Query query = entityManager.createNativeQuery(sql);
        Object[] result = (Object[]) query.getSingleResult();
        ResumoVendasDTO resumoVendas = new ResumoVendasDTO();
        resumoVendas.setTotalPedidos((Long) result[0]);
        resumoVendas.setValorTotalFaturado((Double) result[1]);
        resumoVendas.setTotalProdutosVendidos((Long) result[2]);

        return resumoVendas;
    }
}
