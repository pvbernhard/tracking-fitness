package com.lp2final.visao;

import com.lp2final.controle.PerfilControle;
import com.lp2final.modelo.AtividadeFisica;
import com.lp2final.modelo.Perfil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int resposta;

        PerfilControle p = new PerfilControle();

        //Se o arquivo existe entao vai direto para o menu se arquivo nao existe criar um novo perfil
        PerfilControle a = new PerfilControle();
        String nome;
        int idade;
        double peso,altura;

        if(!Files.exists(Path.of("Perfil.dat"))) {
            System.out.println("Qual seu nome? ");
            nome = scanner.nextLine();
            System.out.println("Qual Sua idade? ");
            idade = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Qual sua altura ");
            altura = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Quanto voce pesa? ");
            peso = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Perfil Criado.");

            Perfil criar = new Perfil(nome, idade, altura, peso);
            criar.criarArq();
        }

        ArrayList<String> dados = a.acessaPerfil();
        String[] dadosParaConversao =  new String[4];
        int i =0;
        while (i < 4){
            dadosParaConversao[i] = dados.get(i);
            i++;
        }
        nome = dadosParaConversao[0];
        idade = Integer.valueOf(dadosParaConversao[1]).intValue();
        altura =  Double.valueOf(dadosParaConversao[2]).doubleValue();
        peso = Double.valueOf(dadosParaConversao[3]).doubleValue();

        Perfil perfil = new Perfil(nome,idade,altura,peso);


        AtividadeFisica p1 = new AtividadeFisica("Corrida", 1.2);
        AtividadeFisica p2 = new AtividadeFisica("Ioga", 0.7);

        try {
            FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(p1);
            o.writeObject(p2);

            o.close();
            f.close();

            FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            AtividadeFisica pr1 = (AtividadeFisica) oi.readObject();
            AtividadeFisica pr2 = (AtividadeFisica) oi.readObject();

            System.out.println(pr1.toString());
            System.out.println(pr2.toString());

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



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

                    p.perfilMenu(perfil);

                    break;
                case 2:
                    System.out.println("{Apresentar Exercícios}");
                    break;
                case 3:
                    System.out.println("{Apresentar Relatório}");
                    break;
                case 4:
                    System.out.println("{Gerar PDF}");
                    break;
                default:
                    System.out.println("Opção inexistente, voltando ao menu.");
                    break;
            }
        } while(resposta != 0);

    }

}
