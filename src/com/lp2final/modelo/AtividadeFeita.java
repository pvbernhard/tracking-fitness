package com.lp2final.modelo;

public class AtividadeFeita {
    private AtividadeFisica atividadeFisica;
    private Integer duracao;

    public AtividadeFeita(AtividadeFisica atividadeFisica, Integer duracao) {
        this.atividadeFisica = atividadeFisica;
        this.duracao = duracao;
    }

    public AtividadeFisica getAtividadeFisica() {
        return atividadeFisica;
    }

    public Integer getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        return "AtividadeFeita{" +
                "atividadeFisica=" + atividadeFisica +
                ", duracao=" + duracao +
                '}';
    }
}
