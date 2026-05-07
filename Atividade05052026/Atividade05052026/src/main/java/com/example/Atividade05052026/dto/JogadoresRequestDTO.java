package com.example.Atividade05052026.dto;


import com.example.Atividade05052026.model.enums.Sexo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class JogadoresRequestDTO {

    @NotBlank(message = "⚠️O nome é Obrigatório.⚠️")
    @Size(max = 100)
    private String nome;

    @NotBlank(message = "A idade é obrigatória!")
    private String idade;

    @NotBlank(message = "O e-mail é obrigatório!")
    @Email(message = "Digite um e-mail válido!")
    private String email;

    @NotNull(message = "Você deve informar sua Sexualidade.")
    private Sexo sexo;

    public JogadoresRequestDTO() {
    }

    public JogadoresRequestDTO(String nome, String idade, String email, Sexo sexo) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.sexo = sexo;
    }

    public @NotBlank(message = "⚠️O nome é Obrigatório.⚠️") @Size(max = 100) String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "⚠️O nome é Obrigatório.⚠️") @Size(max = 100) String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "A idade é obrigatória!") @Size(min = 2) String getIdade() {
        return idade;
    }

    public void setIdade(@NotNull(message = "A idade é obrigatória!") @Size(min = 2) String idade) {
        this.idade = idade;
    }

    public @NotBlank(message = "O e-mail é obrigatório!") @Email(message = "Digite um e-mail válido!") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O e-mail é obrigatório!") @Email(message = "Digite um e-mail válido!") String email) {
        this.email = email;
    }

    public @NotNull(message = "Você deve informar sua Sexualidade.") Sexo getSexo() {
        return sexo;
    }

    public void setSexo(@NotNull(message = "Você deve informar sua Sexualidade.") Sexo sexo) {
        this.sexo = sexo;
    }
}
