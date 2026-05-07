package com.example.Atividade05052026.model.enums;

public enum Ambiente {
    RESIDENCIAL("Residenciais"),
    HISTORICO("Históricos"),
    URBANOS("Urbanos");

    private String nome;

    Ambiente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
