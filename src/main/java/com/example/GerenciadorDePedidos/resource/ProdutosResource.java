package com.example.GerenciadorDePedidos.resource;

import com.example.GerenciadorDePedidos.model.Produtos;
import com.example.GerenciadorDePedidos.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos/")
public class ProdutosResource {
    @Autowired
    private ProdutosService produtosService;

    @PostMapping
    public Produtos save(@RequestBody Produtos produto) {
        return produtosService.save(produto);
    }

    @GetMapping(value = "listProdutos")
    public List<Produtos> listProdutos() {
        return produtosService.listProdutos();
    }

    @PutMapping(value = "excluirProduto")
    public ResponseEntity excluirProduto(@RequestParam Long produtoId) {
        produtosService.excluirProduto(produtoId);
        return ResponseEntity.ok(produtoId);
    }
}
