package com.example.aula120526_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "tab_professores")
public class ProfessoresModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @Email(message = "O e-mail deve ser válido.")
    private String email;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String disciplina;

    @Column(nullable = false)
    private String cargaHoraria;

    public ProfessoresModel() {
    }

    public ProfessoresModel(Long id, String nome, String email, String telefone, String disciplina, String cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.disciplina = disciplina;
        this.cargaHoraria = cargaHoraria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public @Email(message = "O e-mail deve ser válido.") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "O e-mail deve ser válido.") String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
