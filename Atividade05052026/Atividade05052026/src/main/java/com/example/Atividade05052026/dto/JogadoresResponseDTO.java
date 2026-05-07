package com.example.Atividade05052026.dto;

import com.example.Atividade05052026.model.enums.Sexo;
import jakarta.validation.constraints.Email;

public class JogadoresResponseDTO {
    private String nome;
    private String idade;
    private Sexo sexo;

    public JogadoresResponseDTO(String nome, String idade, @Email(message = "O e-mail deve ser válido.") String email, Sexo sexo) {
    }

    public JogadoresResponseDTO(String nome, String idade, Sexo sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
