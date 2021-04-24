package com.lp2final.modelo;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Perfil {

    private final String PASTA = "config";
    private final String nomeArq = "Perfil.dat";

    Path caminho = Paths.get(this.PASTA, this.nomeArq);

    private String nome;
    private int idade;
    private double altura;
    private double peso;
    private String metaTemp = "0.0";
    private String metaCal = "0.0";


    public Perfil(String nome, int idade, double altura, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;

        File pasta = new File(this.PASTA);
        if (!pasta.exists()) {
            pasta.mkdir();
        }

    }

    public Perfil(String nome, int idade, double altura, double peso, String metaTemp, String metaCal) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.metaTemp = metaTemp;
        this.metaCal = metaCal;
    }


    public void criarArq(){

        BufferedReader conteudo = null;
        String escreverNoArq = "";


        try (FileWriter criar = new FileWriter(caminho.toFile(), false);
             BufferedWriter buffer = new BufferedWriter(criar);
             PrintWriter escrever = new PrintWriter(buffer);) {
            escreverNoArq = "Nome;" + this.nome +"\n"+
                    "Idade;" + this.idade +"\n"+
                    "Altura;"+ this.altura+"\n"+
                    "Peso;"+ this.peso+"\n"+
                    "imc;"+this.imc()+"\n" +
                    "MetaCal;"+this.metaCal+"\n" +
                    "MetaTemp;"+this.metaTemp+"\n";
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

    private double imc(){
        double imc = this.peso/(this.altura*this.altura);
        return imc;
    }

    private String imcClassificacao(){
        if(imc() < 16){
            return "Subpeso Severo";
        }else if(imc() > 16 && imc() < 19.9){
            return "Subpeso";
        }else if(imc() > 20 && imc() < 24.9){
            return "Normal";
        }else if(imc() > 25 && imc() < 29.9){
            return "Sobrepeso";
        }else if(imc() > 30 && imc() < 39.9){
            return "Obesa";
        }else{
            return "Obeso Mórbido";
        }
    }

    public void mostraPerfil(){
        String metaT,metaC;
        metaC = getMetaCal();
        metaT = getMetaTemp();

        System.out.println("Nome = "+ this.nome +
                "\nAltura = "+ this.altura+
                "\nPeso = "+this.peso+
                "\nIdade = "+this.idade+
                "\nVoce esta com " + imcClassificacao()+
                "\nSua meta diaria é Caloria:" +metaC+
                "\nSua meta diaria de tempo é:"+ metaT);

    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMetaTemp() {
        return metaTemp;
    }

    public void setMetaTemp(String metaTemp) {
        this.metaTemp = metaTemp;
    }

    public String getMetaCal() {
        return metaCal;
    }

    public void setMetaCal(String metaCal) {
        this.metaCal = metaCal;
    }
}
