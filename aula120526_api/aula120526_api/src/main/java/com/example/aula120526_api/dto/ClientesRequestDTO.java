package com.example.aula120526_api.dto;

import com.example.aula120526_api.model.enums.Sexo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClientesRequestDTO {

    @NotBlank(message = "E-mail Obrigatório.")
    private String nome;

    @NotBlank(message = "E-mail Obrigatório.")
    @Email(message = "O e-mail deve ser válido.")
    private String email;

    @NotBlank(message = "O telefone deve ser válido")
    private String telefone;

    @NotNull(message = "O sexo é obrigatório")
    private Sexo sexo;

    @NotBlank(message = ("A senha é obrigatório ter 8 digitos no máximo."))
    @Size(max = 8)
    private String senha;

    public ClientesRequestDTO() {
    }

    public ClientesRequestDTO(String nome, String email, String telefone, Sexo sexo, String senha) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
        this.senha = senha;
    }

    public @NotBlank(message = "E-mail Obrigatório.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "E-mail Obrigatório.") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "E-mail Obrigatório.") @Email(message = "O e-mail deve ser válido.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "E-mail Obrigatório.") @Email(message = "O e-mail deve ser válido.") String email) {
        this.email = email;
    }

    public @NotBlank(message = "O telefone deve ser válido") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "O telefone deve ser válido") String telefone) {
        this.telefone = telefone;
    }

    public @NotNull(message = "O sexo é obrigatório") Sexo getSexo() {
        return sexo;
    }

    public void setSexo(@NotNull(message = "O sexo é obrigatório") Sexo sexo) {
        this.sexo = sexo;
    }

    public @NotBlank(message = ("A senha é obrigatório ter 8 digitos no máximo.")) @Size(max = 8) String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = ("A senha é obrigatório ter 8 digitos no máximo.")) @Size(max = 8) String senha) {
        this.senha = senha;
    }
}
