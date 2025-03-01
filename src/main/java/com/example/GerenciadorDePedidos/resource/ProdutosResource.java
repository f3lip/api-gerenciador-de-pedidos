package com.example.GerenciadorDePedidos.resource;

import com.example.GerenciadorDePedidos.model.Produtos;
import com.example.GerenciadorDePedidos.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutosResource {
    @Autowired
    private ProdutosService produtosService;

    @PostMapping
    public Produtos save(@RequestBody Produtos produto) {
        return produtosService.save(produto);
    }
}
