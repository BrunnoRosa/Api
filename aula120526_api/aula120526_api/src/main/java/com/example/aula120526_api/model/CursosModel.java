package com.example.aula120526_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tab_cursos")
public class CursosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCurso;
    private String cargaHoraria;
    private String dias;
    private String semestre;
    private String disciplinas;

    public CursosModel() {
    }

    public CursosModel(Long id, String nomeCurso, String cargaHoraria, String dias, String semestre, String disciplinas) {
        this.id = id;
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.dias = dias;
        this.semestre = semestre;
        this.disciplinas = disciplinas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
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
