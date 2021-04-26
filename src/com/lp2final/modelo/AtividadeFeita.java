package com.lp2final.modelo;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class AtividadeFeita implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Perfil perfil;

    private Instant data;
    private AtividadeFisica atividadeFisica;
    private String descricao;
    private Double duracao;
    private Double caloriasPerdidas;

    public AtividadeFeita(Perfil perfil, String data, AtividadeFisica atividadeFisica, String descricao, Double duracao) {
        this.perfil = perfil;
        this.data = Instant.parse(data.replaceAll("/", "-").concat("T00:00:00Z"));
        this.atividadeFisica = atividadeFisica;
        this.descricao = descricao;
        this.duracao = duracao;
        this.updateCaloriasPerdidas();
    }

    public AtividadeFeita(Perfil perfil, Instant data, AtividadeFisica atividadeFisica, String descricao, Double duracao) {
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

    public String getDia() {
        return this.data.toString().substring(8, 10);
    }

    public String getMes() {
        return this.data.toString().substring(5, 7);
    }

    public String getAno() {
        return this.data.toString().substring(0, 4);
    }

    public AtividadeFisica getAtividadeFisica() {
        return atividadeFisica;
    }

    public Double getDuracao() {
        return duracao;
    }

    public String getDuracaoFormatada() {
        int duracaoSegundos = (int) (duracao * 60.0);
        int minutos = duracaoSegundos / 60;
        int segundos = duracaoSegundos - minutos * 60;
        return String.format("%02d:%02d", minutos, segundos);
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getCaloriasPerdidas() {
        return caloriasPerdidas;
    }

    public String getCaloriasFormatada() {
        if (caloriasPerdidas == null) {
            return "desconhecido";
        } else {
            return String.format("%.2f", caloriasPerdidas);
        }
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

    public String getDescricaoFormatada() {
        if (descricao.length() < 1) {
            return "sem descrição";
        } else {
            return String.format("\"%s\"", descricao);
        }
    }

    public void setDuracao(Double duracao) {
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
        return "[" + this.getDia() + "/" + this.getMes() + "/" + this.getAno() + "] " + atividadeFisica.getNome() +
                ", [duração: " + this.getDuracaoFormatada() +
                ", calorias: " + this.getCaloriasFormatada() +
                ", " + this.getDescricaoFormatada() + "]";
    }
}
