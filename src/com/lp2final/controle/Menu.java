package com.lp2final.controle;

import com.lp2final.modelo.AtividadeFeita;
import com.lp2final.modelo.AtividadeFisica;
import com.lp2final.modelo.Perfil;
import com.lp2final.modelo.Relatorio;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Menu {

    public void perfilMenu(String arquivoPerfil){

        Scanner scan = new Scanner(System.in);
        PerfilControle a = new PerfilControle(arquivoPerfil);
        Perfil perfil = a.getPerfil();
        int escSub;

        while (true){
            System.out.println("**** Perfil ****");

            perfil.mostraPerfil();

            System.out.println("1 - Editar Perfil" +
                    "\n2 - Definir metas (Calorias/tempo) " +
                    "\n3 - Mostras todos os Pesos" +
                    "\n0 - Sair");
            escSub = scan.nextInt();
            scan.nextLine();

            if(escSub == 0){
                break;
            }

            if(escSub == 1){

                while (true) {
                    System.out.println("**** Edita ****");
                    String sub = "";
                    int alterar;

                    System.out.println("1 - Alterar o nome" +
                            "\n2 - Alterar Idade" +
                            "\n3 - Alterar Alturar" +
                            "\n4 - Alterar Peso" +
                            "\n0 - Sair");
                    alterar = scan.nextInt();
                    scan.nextLine();
                    if(alterar == 0){
                        break;
                    }

                    if (alterar == 1) {
                        System.out.println("Digite um novo nome");
                        sub = scan.nextLine();
                        a.editarPerfil("Nome", sub);
                        perfil.setNome(sub);
                    }
                    if (alterar == 2) {
                        System.out.println("Digite Sua nova idade");
                        sub = scan.nextLine();
                        a.editarPerfil("Idade", sub);
                        perfil.setIdade( Integer.valueOf(sub).intValue());
                    }
                    if (alterar == 3) {
                        System.out.println("Digite Sua nova altura");
                        sub = scan.nextLine();
                        sub = sub.replace(",",".");
                        a.editarPerfil("Altura", sub);
                        perfil.setAltura( Double.valueOf(sub).doubleValue());
                    }
                    if (alterar == 4) {
                        System.out.println("Digite Seu novo peso");
                        sub = scan.nextLine();
                        sub = sub.replace(",",".");
                        a.editarPerfil("Peso", sub);
                        perfil.setPeso(Double.valueOf(sub).doubleValue());
                        a.setPesoArquivo(sub);

                    }
                }
            }


            if(escSub == 2){

                while(true){
                    System.out.println("**** Metas ****");
                    System.out.println("1 - Definir metas de por dia Calorias" +
                            "\n2 - Definir metas de tempo de exercicios por dia" +
                            "\n0 - Sair");
                    int d;
                    String meta;
                    d = scan.nextInt();
                    scan.nextLine();

                    if(d == 0){
                        break;
                    }

                    if(d == 1){
                        System.out.println("Qual é a meta de calorias diarias?");
                        meta = scan.nextLine();
                        if(a.editarPerfil("MetaCal",meta)){
                            perfil.setMetaCal(meta);
                            System.out.println("Meta cadastrada com sucesso");
                        }else{
                            System.out.println("Ocorreu um erro");
                        }

                    }

                    if(d == 2){
                        System.out.println("Qual é de tempo de ativiades Diaria?");
                        meta = scan.nextLine();
                        if(a.editarPerfil("MetaTemp",meta)){
                            perfil.setMetaTemp(meta);
                            System.out.println("Meta cadastrada com sucesso");
                        }else{
                            System.out.println("Ocorreu um erro");
                        }


                    }

                }


            }

            if(escSub == 3){

                System.out.println("Esses sao todos os pesos que voce ja teve...");
                ArrayList<String> pesos = a.getPesototal();
                ArrayList<String> data = a.getDataPesoTotal();
                for(int i = 0;i<pesos.size();i++){

                    System.out.println("Data: "+ data.get(i)+", Kg:"+ pesos.get(i)+"\n");

                }
            }

        }

    }

    public void atividadesFisicasMenu(String arquivoPerfil) {
        AtividadesControle atividadesControle = new AtividadesControle(arquivoPerfil);
        if (!atividadesControle.getCaminhoAtividades().toFile().exists()) {
            try {
                new AtividadesBD(arquivoPerfil);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        ArrayList<AtividadeFisica> atividadesFisicas;
        ArrayList<AtividadeFeita> atividadesFeitas;
        Scanner scanner = new Scanner(System.in);
        int resposta, atividade;
        AtividadeFeita atividadeFeita;
        String strAtividade, descricao;
        Integer duracao;

        while(true) {
            System.out.println("[ATIVIDADES]");
            System.out.println("[1] Adicionar atividade física");
            System.out.println("[2] Listar atividades feitas");
            System.out.println("[0] Sair");
            resposta = scanner.nextInt();
            scanner.nextLine();

            switch(resposta) {
                default:
                case 0:
                    resposta = 0;
                    break;
                case 1:
                    atividadesFisicas = new ArrayList<>();
                    try {
                        atividadesFisicas = atividadesControle.lerAtividades();
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    System.out.println("[ADICIONAR ATIVIDADE FÍSICA]");
                    for (int i = 1; i <= atividadesFisicas.size(); i++) {
                        System.out.printf("[%d] %s\n", i, atividadesFisicas.get(i-1).getNome());
                    }
                    System.out.printf("\n[%d] Nova atividade\n", atividadesFisicas.size() + 1);
                    System.out.println("[0] Sair");
                    atividade = scanner.nextInt();
                    scanner.nextLine();
                    atividade--;
                    if (atividade >= 0 && atividade < atividadesFisicas.size()) {
                        System.out.println("[ATIVIDADE]");
                        System.out.printf("Atividade: %s\n", atividadesFisicas.get(atividade).getNome());
                        System.out.print("Descrição:\n> ");
                        descricao = scanner.nextLine();
                        System.out.print("Duração:\n> ");
                        duracao = scanner.nextInt();
                        scanner.nextLine();
                        atividadeFeita = new AtividadeFeita(new PerfilControle(arquivoPerfil).getPerfil(), Instant.now(), atividadesFisicas.get(atividade), descricao, duracao);
                        try {
                            atividadesControle.escreverAtividadeFeita(atividadeFeita);
                        } catch (IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Atividade adicionada.");
                    } else if (atividade == atividadesFisicas.size()) {
                        System.out.println("[NOVA ATIVIDADE]");
                        System.out.print("Atividade:\n> ");
                        strAtividade = scanner.nextLine();
                        System.out.print("Descrição:\n> ");
                        descricao = scanner.nextLine();
                        System.out.print("Duração:\n> ");
                        duracao = scanner.nextInt();
                        scanner.nextLine();
                        try {
                            atividadesControle.escreverAtividade(new AtividadeFisica(strAtividade, null));
                            atividadesControle.escreverAtividadeFeita(new AtividadeFeita(new PerfilControle(arquivoPerfil).getPerfil(), Instant.now(), new AtividadeFisica(strAtividade, null), descricao, duracao));
                        } catch (IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    atividadesFeitas = new ArrayList<>();
                    try {
                        atividadesFeitas = atividadesControle.lerAtividadesFeitas();
                    } catch (IOException | ClassNotFoundException e) {
                        //e.printStackTrace();
                    }
                    System.out.println("[ATIVIDADES FEITAS]");
                    for (int i = 1; i <= atividadesFeitas.size(); i++) {
                        System.out.printf("[%d] %s\n", i, atividadesFeitas.get(i-1));
                    }
                    if (atividadesFeitas.size() == 0) {
                        System.out.println("Não há nenhuma atividade feita.");
                    }
                    System.out.println("Pressione [Enter] para continuar...");
                    scanner.nextLine();
                    break;
            }
            if (resposta == 0) {
                break;
            }
        }
    }

    public void relatorioMenu(String arquivoPerfil) {
        PerfilControle perfilControle = new PerfilControle(arquivoPerfil);
        AtividadesControle atividadesControle = new AtividadesControle(arquivoPerfil);
        ArrayList<AtividadeFeita> atividadesFeitas = new ArrayList<>();
        ArrayList<String> dataPesoTotal = perfilControle.getDataPesoTotal();
        ArrayList<String> pesoTotal = perfilControle.getPesototal();
        try {
            atividadesFeitas = atividadesControle.lerAtividadesFeitas();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        Relatorio relatorio = new Relatorio(arquivoPerfil);
        int resposta, atividade, dia, mes, ano;
        String dataInicial, dataFinal;
        AtividadeFeita atividadeFeita;
        String strAtividade, descricao;
        Integer duracao;

        while(true) {
            System.out.println("[RELATÓRIO]");
            System.out.println("[1] Exibir relatório");
            System.out.println("[0] Sair");
            resposta = scanner.nextInt();
            scanner.nextLine();

            switch(resposta) {
                default:
                case 0:
                    resposta = 0;
                    break;
                case 1:
                    System.out.println("[DATA INICIAL]");
                    System.out.print("Dia: ");
                    dia = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Mês: ");
                    mes = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ano: ");
                    ano = scanner.nextInt();
                    scanner.nextLine();
                    dataInicial = String.format("%04d", ano) + "/" + String.format("%02d", mes) + "/" + String.format("%02d", dia);
                    System.out.println("[DATA FINAL]");
                    System.out.print("Dia: ");
                    dia = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Mês: ");
                    mes = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ano: ");
                    ano = scanner.nextInt();
                    scanner.nextLine();
                    dataFinal = String.format("%04d", ano) + "/" + String.format("%02d", mes) + "/" + String.format("%02d", dia);

                    System.out.println("[PERFIL]");
                    System.out.printf("Nome: %s\n", perfilControle.getPerfil().getNome());
                    System.out.printf("Peso: %.2f\n", perfilControle.getPerfil().getPeso());
                    System.out.printf("Altura: %.2f\n", perfilControle.getPerfil().getAltura());
                    System.out.printf("Idade: %d\n", perfilControle.getPerfil().getIdade());
                    System.out.printf("Meta de calorias: %s\n", perfilControle.getPerfil().getMetaCal());
                    System.out.printf("Meta de tempo: %s\n", perfilControle.getPerfil().getMetaTemp());
                    System.out.printf("IMC: %.2f (%s)\n", perfilControle.getPerfil().imc(), perfilControle.getPerfil().imcClassificacao());

                    System.out.println("\n[HISTÓRICO DE PESOS]");
                    for (int i = 0; i < dataPesoTotal.size(); i++) {
                        System.out.printf("[%s] %s kg\n", dataPesoTotal.get(i), pesoTotal.get(i));
                    }

                    System.out.println("\n[ATIVIDADES FEITAS]");
                    for (AtividadeFeita atividadeFeita_ : relatorio.getAtividadesFeitas(dataInicial, dataFinal)) {
                        System.out.println(atividadeFeita_);
                    }
                    System.out.printf("\nMédia de gastos calóricos: %.2f\n", relatorio.getMediaGastosCaloricos(dataInicial, dataFinal));
                    System.out.printf("Média de atividades por dia: %.2f\n", relatorio.getMediaAtividades(dataInicial, dataFinal));
                    break;
            }
            if (resposta == 0) {
                break;
            }
        }
    }

}
