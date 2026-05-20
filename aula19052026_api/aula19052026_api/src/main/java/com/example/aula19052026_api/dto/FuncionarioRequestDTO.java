package com.example.aula19052026_api.dto;

import com.example.aula19052026_api.model.EnderecoModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FuncionarioRequestDTO {

    @NotBlank(message = "O nome é obrigatório!❌")
    private String nome;

    @NotBlank(message = "A matrícula é obrigatória!❌'")
    private String matricula;

    @NotBlank(message = ("A data de nascimento é obrigatória!❌"))
    private String dataNascimento;

    @NotNull(message = "O salário é obrigatório!❌")
    private double salario;

    @NotBlank(message = ("O e-mail é obrigatório!❌"))
    private String email;

    @NotNull(message = ("O endereço é obrigatório!❌"))
    private EnderecoModel endereco;

    public FuncionarioRequestDTO() {
    }

    public FuncionarioRequestDTO(String nome, String matricula, String dataNascimento, double salario, String email, EnderecoModel endereco) {
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
        this.email = email;
        this.endereco = endereco;
    }

    public @NotBlank(message = "O nome é obrigatório!❌") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatório!❌") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "A matrícula é obrigatória!❌'") String getMatricula() {
        return matricula;
    }

    public void setMatricula(@NotBlank(message = "A matrícula é obrigatória!❌'") String matricula) {
        this.matricula = matricula;
    }

    public @NotBlank(message = ("A data de nascimento é obrigatória!❌")) String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@NotBlank(message = ("A data de nascimento é obrigatória!❌")) String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @NotNull(message = "O salário é obrigatório!❌")
    public double getSalario() {
        return salario;
    }

    public void setSalario(@NotNull(message = "O salário é obrigatório!❌") double salario) {
        this.salario = salario;
    }

    public @NotBlank(message = ("O e-mail é obrigatório!❌")) String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = ("O e-mail é obrigatório!❌")) String email) {
        this.email = email;
    }

    public @NotNull(message = ("O endereço é obrigatório!❌")) EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull(message = ("O endereço é obrigatório!❌")) EnderecoModel endereco) {
        this.endereco = endereco;
    }
}
