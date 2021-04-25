package com.lp2final.testes;

import com.lp2final.modelo.AtividadeFeita;
import com.lp2final.modelo.AtividadeFisica;
import com.lp2final.modelo.Perfil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;

class AtividadeFeitaTest {

    Perfil perfil;
    AtividadeFisica atividadeFisica;
    AtividadeFeita atividadeFeita;

    Instant agora;
    String dia, mes, ano;


    public AtividadeFeitaTest() {
        perfil = new Perfil("Nome", 18, 1.7, 60);
        atividadeFisica = new AtividadeFisica("Corrida", 7.0);
        this.agora = Instant.now();
        atividadeFeita = new AtividadeFeita(perfil, agora, atividadeFisica, "descricao", 1.5);
        this.dia = agora.toString().substring(8, 10);
        this.mes = agora.toString().substring(5, 7);
        this.ano = agora.toString().substring(0, 4);
    }

    @Test
    void getData() {
        Assertions.assertEquals(this.agora, atividadeFeita.getData());
    }

    @Test
    void getDia() {
        Assertions.assertEquals(dia, atividadeFeita.getDia());
    }

    @Test
    void getMes() {
        Assertions.assertEquals(mes, atividadeFeita.getMes());
    }

    @Test
    void getAno() {
        Assertions.assertEquals(ano, atividadeFeita.getAno());
    }

    @Test
    void getAtividadeFisica() {
        Assertions.assertEquals(atividadeFisica.getNome(), atividadeFeita.getAtividadeFisica().getNome());
    }

    @Test
    void getDuracao() {
        Assertions.assertEquals(1.5, atividadeFeita.getDuracao());
    }

    @Test
    void getCaloriasPerdidas() {
        Assertions.assertEquals(630.0, this.atividadeFeita.getCaloriasPerdidas());
    }

    @Test
    void getDescricaoFormatada() {
        Assertions.assertEquals("\"descricao\"", atividadeFeita.getDescricaoFormatada());
        atividadeFeita.setDescricao("");
        Assertions.assertEquals("sem descrição", atividadeFeita.getDescricaoFormatada());
    }
}