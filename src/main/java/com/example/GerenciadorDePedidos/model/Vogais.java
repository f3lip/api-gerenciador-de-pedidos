package com.example.GerenciadorDePedidos.model;

public class Vogais {
    private String string;
    private String vogal;
    private String tempoTotal;

    public Vogais(String string, String vogal, String tempoTotal) {
        this.string = string;
        this.vogal = vogal;
        this.tempoTotal = tempoTotal;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getVogal() {
        return vogal;
    }

    public void setVogal(String vogal) {
        this.vogal = vogal;
    }

    public String getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(String tempoTotal) {
        this.tempoTotal = tempoTotal;
    }
}
