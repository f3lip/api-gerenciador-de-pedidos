package com.example.GerenciadorDePedidos.service;

import com.example.GerenciadorDePedidos.model.Vogais;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class VogaisService {
    public Vogais obterVogalByString(String caracteres) {
        List<Character> vogais = Arrays.asList('a', 'e', 'i', 'o', 'u');
        List<Character> consoantes = Arrays.asList('b', 'c', 'd', 'f', 'g', 'h', 'j', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z');
        long tempoInicio = System.currentTimeMillis();
        for(int i = 0; i <= caracteres.length() - 3 ; i++) {
            String subStr = caracteres.substring(i, i + 3);
            System.out.println(subStr);
            if(subStr.length() > 1) {
                boolean iniciaComVogal = vogais.stream().anyMatch(c -> subStr.startsWith(String.valueOf(c)));
                boolean terminaComVogal = vogais.stream().anyMatch(c -> subStr.endsWith(String.valueOf(c)));
                boolean possuiConsoante = consoantes.stream().anyMatch(c -> subStr.contains(String.valueOf(c)));
                boolean ultimaVogalSeRepete = caracteres.chars().filter(c -> subStr.charAt(2) == (char) c).count() > 1;
                if(iniciaComVogal && terminaComVogal && possuiConsoante && !ultimaVogalSeRepete) {
                    long tempoTotal = System.currentTimeMillis() - tempoInicio;
                    return new Vogais(caracteres, String.valueOf(subStr.charAt(2)), tempoTotal + "ms");
                }
            }
        }

        return null;
    }
}
