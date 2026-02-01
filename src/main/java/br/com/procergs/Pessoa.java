package br.com.procergs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremento
    private Long id;

    private String nome;
    private String cargo;

    // Construtor vazio é OBRIGATÓRIO para o JPA
    public Pessoa() {
    }

    public Pessoa(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

    // Getters e Setters (Obrigatórios para o encapsulamento funcionar no JSF/JPA)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
}
