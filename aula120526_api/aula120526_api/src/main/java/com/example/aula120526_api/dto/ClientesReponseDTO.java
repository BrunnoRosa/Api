package com.example.aula120526_api.dto;

import com.example.aula120526_api.model.enums.Sexo;
import jakarta.validation.constraints.NotNull;

public class ClientesReponseDTO {
    private String nome;
    private String telefone;
    private Sexo sexo;
    private String senha;

    public ClientesReponseDTO() {
    }

    public ClientesReponseDTO(String nome, String telefone, Sexo sexo, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.sexo = sexo;
        this.senha = senha;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

