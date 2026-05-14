package com.example.aula120526_api.dto;

public class ProfessoresResponseDTO {

    private String nome;
    private String email;
    private String disciplina;
    private String cargaHoraria;

    public ProfessoresResponseDTO() {
    }

    public ProfessoresResponseDTO(String nome, String email, String disciplina, String cargaHoraria) {
        this.nome = nome;
        this.email = email;
        this.disciplina = disciplina;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
