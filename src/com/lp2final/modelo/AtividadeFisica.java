package com.lp2final.modelo;

import java.io.Serial;
import java.io.Serializable;

public class AtividadeFisica implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String nome;
    private Integer segundos;
    private Double taxaCalorias;

    public AtividadeFisica(String nome, Double taxaCalorias) {
        this.nome = nome;
        this.taxaCalorias = taxaCalorias;
    }

    public String getNome() {
        return nome;
    }

    public Integer getSegundos() {
        return segundos;
    }

    public void setSegundos(Integer segundos) {
        this.segundos = segundos;
    }

    public Double getTaxaCalorias() {
        return taxaCalorias;
    }

    @Override
    public String toString() {
        return "AtividadeFisica{" +
                "nome='" + nome + '\'' +
                ", segundos=" + segundos +
                ", taxaCalorias=" + taxaCalorias +
                '}';
    }
}
