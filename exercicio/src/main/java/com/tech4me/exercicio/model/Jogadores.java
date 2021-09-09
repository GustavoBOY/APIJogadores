package com.tech4me.exercicio.model;

import java.util.InputMismatchException;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("jogadores")
public class Jogadores {
    
    @Id
    private String id;

    private String nome;

    private Integer idade;

    private Double altura;

    private String posicao;

    private Double salario;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        if(salario >= 10000.0) {
            this.salario = salario;
        } else{
            throw new InputMismatchException("Sálario minímo não foi suficiente para a contratação");
        }
    }

    
}
