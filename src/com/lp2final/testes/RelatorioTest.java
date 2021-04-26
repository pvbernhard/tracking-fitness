package com.lp2final.testes;

import com.lp2final.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;

class RelatorioTest {

    Perfil perfil;

    public RelatorioTest() {
        perfil = new Perfil("Teste", 18, 1.7, 60.0);

    }

    @Test
    void testGetPerfil() {
        Assertions.assertEquals("Teste", new Relatorio(perfil, new ArrayList<AtividadeFeita>()).getPerfil().getNome());
    }

    @Test
    void testGetAtividadesFeitas() {
        ArrayList<AtividadeFeita> atividades = new ArrayList<>();
        Assertions.assertEquals(atividades, new Relatorio(perfil, atividades).getAtividadesFeitas());
    }

    @Test
    void testGetMediaGastosCaloricos() {
        ArrayList<AtividadeFeita> atividades = new ArrayList<>();
        Assertions.assertEquals(0.0, new Relatorio(perfil, atividades).getMediaGastosCaloricos(Instant.MIN, Instant.MAX));
    }

    @Test
    void testGetMediaAtividades() {
        ArrayList<AtividadeFeita> atividades = new ArrayList<>();
        Assertions.assertEquals(0.0, new Relatorio(perfil, atividades).getMediaAtividades(Instant.MIN, Instant.MAX));
    }
}