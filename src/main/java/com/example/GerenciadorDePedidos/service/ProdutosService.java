package com.example.GerenciadorDePedidos.service;

import com.example.GerenciadorDePedidos.model.Produtos;
import com.example.GerenciadorDePedidos.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutosService {
    @Autowired
    private ProdutosRepository produtosRepository;

    public Produtos save(Produtos produto) {
        return produtosRepository.save(produto);
    }

    public List<Produtos> listProdutos() {
        return produtosRepository.findAll();
    }

    @Transactional
    public void excluirProduto(Long produtoId) {
        produtosRepository.excluirProduto(produtoId);
    }
}
