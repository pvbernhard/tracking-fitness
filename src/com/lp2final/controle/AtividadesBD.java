package com.lp2final.controle;

import com.lp2final.modelo.AtividadeFisica;

import java.io.IOException;
import java.util.ArrayList;

public class AtividadesBD {

    public AtividadesBD(String nomeArquivo) throws IOException {
        this.salvarParaArquivo(nomeArquivo);
    }

    private void salvarParaArquivo(String nomeArquivo) throws IOException {
        AtividadesControle atividadesControle = new AtividadesControle(nomeArquivo);

        ArrayList<AtividadeFisica> bd = this.BD();

        for(AtividadeFisica atividadeFisica : bd) {
            atividadesControle.escreverAtividade(atividadeFisica, false);
        }
    }

    private ArrayList<AtividadeFisica> BD() {
        ArrayList<AtividadeFisica> atividades = new ArrayList<>();
        atividades.add(new AtividadeFisica("Dança Aeróbica (Casual)", 5.0));
        atividades.add(new AtividadeFisica("Dança Aeróbica (Moderada)", 6.5));
        atividades.add(new AtividadeFisica("Dança Aeróbica (Intensa)", 7.0));
        atividades.add(new AtividadeFisica("Basquete (jogo)", 8.0));
        atividades.add(new AtividadeFisica("Basquete (fora do jogo, geral)", 6.0));
        atividades.add(new AtividadeFisica("Basquete (cestos de tiro)", 4.5));
        atividades.add(new AtividadeFisica("Calistenia (intensa)", 8.0));
        atividades.add(new AtividadeFisica("Calistenia (moderada)", 3.5));
        atividades.add(new AtividadeFisica("Ciclismo (8.85 km/h)", 4.0));
        atividades.add(new AtividadeFisica("Ciclismo (19.0-21.0 km/h)", 8.0));
        atividades.add(new AtividadeFisica("Ciclismo (25.0-30.0 km/h, Corrida)", 12.0));
        atividades.add(new AtividadeFisica("Dança (casual)", 3.0));
        atividades.add(new AtividadeFisica("Dança (Rápido)", 5.5));
        atividades.add(new AtividadeFisica("Ginástica", 4.0));
        atividades.add(new AtividadeFisica("Caminhada (Cross Country)", 6.0));
        atividades.add(new AtividadeFisica("Trabalho Doméstico", 3.0));
        atividades.add(new AtividadeFisica("Corda de Pular (Rápido)", 12.0));
        atividades.add(new AtividadeFisica("Corda de Pular (Lento)", 8.0));
        atividades.add(new AtividadeFisica("Artes Marciais", 10.0));
        atividades.add(new AtividadeFisica("Motocross", 4.0));
        atividades.add(new AtividadeFisica("Alpinismo", 8.0));
        atividades.add(new AtividadeFisica("Patins (casual)", 11.0));
        atividades.add(new AtividadeFisica("Patins (rápido)", 12.0));
        atividades.add(new AtividadeFisica("Máquina de remo (extremo)", 10.5));
        atividades.add(new AtividadeFisica("Máquina de remo (moderado)", 7.0));
        atividades.add(new AtividadeFisica("Corrida (Geral)", 7.0));
        atividades.add(new AtividadeFisica("Corrida (8.0 km/h, 8.0 min km)", 8.0));
        atividades.add(new AtividadeFisica("Corrida (9.5 km/h, 6.0 min km)", 10.0));
        atividades.add(new AtividadeFisica("Corrida (11.0 km/h, 5.5 min km)", 11.5));
        atividades.add(new AtividadeFisica("Corrida (12.5 km/h, 5.0 min km)", 13.5));
        atividades.add(new AtividadeFisica("Corrida (16.0 km/h, 4.0 min km)", 16.0));
        atividades.add(new AtividadeFisica("Corrida (Cross Country)", 9.0));
        atividades.add(new AtividadeFisica("Sentado (trabalho de escritório)", 1.5));
        atividades.add(new AtividadeFisica("Sentado (silenciosamente)", 1.0));
        atividades.add(new AtividadeFisica("Skate", 5.0));
        atividades.add(new AtividadeFisica("Futebol (Competitivo)", 10.0));
        atividades.add(new AtividadeFisica("Futebol (casual, geral)", 7.0));
        atividades.add(new AtividadeFisica("Softbol", 5.0));
        atividades.add(new AtividadeFisica("Squash", 12.0));
        atividades.add(new AtividadeFisica("Escada", 8.0));
        atividades.add(new AtividadeFisica("Em pé (trabalho de escritório)", 2.3));
        atividades.add(new AtividadeFisica("Em pé (silenciosamente)", 1.0));
        atividades.add(new AtividadeFisica("Alongamento / Hatha Yoga", 2.5));
        atividades.add(new AtividadeFisica("Natação (casual)", 7.0));
        atividades.add(new AtividadeFisica("Natação (vigorosa)", 10.0));
        atividades.add(new AtividadeFisica("Tênis de mesa / pingue-pongue", 4.0));
        atividades.add(new AtividadeFisica("Tai Chi", 4.0));
        atividades.add(new AtividadeFisica("Tênis (duplas)", 6.0));
        atividades.add(new AtividadeFisica("Tênis (sozinho)", 8.0));
        atividades.add(new AtividadeFisica("Voleibol (Casual)", 3.0));
        atividades.add(new AtividadeFisica("Voleibol (Praia)", 8.0));
        atividades.add(new AtividadeFisica("Voleibol (Competitivo)", 8.0));
        atividades.add(new AtividadeFisica("Caminhada (3.0 km/h, Ritmo casual)", 2.0));
        atividades.add(new AtividadeFisica("Caminhada (5.0 km/h, Ritmo moderado)", 3.3));
        atividades.add(new AtividadeFisica("Caminhada (5.5 km/h, Ritmo acelerado)", 3.8));
        atividades.add(new AtividadeFisica("Caminhando (6.5 km/h, Ritmo muito rápido)", 5.0));
        atividades.add(new AtividadeFisica("Caminhando (8.0 km/h, Ritmo mais rápido)", 9.0));
        atividades.add(new AtividadeFisica("Polo Aquático", 10.0));
        atividades.add(new AtividadeFisica("Treinamento com Peso (Intenso)", 6.0));
        atividades.add(new AtividadeFisica("Treinamento com Peso (Normal)", 3.0));
        atividades.add(new AtividadeFisica("Capinar (Pesado)", 5.5));
        atividades.add(new AtividadeFisica("Capinar (regular)", 4.0));

        return atividades;
    }
}
