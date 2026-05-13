package com.example.aula120526_api.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AlunosRequestDTO {

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;


    @NotBlank(message = "A matrícula é obrigatória.")
    private String matricula;


    @NotBlank(message = "E-mail Obrigatório.")
    @Email(message = "O e-mail deve ser válido.")
    private String email;


    @NotBlank(message = "A idade é Obrigatória. ")
    private String idade;


    @NotBlank(message = "O telefone deve ser válido")
    private String telefone;

    public AlunosRequestDTO() {
    }

    public AlunosRequestDTO(String nome, String matricula, String email, String idade, String telefone) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.idade = idade;
        this.telefone = telefone;
    }

    public @NotBlank(message = "O nome é obrigatório.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatório.") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "A matrícula é obrigatória.") String getMatricula() {
        return matricula;
    }

    public void setMatricula(@NotBlank(message = "A matrícula é obrigatória.") String matricula) {
        this.matricula = matricula;
    }

    public @NotBlank(message = "E-mail Obrigatório.") @Email(message = "O e-mail deve ser válido.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "E-mail Obrigatório.") @Email(message = "O e-mail deve ser válido.") String email) {
        this.email = email;
    }

    public @NotBlank(message = "A idade é Obrigatória. ") String getIdade() {
        return idade;
    }

    public void setIdade(@NotBlank(message = "A idade é Obrigatória. ") String idade) {
        this.idade = idade;
    }

    public @NotBlank(message = "O telefone deve ser válido") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "O telefone deve ser válido") String telefone) {
        this.telefone = telefone;
    }
}
