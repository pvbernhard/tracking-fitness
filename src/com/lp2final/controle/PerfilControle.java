package com.lp2final.controle;

import com.lp2final.modelo.Perfil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PerfilControle {

    private final String PASTA = "config";
    private final String nome = "Perfil.dat";

    Path caminho = Paths.get(this.PASTA, this.nome);

    public boolean perfilExist(){
        if(Files.exists( caminho )){
            return true;
        }else{
            return false;
        }

    }


    public ArrayList<String> acessaPerfil() {
        BufferedReader conteudo = null;
        String linha = "";
        ArrayList<String> perfil = new ArrayList<>();

        try {

            conteudo = new BufferedReader(new FileReader(caminho.toFile()));

            while ((linha = conteudo.readLine()) != null) {

                String dados[] = linha.split(";");

                perfil.add(dados[1]);

            }
            return perfil;
        } catch (
                FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado:" + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("IndexOutBouds: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Erro: " + e.getMessage());
        } finally {
            if (conteudo != null) {
                try {
                    conteudo.close();
                } catch (IOException e) {
                    System.out.println("IO Erro: " + e.getMessage());
                }
            }
        }

        return null;

    }

    public void editarPerfil(String tipo, String novo){

        BufferedReader conteudo = null;
        String linha = "";


        try (FileWriter criar = new FileWriter(caminho.toFile(), true);
             BufferedWriter buffer = new BufferedWriter(criar);
             PrintWriter escrever = new PrintWriter(buffer);) {

            conteudo = new BufferedReader(new FileReader(caminho.toFile()));
            ArrayList<String> salvar = new ArrayList<>();

            while ((linha = conteudo.readLine()) != null) {
                // salva tudo dentro de um arrayList+
                String[] dados = linha.split(";");

                if(dados[0].equals(tipo)){
                    dados[1] = novo;
                }
                String linhaAlterada = dados[0]+";"+dados[1];
                salvar.add(linhaAlterada);


            }
            criar.close();
            buffer.close();
            escrever.close();

            // apaga tudo q tinha no arquivo
            FileWriter apg = new FileWriter(caminho.toFile(), true);
            apg.close();

            // escrever tudo no novo arquivo
            FileWriter cNovo = new FileWriter(caminho.toFile());
            BufferedWriter newBuffer = new BufferedWriter(cNovo);

            for (int i = 0; i < salvar.size(); i++) {

                newBuffer.write(salvar.get(i));
                newBuffer.newLine();

            }

            newBuffer.close();
            cNovo.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado:" + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("IndexOutBouds: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Erro: " + e.getMessage());
        } finally {
            if (conteudo != null) {
                try {
                    conteudo.close();
                } catch (IOException e) {
                    System.out.println("IO Erro: " + e.getMessage());
                }
            }
        }

    }

    public void perfilMenu(Perfil perfil){

        Scanner scan = new Scanner(System.in);
        PerfilControle a = new PerfilControle();
        int escSub;

        while (true){
            perfil.mostraPerfil();

            System.out.println("1 - Editar Perfil" +
                    "\n0 - Sair");
            escSub = scan.nextInt();

            if(escSub == 0){
                break;
            }

            if(escSub == 1){

                while (true) {

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
                    }
                }
            }

        }

    }



}
