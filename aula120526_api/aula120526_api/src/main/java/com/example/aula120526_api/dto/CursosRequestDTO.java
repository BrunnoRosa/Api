package com.example.aula120526_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CursosRequestDTO {

    @NotBlank(message = "O nome do curso é obrigatório.,")
    private String nomeCurso;

    @NotBlank(message = "Informe a carga horaria que o curso tem.")
    private String cargaHoraria;

    @NotNull(message = "Informe a quantidade ")
    private String dias;

    @NotNull(message = "Informe a quantidade de semestre que o curso tem.")
    private String semestre;

    @NotBlank(message = "Informe quantas Disciplinas tem no curso.")
    private String disciplina;

    public CursosRequestDTO() {
    }

    public CursosRequestDTO(String nomeCurso, String cargaHoraria, String dias, String semestre, String disciplina) {
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.dias = dias;
        this.semestre = semestre;
        this.disciplina = disciplina;
    }

    public @NotBlank(message = "O nome do curso é obrigatório.,") String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(@NotBlank(message = "O nome do curso é obrigatório.,") String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public @NotBlank(message = "Informe a carga horaria que o curso tem.") String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(@NotBlank(message = "Informe a carga horaria que o curso tem.") String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public @NotNull(message = "Informe a quantidade ") String getDias() {
        return dias;
    }

    public void setDias(@NotNull(message = "Informe a quantidade ") String dias) {
        this.dias = dias;
    }

    public @NotNull(message = "Informe a quantidade de semestre que o curso tem.") String getSemestre() {
        return semestre;
    }

    public void setSemestre(@NotNull(message = "Informe a quantidade de semestre que o curso tem.") String semestre) {
        this.semestre = semestre;
    }

    public @NotBlank(message = "Informe quantas Disciplinas tem no curso.") String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(@NotBlank(message = "Informe quantas Disciplinas tem no curso.") String disciplina) {
        this.disciplina = disciplina;
    }
}
