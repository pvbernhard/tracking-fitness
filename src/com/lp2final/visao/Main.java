package com.lp2final.visao;

import com.lp2final.controle.GerarPdf;
import com.lp2final.controle.Menu;
import com.lp2final.controle.PerfilControle;
import com.lp2final.modelo.AtividadeFisica;
import com.lp2final.modelo.Perfil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // TODO: Gerar PDF
        // TODO: GUI em texto
        // TODO: GUI em Swing
        // TODO: JUnit

        Scanner scanner = new Scanner(System.in);
        int resposta;

        PerfilControle p = new PerfilControle("Perfil");
        GerarPdf pdf = new GerarPdf();
        Menu menu = new Menu();

        //Se o arquivo existe entao vai direto para o menu se arquivo nao existe criar um novo perfil
        String nome;
        int idade;
        double peso,altura;

        if(!p.perfilExist()) {
            System.out.println("Qual seu nome? ");
            nome = scanner.nextLine();
            System.out.println("Qual Sua idade? ");
            idade = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Qual sua altura?(Metros)");
            altura = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Quanto voce pesa?(Kilograma) ");
            peso = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Perfil Criado.");

            Perfil criar = new Perfil(nome, idade, altura, peso);
            p.criarArq(criar,p);
        }
        // pega dados do perfil ja existente
        ArrayList<String> dados = p.acessaPerfil();
        String[] dadosParaConversao =  new String[dados.size()];
        int i =0;
        while (i < dados.size()){
            dadosParaConversao[i] = dados.get(i);
            i++;
        }
        nome = dadosParaConversao[0];
        idade = Integer.valueOf(dadosParaConversao[1]).intValue();
        altura =  Double.valueOf(dadosParaConversao[2]).doubleValue();
        peso = Double.valueOf(dadosParaConversao[3]).doubleValue();
        String cal = dadosParaConversao[5];
        String temp = dadosParaConversao[6];

        Perfil perfil = new Perfil(nome,idade,altura,peso,temp,cal);

        do {
            System.out.println("[MENU]");
            System.out.println("[1] Perfil");
            System.out.println("[2] Exercícios");
            System.out.println("[3] Relatório");
            System.out.println("[4] Gerar PDF");
            System.out.println("[0] Sair");
            resposta = scanner.nextInt();
            scanner.nextLine();

            switch (resposta) {
                case 0:
                    System.out.println("Finalizando.");
                    break;
                case 1:
                    System.out.println("{Perfil}");

                    menu.perfilMenu(perfil);

                    break;
                case 2:
                    System.out.println("{Apresentar Exercícios}");
                    break;
                case 3:
                    System.out.println("{Apresentar Relatório}");
                    break;
                case 4:
                    System.out.println("{Gerar PDF}");
                    pdf.criarPdf(perfil,p);
                    break;
                default:
                    System.out.println("Opção inexistente, voltando ao menu.");
                    break;
            }
        } while(resposta != 0);

    }

}
