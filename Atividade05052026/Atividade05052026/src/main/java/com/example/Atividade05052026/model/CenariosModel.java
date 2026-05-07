package com.example.Atividade05052026.model;

import com.example.Atividade05052026.model.enums.Ambiente;
import com.example.Atividade05052026.model.enums.Espaco;
import jakarta.persistence.*;

@Entity
@Table(name="tab_cenarios")
public class CenariosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Ambiente ambiente;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Espaco espaco;

    public CenariosModel() {
    }

    public CenariosModel(Long id, String nome, String tipo, Ambiente ambiente, Espaco espaco) {
        Id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.ambiente = ambiente;
        this.espaco = espaco;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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