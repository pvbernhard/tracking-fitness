package com.lp2final.modelo;

import java.io.Serial;
import java.io.Serializable;

public class AtividadeFeita implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private AtividadeFisica atividadeFisica;
    private String descricao;
    private Integer duracao;

    public AtividadeFeita(AtividadeFisica atividadeFisica, String descricao, Integer duracao) {
        this.atividadeFisica = atividadeFisica;
        this.descricao = descricao;
        this.duracao = duracao;
    }

    public AtividadeFisica getAtividadeFisica() {
        return atividadeFisica;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "AtividadeFeita{" +
                "atividadeFisica=" + atividadeFisica +
                ", duracao=" + duracao +
                '}';
    }
}
