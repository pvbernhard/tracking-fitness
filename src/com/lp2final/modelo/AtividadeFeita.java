package com.lp2final.modelo;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

public class AtividadeFeita implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Perfil perfil;

    private Instant data;
    private AtividadeFisica atividadeFisica;
    private String descricao;
    private Integer duracao;
    private Double caloriasPerdidas;

    public AtividadeFeita(Perfil perfil, Instant data, AtividadeFisica atividadeFisica, String descricao, Integer duracao) {
        this.perfil = perfil;
        this.data = data;
        this.atividadeFisica = atividadeFisica;
        this.descricao = descricao;
        this.duracao = duracao;
        this.updateCaloriasPerdidas();
    }

    public Instant getData() {
        return data;
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

    public void setData(Instant data) {
        this.data = data;
    }

    public void setAtividadeFisica(AtividadeFisica atividadeFisica) {
        this.atividadeFisica = atividadeFisica;
        this.updateCaloriasPerdidas();
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
        this.updateCaloriasPerdidas();
    }

    private void updateCaloriasPerdidas() {
        if (this.atividadeFisica.getTaxaCalorias() != null) {
            this.caloriasPerdidas = this.atividadeFisica.getTaxaCalorias() * this.perfil.getPeso() * this.getDuracao();
        } else {
            this.caloriasPerdidas = null;
        }
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
