package com.example.Atividade05052026.dto;


import com.example.Atividade05052026.model.enums.Ambiente;
import com.example.Atividade05052026.model.enums.Espaco;

public class CenariosResponseDTO {

    private String nome;
    private String tipo;
    private Ambiente ambiente;
    private Espaco espaco;

    public CenariosResponseDTO() {
    }

    public CenariosResponseDTO(String nome, String tipo, Ambiente ambiente, Espaco espaco) {
        this.nome = nome;
        this.tipo = tipo;
        this.ambiente = ambiente;
        this.espaco = espaco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }
}
