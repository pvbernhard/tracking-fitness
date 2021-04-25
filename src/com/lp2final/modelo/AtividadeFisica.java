package com.lp2final.modelo;

import java.io.Serial;
import java.io.Serializable;

public class AtividadeFisica implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String nome;
    private Double taxaCalorias;

    public AtividadeFisica(String nome, Double taxaCalorias) {
        if (nome.length() < 1) {
            this.nome = "SEM_NOME";
        } else {
            this.nome = nome;
        }
        this.taxaCalorias = taxaCalorias;
    }

    public String getNome() {
        return nome;
    }

    public Double getTaxaCalorias() {
        return taxaCalorias;
    }

    @Override
    public String toString() {
        return "AtividadeFisica{" +
                "nome='" + nome + '\'' +
                ", taxaCalorias=" + taxaCalorias +
                '}';
    }
}
