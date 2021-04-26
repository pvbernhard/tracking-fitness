package com.lp2final.testes;

import com.lp2final.modelo.Perfil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerfilTest {

    Perfil perfil;

    public PerfilTest() {
        perfil = new Perfil("teste", 18, 1.7, 60.0, "meta tempo", "meta calorias");
    }

    @Test
    void imc() {
        double esperado = 20.76;
        double perfilIMC = perfil.imc();
        perfilIMC *= 100;
        perfilIMC = Math.round(perfilIMC);
        perfilIMC /= 100.0;

        Assertions.assertEquals(esperado, perfilIMC);
    }

    @Test
    void imcClassificacao() {
        Perfil perfilSubpesoSevero = new Perfil("teste", 18, 1.8, 40.0, "meta tempo", "meta calorias");
        Assertions.assertEquals("Subpeso Severo", perfilSubpesoSevero.imcClassificacao());
        Perfil perfilSubpeso = new Perfil("teste", 18, 1.7, 50.0, "meta tempo", "meta calorias");
        Assertions.assertEquals("Subpeso", perfilSubpeso.imcClassificacao());
        Assertions.assertEquals("Normal", perfil.imcClassificacao());
        Perfil perfilSobrepeso = new Perfil("teste", 18, 1.5, 60.0, "meta tempo", "meta calorias");
        Assertions.assertEquals("Sobrepeso", perfilSobrepeso.imcClassificacao());
        Perfil perfilObeso = new Perfil("teste", 18, 1.5, 70.0, "meta tempo", "meta calorias");
        Assertions.assertEquals("Obeso", perfilObeso.imcClassificacao());
        Perfil perfilObesoMorbido = new Perfil("teste", 18, 1.5, 90.0, "meta tempo", "meta calorias");
        Assertions.assertEquals("Obeso Mórbido", perfilObesoMorbido.imcClassificacao());
    }

    @Test
    void getNome() {
        Assertions.assertEquals("teste", perfil.getNome());
    }

    @Test
    void getIdade() {
        Assertions.assertEquals(18, perfil.getIdade());
    }

    @Test
    void getAltura() {
        Assertions.assertEquals(1.7, perfil.getAltura());
    }

    @Test
    void getPeso() {
        Assertions.assertEquals(60.0, perfil.getPeso());
    }

    @Test
    void getMetaTemp() {
        Assertions.assertEquals("meta tempo", perfil.getMetaTemp());
    }

    @Test
    void getMetaCal() {
        Assertions.assertEquals("meta calorias", perfil.getMetaCal());
    }
}