package com.lp2final.controle;

import com.lp2final.modelo.Perfil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;

public class PerfilControle {

    private Path caminho;
    private Path caminhoPeso;

    public PerfilControle(){

    }

    public PerfilControle(String nome) {
        String nome1 = nome + ".dat";
        String nomePeso = nome + "Peso.dat";

        String PASTA = "config";
        this.caminho = Paths.get(PASTA, nome1);
        this.caminhoPeso = Paths.get(PASTA, nomePeso);
    }

    public boolean perfilExist(){
        return Files.exists(caminho);

    }

    public boolean perfilPesoExist(){
        return Files.exists(caminhoPeso);

    }

    public Perfil getPerfil(){

        BufferedReader conteudo = null;
        String linha;
        ArrayList<String> dadosPerfil = new ArrayList<>();

        try {

            conteudo = new BufferedReader(new FileReader(caminho.toFile()));

            while ((linha = conteudo.readLine()) != null) {

                String[] dados = linha.split(";");

                dadosPerfil.add(dados[1]);

            }
            String nome,cal,temp;
            int idade;
            double peso,altura;
            nome = dadosPerfil.get(0);
            idade = Integer.parseInt(dadosPerfil.get(1));
            altura = Double.parseDouble(dadosPerfil.get(2));
            peso = Double.parseDouble(dadosPerfil.get(3));
            cal = dadosPerfil.get(5);
            temp = dadosPerfil.get(6);

            return new Perfil(nome,idade,altura,peso,temp,cal);
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

    public ArrayList<String> acessaPerfil() {
        BufferedReader conteudo = null;
        String linha;
        ArrayList<String> perfil = new ArrayList<>();

        try {

            conteudo = new BufferedReader(new FileReader(caminho.toFile()));

            while ((linha = conteudo.readLine()) != null) {

                String[] dados = linha.split(";");

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

    public boolean editarPerfil(String tipo, String novo){

        BufferedReader conteudo = null;
        String linha;


        try (FileWriter criar = new FileWriter(caminho.toFile(), true);
             BufferedWriter buffer = new BufferedWriter(criar);
             PrintWriter escrever = new PrintWriter(buffer)) {

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

            for (String s : salvar) {

                newBuffer.write(s);
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

    private boolean dataRepetida(String dataAtual){

        BufferedReader conteudo = null;
        String linha;
        ArrayList<String> perfil = new ArrayList<>();

        try {

            conteudo = new BufferedReader(new FileReader(caminhoPeso.toFile()));

            while ((linha = conteudo.readLine()) != null) {

                String[] dados = linha.split(";");

                perfil.add(dados[0]);

            }

            for (String s : perfil) {

                if (s.equals(dataAtual)) {
                    return true;
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

    private void editaPeso(String novo, String dataAtual){
        BufferedReader conteudo = null;
        String linha;
        int qlinhas = 0;


        try (FileWriter criar = new FileWriter(caminhoPeso.toFile(), true);
             BufferedWriter buffer = new BufferedWriter(criar);
             PrintWriter escrever = new PrintWriter(buffer)) {

            conteudo = new BufferedReader(new FileReader(caminhoPeso.toFile()));
            conteudo.mark(1000);
            ArrayList<String> salvar = new ArrayList<>();


            while (conteudo.readLine() != null) {
                qlinhas++;
            }
            conteudo.reset();
            while ((linha = conteudo.readLine()) != null) {
                // salva tudo dentro de um arrayList+
                String[] dados = linha.split(";");


                if(qlinhas == 1 ){
                    dados[1] = novo;
                    String linhaAlterada = dados[0]+";"+dados[1];
                    salvar.add(linhaAlterada);
                    continue;
                }

                if(dados[0].equals(dataAtual)){
                    dados[1] = novo;
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

            for (String s : salvar) {

                newBuffer.write(s);
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

    public void setPesoArquivo(String peso){

        String escreverNoArq;
        Calendar d = Calendar.getInstance();

        try (FileWriter criar = new FileWriter(caminhoPeso.toFile(), true);
             BufferedWriter buffer = new BufferedWriter(criar);
             PrintWriter escrever = new PrintWriter(buffer)) {

            String dia = d.get(Calendar.DATE)+"";
            String mes = String.format("%02d", d.get(Calendar.MONTH)+1);
            String ano = d.get(Calendar.YEAR)+"";

            String dataAtual = dia+"/"+mes+"/"+ano;

            if(perfilPesoExist()){
                if(dataRepetida(dataAtual)){
                    editaPeso(peso,dataAtual);
                }else {

                    escreverNoArq = dataAtual +";"+peso+"\n";
                    escrever.append(escreverNoArq);

                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado:" + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("IndexOutBouds: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Erro: " + e.getMessage());
        }

    }

    public void criarArq(Perfil p, PerfilControle pc){

        String escreverNoArq;


        pc.setPesoArquivo(p.getPeso()+"");

        try (FileWriter criar = new FileWriter(caminho.toFile(), false);
             BufferedWriter buffer = new BufferedWriter(criar);
             PrintWriter escrever = new PrintWriter(buffer)) {
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
        }

    }

    public ArrayList<String> getPesototal(){

        BufferedReader conteudo = null;
        String linha;
        ArrayList<String> pesos = new ArrayList<>();

        try {

            conteudo = new BufferedReader(new FileReader(caminhoPeso.toFile()));

            while ((linha = conteudo.readLine()) != null) {

                String[] dados = linha.split(";");

                pesos.add(dados[1]);

            }

            return pesos;

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

    public ArrayList<String> getDataPesoTotal(){


        BufferedReader conteudo = null;
        String linha;
        ArrayList<String> data = new ArrayList<>();

        try {

            conteudo = new BufferedReader(new FileReader(caminhoPeso.toFile()));

            while ((linha = conteudo.readLine()) != null) {

                String[] dados = linha.split(";");

                data.add(dados[0]);

            }

            return data;

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

    public void deletePerfil(){

        caminho.toFile().delete();
        caminhoPeso.toFile().delete();

    }

}
