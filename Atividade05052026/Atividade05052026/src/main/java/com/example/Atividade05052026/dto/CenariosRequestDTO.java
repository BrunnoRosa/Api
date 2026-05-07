package com.example.Atividade05052026.dto;

import com.example.Atividade05052026.model.enums.Ambiente;
import com.example.Atividade05052026.model.enums.Espaco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CenariosRequestDTO {

    @NotBlank(message = "⚠️O nome é Obrigatório.⚠️")
    @Size(max = 100)
    private String nome;

    @NotBlank(message = "⚠️O tipo de Cenário é Obrigatório.⚠️")
    @Size (min = 3, max = 50)
    private String tipo;

    @NotNull(message = "⚠️É Obrigatório definir um ambiente.⚠️")
    private Ambiente ambiente;

    @NotNull(message = "⚠️É Obrigatório informar o espaço.⚠️")
    private Espaco espaco;

    public CenariosRequestDTO() {
    }

    public CenariosRequestDTO(String nome, String tipo, Ambiente ambiente, Espaco espaco) {
        this.nome = nome;
        this.tipo = tipo;
        this.ambiente = ambiente;
        this.espaco = espaco;
    }

    public @NotBlank(message = "⚠️O nome é Obrigatório.⚠️") @Size(max = 100) String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "⚠️O nome é Obrigatório.⚠️") @Size(max = 100) String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "⚠️O tipo de Cenário é Obrigatório.⚠️") @Size(min = 3, max = 50) String getTipo() {
        return tipo;
    }

    public void setTipo(@NotBlank(message = "⚠️O tipo de Cenário é Obrigatório.⚠️") @Size(min = 3, max = 50) String tipo) {
        this.tipo = tipo;
    }

    public @NotNull(message = "⚠️É Obrigatório definir um ambiente.⚠️") Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(@NotNull(message = "⚠️É Obrigatório definir um ambiente.⚠️") Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public @NotNull(message = "⚠️É Obrigatório informar o espaço.⚠️") Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(@NotNull(message = "⚠️É Obrigatório informar o espaço.⚠️") Espaco espaco) {
        this.espaco = espaco;
    }
}
