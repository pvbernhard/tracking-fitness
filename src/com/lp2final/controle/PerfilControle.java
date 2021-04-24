package com.lp2final.controle;

import com.lp2final.modelo.Perfil;

import javax.xml.crypto.Data;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class PerfilControle {

    private final String PASTA = "config";
    private final String nome = "Perfil.dat";
    private final String nomePeso = "PerfilPeso.dat";

    private Path caminho = Paths.get(this.PASTA, this.nome);
    private Path caminhoPeso = Paths.get(this.PASTA,this.nomePeso);

    public boolean perfilExist(){
        if(Files.exists( caminho )){
            return true;
        }else{
            return false;
        }

    }

    public boolean perfilPesoExist(){
        if(Files.exists( caminhoPeso )){
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

    private boolean editarPerfil(String tipo, String novo){

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
            return true;
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

        return false;
    }

    public void perfilMenu(Perfil perfil){

        Scanner scan = new Scanner(System.in);
        PerfilControle a = new PerfilControle();
        int escSub;

        while (true){
            System.out.println("**** Perfil ****");

            perfil.mostraPerfil();

            System.out.println("1 - Editar Perfil" +
                    "\n2 - Definir metas (Calorias/tempo) " +
                    "\n0 - Sair");
            escSub = scan.nextInt();

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
                        a.perdaDePesoTemp(sub);

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

        }

    }

    private boolean dataRepetida(){

        BufferedReader conteudo = null;
        String linha = "";
        ArrayList<String> perfil = new ArrayList<>();

        try {

            conteudo = new BufferedReader(new FileReader(caminhoPeso.toFile()));

            while ((linha = conteudo.readLine()) != null) {

                String dados[] = linha.split(";");

                perfil.add(dados[0]);

            }

            for (int i = 0;i<perfil.size();i++){

                for(int j = 0; i<perfil.size();i++){
                    if(perfil.get(i) == perfil.get(j)){
                        return true;
                    }
                }

            }

            return false;
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

        return false;
    }

    private boolean editaPeso(String novo){
        BufferedReader conteudo = null;
        String linha = "";
        String totalL ="";
        boolean uma = true;
        int qlinhas = 0;


        try (FileWriter criar = new FileWriter(caminhoPeso.toFile(), true);
             BufferedWriter buffer = new BufferedWriter(criar);
             PrintWriter escrever = new PrintWriter(buffer);) {

            conteudo = new BufferedReader(new FileReader(caminhoPeso.toFile()));
            conteudo.mark(1000);
            ArrayList<String> salvar = new ArrayList<>();
            ArrayList<String> rep = new ArrayList<>();

            while ((totalL = conteudo.readLine()) != null) {
                qlinhas++;
            }
            conteudo.reset();
            while ((linha = conteudo.readLine()) != null) {
                // salva tudo dentro de um arrayList+
                String[] dados = linha.split(";");

                if(qlinhas == 1){
                    dados[1] = novo;
                    String linhaAlterada = dados[0]+";"+dados[1];
                    salvar.add(linhaAlterada);
                    continue;
                }

                if(uma){
                    rep.add(dados[0]);
                    uma = false;
                    String linhaAlterada = dados[0]+";"+dados[1];
                    salvar.add(linhaAlterada);
                    continue;
                }

                for(int i = 0;i<rep.size();i++){
                    if(dados[0].equals(rep.get(i))){
                        dados[1] = novo;
                    }
                }

                String linhaAlterada = dados[0]+";"+dados[1];
                salvar.add(linhaAlterada);

            }
            criar.close();
            buffer.close();
            escrever.close();

            // apaga tudo q tinha no arquivo
            FileWriter apg = new FileWriter(caminhoPeso.toFile(), true);
            apg.close();

            // escrever tudo no novo arquivo
            FileWriter cNovo = new FileWriter(caminhoPeso.toFile());
            BufferedWriter newBuffer = new BufferedWriter(cNovo);

            for (int i = 0; i < salvar.size(); i++) {

                newBuffer.write(salvar.get(i));
                newBuffer.newLine();

            }

            newBuffer.close();
            cNovo.close();
            return true;
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

        return false;

    }

    public void perdaDePesoTemp(String peso){

        BufferedReader conteudo = null;
        String escreverNoArq = "";
        Date data = new Date();
        Calendar d = Calendar.getInstance();

        try (FileWriter criar = new FileWriter(caminhoPeso.toFile(), true);
             BufferedWriter buffer = new BufferedWriter(criar);
             PrintWriter escrever = new PrintWriter(buffer);) {

            if(perfilPesoExist()){
                if(dataRepetida()){
                    editaPeso(peso);
                }else {

                    String dia = d.get(5)+"";
                    String mes = d.get(2)+1 +"";
                    String ano = d.get(1)+"";

                    String dataAgora = dia+":"+mes+":"+ano;

                    escreverNoArq = dataAgora +";"+peso+"\n";
                    escrever.append(escreverNoArq);

                }
            }


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

    public void criarArq(){

        BufferedReader conteudo = null;
        String escreverNoArq = "";
        Perfil p = new Perfil();

        try (FileWriter criar = new FileWriter(caminho.toFile(), false);
             BufferedWriter buffer = new BufferedWriter(criar);
             PrintWriter escrever = new PrintWriter(buffer);) {
            escreverNoArq = "Nome;" + p.getNome() +"\n"+
                    "Idade;" + p.getIdade() +"\n"+
                    "Altura;"+ p.getAltura()+"\n"+
                    "Peso;"+ p.getPeso()+"\n"+
                    "imc;"+p.imc()+"\n" +
                    "MetaCal;"+p.getMetaCal()+"\n" +
                    "MetaTemp;"+p.getMetaTemp()+"\n";
            escrever.append(escreverNoArq);

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

}
