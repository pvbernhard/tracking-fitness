package com.lp2final.controle;

import com.lp2final.modelo.AtividadeFeita;
import com.lp2final.modelo.AtividadeFisica;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AtividadesControle {

    private final String PASTA = "config";
    private final String strAtividade = "_atividades";
    private final String nomeArquivoAtividades;
    private final String nomeArquivoFeitas;

    public AtividadesControle(String nomeArquivo) {
        File pasta = new File(this.PASTA);
        if (!pasta.exists()) {
            pasta.mkdir();
        }
        String EXTENSAO = ".dat";
        this.nomeArquivoAtividades = nomeArquivo + strAtividade + EXTENSAO;
        String strFeitas = "Feitas";
        this.nomeArquivoFeitas = nomeArquivo + strAtividade + strFeitas + EXTENSAO;
    }

    public String getStrAtividade() {
        return strAtividade;
    }

    public String getNomeArquivoAtividades() {
        return nomeArquivoAtividades;
    }

    public String getNomeArquivoFeitas() {
        return nomeArquivoFeitas;
    }

    public Path getCaminhoAtividades() {
        return Paths.get(this.PASTA, getNomeArquivoAtividades());
    }

    public Path getCaminhoFeitas() {
        return Paths.get(this.PASTA, getNomeArquivoFeitas());
    }

    public void escreverAtividade(AtividadeFisica atividadeFisica) throws IOException, ClassNotFoundException {
        this.getCaminhoAtividades().toFile().createNewFile();

        ArrayList<AtividadeFisica> atividadesFisicas;
        if (this.getCaminhoAtividades().toFile().length() <= 1) {
            atividadesFisicas = new ArrayList<>();
        } else {
            atividadesFisicas = this.lerAtividades();
        }

        atividadesFisicas.add(atividadeFisica);

        FileOutputStream outputArquivo = new FileOutputStream(this.getCaminhoAtividades().toFile(), false);
        ObjectOutputStream outputObjeto = new ObjectOutputStream(outputArquivo);

        outputObjeto.writeObject(atividadesFisicas);

        outputObjeto.close();
        outputArquivo.close();
    }

    public void escreverAtividadeFeita(AtividadeFeita atividadeFeita) throws IOException, ClassNotFoundException {
        this.getCaminhoFeitas().toFile().createNewFile();

        ArrayList<AtividadeFeita> atividadesFeitas;
        if (this.getCaminhoFeitas().toFile().length() <= 1) {
            atividadesFeitas = new ArrayList<>();
        } else {
            atividadesFeitas = this.lerAtividadesFeitas();
        }

        atividadesFeitas.add(atividadeFeita);

        FileOutputStream outputArquivo = new FileOutputStream(this.getCaminhoFeitas().toFile(), false);
        ObjectOutputStream outputObjeto = new ObjectOutputStream(outputArquivo);

        outputObjeto.writeObject(atividadesFeitas);

        outputObjeto.close();
        outputArquivo.close();
    }

    public ArrayList<AtividadeFisica> lerAtividades() throws IOException, ClassNotFoundException {
        if (!this.getCaminhoAtividades().toFile().exists()) {
            return new ArrayList<>();
        }
        FileInputStream inputArquivo = new FileInputStream(this.getCaminhoAtividades().toFile());
        ObjectInputStream inputObjeto = new ObjectInputStream(inputArquivo);

        ArrayList<AtividadeFisica> atividades = (ArrayList<AtividadeFisica>) inputObjeto.readObject();

        inputObjeto.close();
        inputArquivo.close();

        return atividades;
    }

    public ArrayList<AtividadeFeita> lerAtividadesFeitas() throws IOException, ClassNotFoundException {
        if (!this.getCaminhoFeitas().toFile().exists()) {
            return new ArrayList<>();
        }
        FileInputStream inputArquivo = new FileInputStream(this.getCaminhoFeitas().toFile());
        ObjectInputStream inputObjeto = new ObjectInputStream(inputArquivo);

        ArrayList<AtividadeFeita> atividades = (ArrayList<AtividadeFeita>) inputObjeto.readObject();

        inputObjeto.close();
        inputArquivo.close();

        return atividades;
    }

}
