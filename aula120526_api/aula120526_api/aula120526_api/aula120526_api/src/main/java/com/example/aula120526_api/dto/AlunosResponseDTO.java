package com.example.aula120526_api.dto;

public class AlunosResponseDTO {
    private String nome;
    private String matricula;
    private String idade;
    private String telefone;

    public AlunosResponseDTO() {
    }

    public AlunosResponseDTO(String nome, String matricula, String idade, String telefone) {
        this.nome = nome;
        this.matricula = matricula;
        this.idade = idade;
        this.telefone = telefone;
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

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
