package com.example.Atividade05052026.model.enums;

public enum Espaco {
    FISICO ("Físico"),
    VIRTUAL ("Virtual");

    private String nome;

    Espaco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
