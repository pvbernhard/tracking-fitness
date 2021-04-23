package com.lp2final.visao;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int resposta;
        // criar perfil
        // Perfil perfil = new Perfil ...

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
                    System.out.println("{Apresentar Perfil}");
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
