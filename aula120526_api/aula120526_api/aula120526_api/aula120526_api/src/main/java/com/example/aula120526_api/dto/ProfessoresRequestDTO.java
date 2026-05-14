package com.example.aula120526_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProfessoresRequestDTO {

    @NotBlank(message = "O nome é Obrigatório.")
    private String nome;

    @NotBlank (message = "O e-mail é obrigatório.")
    @Email(message = "O e-mail deve ser válido.")
    private String email;

    @NotBlank(message = "O telefone deve ter o DDD.")
    private String telefone;

    @NotBlank(message = "A disciplina deve ser obrigatória.")
    private String disciplina;

    @NotNull(message = "A carga Horaria é obrigatória.")
    private String cargaHoraria;

    public ProfessoresRequestDTO() {
    }

    public ProfessoresRequestDTO(String nome, String email, String telefone, String disciplina, String cargaHoraria) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.disciplina = disciplina;
        this.cargaHoraria = cargaHoraria;
    }

    public @NotBlank(message = "O nome é Obrigatório.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é Obrigatório.") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O e-mail é obrigatório.") @Email(message = "O e-mail deve ser válido.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O e-mail é obrigatório.") @Email(message = "O e-mail deve ser válido.") String email) {
        this.email = email;
    }

    public @NotBlank(message = "O telefone deve ter o DDD.") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "O telefone deve ter o DDD.") String telefone) {
        this.telefone = telefone;
    }

    public @NotBlank(message = "A disciplina deve ser obrigatória.") String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(@NotBlank(message = "A disciplina deve ser obrigatória.") String disciplina) {
        this.disciplina = disciplina;
    }

    public @NotNull(message = "A carga Horaria é obrigatória.") String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(@NotNull(message = "A carga Horaria é obrigatória.") String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
