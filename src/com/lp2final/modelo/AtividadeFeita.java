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
    private Double caloriasPerdidas;

    public AtividadeFeita(Perfil perfil, Date data, AtividadeFisica atividadeFisica, String descricao, Integer duracao) {
        this.data = data;
        this.atividadeFisica = atividadeFisica;
        this.descricao = descricao;
        this.duracao = duracao;
        this.caloriasPerdidas = this.atividadeFisica.getTaxaCalorias() * perfil.getPeso() * duracao;
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

    public Double getCaloriasPerdidas() {
        return caloriasPerdidas;
    }

    @Override
    public String toString() {
        return "AtividadeFeita{" +
                "data=" + data +
                ", atividadeFisica=" + atividadeFisica.getNome() +
                ", descricao='" + descricao + '\'' +
                ", duracao=" + duracao +
                ", caloriasPerdidas=" + caloriasPerdidas +
                '}';
    }
}
