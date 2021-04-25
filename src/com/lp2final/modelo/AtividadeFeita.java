package com.lp2final.modelo;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class AtividadeFeita implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Perfil perfil;

    private Date data;
    private AtividadeFisica atividadeFisica;
    private String descricao;
    private Integer duracao;
    private Double caloriasPerdidas;

    public AtividadeFeita(Perfil perfil, Date data, AtividadeFisica atividadeFisica, String descricao, Integer duracao) {
        this.perfil = perfil;
        this.data = data;
        this.atividadeFisica = atividadeFisica;
        this.descricao = descricao;
        this.duracao = duracao;
        this.updateCaloriasPerdidas();
    }

    public Date getData() {
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

    public void setData(Date data) {
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
        this.caloriasPerdidas = this.atividadeFisica.getTaxaCalorias() * this.perfil.getPeso() * this.getDuracao();
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
