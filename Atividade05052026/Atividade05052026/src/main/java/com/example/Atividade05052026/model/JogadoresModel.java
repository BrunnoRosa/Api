package com.example.Atividade05052026.model;


import com.example.Atividade05052026.model.enums.Sexo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "tab_jogadores")
public class JogadoresModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String idade;

    @Column(nullable = false)
    @Email (message = "O e-mail deve ser válido.")
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    public JogadoresModel() {
    }

    public JogadoresModel(long id, String nome, String idade, String email, Sexo sexo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.sexo = sexo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public @Email(message = "O e-mail deve ser válido.") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "O e-mail deve ser válido.") String email) {
        this.email = email;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
