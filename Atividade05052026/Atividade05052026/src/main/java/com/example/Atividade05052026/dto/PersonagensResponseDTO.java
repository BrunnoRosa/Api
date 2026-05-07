package com.example.Atividade05052026.dto;

import com.example.Atividade05052026.model.enums.Sexo;

public class PersonagensResponseDTO {

    private String nome;
    private Sexo sexo;
    private String idade;
    private String habilidade;

    public PersonagensResponseDTO(String nome, Sexo sexo, Integer idade, String habilidade) {
    }

    public PersonagensResponseDTO(String nome, Sexo sexo, String idade, String habilidade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.habilidade = habilidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }
}
