package com.lp2final.modelo;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class AtividadeFeita implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Date data;
    private AtividadeFisica atividadeFisica;
    private String descricao;
    private Integer duracao;

    public AtividadeFeita(Date data, AtividadeFisica atividadeFisica, String descricao, Integer duracao) {
        this.data = data;
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
