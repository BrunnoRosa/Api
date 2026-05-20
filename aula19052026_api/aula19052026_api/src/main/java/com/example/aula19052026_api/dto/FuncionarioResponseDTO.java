package com.example.aula19052026_api.dto;

import com.example.aula19052026_api.model.EnderecoModel;

public class FuncionarioResponseDTO {

    private String nome;
    private String matricula;
    private String dataNascimento;
    private String email;
    private EnderecoModel endereco;

    public FuncionarioResponseDTO() {
    }

    public FuncionarioResponseDTO(String nome, String matricula, String dataNascimento, String email, EnderecoModel endereco) {
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }
}
