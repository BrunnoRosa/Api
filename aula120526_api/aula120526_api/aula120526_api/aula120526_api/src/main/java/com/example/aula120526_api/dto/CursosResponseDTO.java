package com.example.aula120526_api.dto;

public class CursosResponseDTO {

    private String nomeCurso;
    private String cargaHoraria;
    private String semestre;
    private String disciplinas;

    public CursosResponseDTO() {
    }

    public CursosResponseDTO(String nomeCurso, String cargaHoraria, String semestre, String disciplinas) {
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.semestre = semestre;
        this.disciplinas = disciplinas;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(String disciplinas) {
        this.disciplinas = disciplinas;
    }
}
