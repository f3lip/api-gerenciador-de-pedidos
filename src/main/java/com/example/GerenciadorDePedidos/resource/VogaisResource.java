package com.example.GerenciadorDePedidos.resource;

import com.example.GerenciadorDePedidos.model.Vogais;
import com.example.GerenciadorDePedidos.service.VogaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VogaisResource {
    @Autowired
    private VogaisService vogaisService;

    @GetMapping(value = "/obterVogalByString", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Vogais obterVogalByString(@RequestParam String caracteres) {
        return this.vogaisService.obterVogalByString(caracteres);
    }
}
