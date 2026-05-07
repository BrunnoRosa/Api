package com.example.Atividade05052026.dto;

import com.example.Atividade05052026.model.enums.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PersonagensRequestDTO {
    @NotBlank (message = "⚠️O nome é Obrigatório.⚠️")
    private String nome;

    @NotNull (message = "⚠️O sexo é Obrigatório.⚠️")
    private Sexo sexo;

    @NotBlank (message = "⚠️A idade é Obrigatório.⚠️")
    private String idade;

    @NotBlank(message = "⚠️A habilidade é Obrigatório.⚠️")
    @Size(max = 50, min = 3)
    private String habilidade;

    public PersonagensRequestDTO() {
    }

    public PersonagensRequestDTO(String nome, Sexo sexo, String idade, String habilidade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.habilidade = habilidade;
    }

    public @NotBlank(message = "⚠️O nome é Obrigatório.⚠️") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "⚠️O nome é Obrigatório.⚠️") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "⚠️O sexo é Obrigatório.⚠️") Sexo getSexo() {
        return sexo;
    }

    public void setSexo(@NotNull(message = "⚠️O sexo é Obrigatório.⚠️") Sexo sexo) {
        this.sexo = sexo;
    }

    public @NotBlank(message = "⚠️A idade é Obrigatório.⚠️") String getIdade() {
        return idade;
    }

    public void setIdade(@NotBlank(message = "⚠️A idade é Obrigatório.⚠️") String idade) {
        this.idade = idade;
    }

    public @NotBlank(message = "⚠️A habilidade é Obrigatório.⚠️") @Size(max = 50, min = 3) String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(@NotBlank(message = "⚠️A habilidade é Obrigatório.⚠️") @Size(max = 50, min = 3) String habilidade) {
        this.habilidade = habilidade;
    }
}
