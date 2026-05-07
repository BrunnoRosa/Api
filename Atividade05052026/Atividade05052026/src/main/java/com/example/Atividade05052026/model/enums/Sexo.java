package com.example.Atividade05052026.model.enums;

public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    NEUTRO("Neutro");

    private String nome;

    Sexo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
