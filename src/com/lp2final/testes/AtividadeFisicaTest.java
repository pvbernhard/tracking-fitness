package com.lp2final.testes;

import com.lp2final.modelo.AtividadeFisica;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AtividadeFisicaTest {

    AtividadeFisica atividadeFisica;

    @Test
    void getNome() {
        String nome = "Corrida";
        Double taxaCalorias = 7.0;
        atividadeFisica = new AtividadeFisica("Corrida", taxaCalorias);
        Assertions.assertEquals(nome, atividadeFisica.getNome());
    }

    @Test
    void getTaxaCalorias() {
        String nome = "Corrida";
        Double taxaCalorias = 7.0;
        atividadeFisica = new AtividadeFisica(nome, taxaCalorias);
        Assertions.assertEquals(taxaCalorias, atividadeFisica.getTaxaCalorias());
    }

    @Test
    void setNomeVazio() {
        atividadeFisica = new AtividadeFisica("", 7.0);
        Assertions.assertEquals("SEM_NOME", atividadeFisica.getNome());
    }

    @Test
    void setTaxaCaloriasVaziaNula() {
        atividadeFisica = new AtividadeFisica("", null);
        Assertions.assertNull(atividadeFisica.getTaxaCalorias());
    }
}