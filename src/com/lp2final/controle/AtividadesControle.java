package com.lp2final.controle;

import com.lp2final.lib.AppendingObjectOutputStream;
import com.lp2final.modelo.AtividadeFeita;
import com.lp2final.modelo.AtividadeFisica;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AtividadesControle {

    private final String PASTA = "config";
    private String nomeArquivo;

    public AtividadesControle(String nomeArquivo) {
        File pasta = new File(this.PASTA);
        if (!pasta.exists()) {
            pasta.mkdir();
        }
        this.nomeArquivo = nomeArquivo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }
    
    public Path getCaminho() {
        return Paths.get(this.PASTA, this.nomeArquivo);
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public void escreverAtividade(AtividadeFisica atividadeFisica) throws IOException {
        this.escreverAtividade(atividadeFisica, true);
    }

    public void escreverAtividade(AtividadeFisica atividadeFisica, Boolean acrescentar) throws IOException {
        if (this.getCaminho().toFile().exists()) {
            FileOutputStream outputArquivo = new FileOutputStream(this.getCaminho().toFile(), acrescentar);
            AppendingObjectOutputStream outputObjeto = new AppendingObjectOutputStream(outputArquivo);

            outputObjeto.writeObject(atividadeFisica);

            outputObjeto.close();
            outputArquivo.close();
        } else {
            FileOutputStream outputArquivo = new FileOutputStream(this.getCaminho().toFile(), acrescentar);
            ObjectOutputStream outputObjeto = new ObjectOutputStream(outputArquivo);

            outputObjeto.writeObject(atividadeFisica);

            outputObjeto.close();
            outputArquivo.close();
        }
    }

    public void escreverAtividadeFeita(AtividadeFeita atividadeFeita) throws IOException {
        this.escreverAtividadeFeita(atividadeFeita, true);
    }

    public void escreverAtividadeFeita(AtividadeFeita atividadeFeita, Boolean acrescentar) throws IOException {
        if (this.getCaminho().toFile().exists()) {
            FileOutputStream outputArquivo = new FileOutputStream(this.getCaminho().toFile(), acrescentar);
            AppendingObjectOutputStream outputObjeto = new AppendingObjectOutputStream(outputArquivo);

            outputObjeto.writeObject(atividadeFeita);

            outputObjeto.close();
            outputArquivo.close();
        } else {
            FileOutputStream outputArquivo = new FileOutputStream(this.getCaminho().toFile(), acrescentar);
            ObjectOutputStream outputObjeto = new ObjectOutputStream(outputArquivo);

            outputObjeto.writeObject(atividadeFeita);

            outputObjeto.close();
            outputArquivo.close();
        }
    }

    public ArrayList<AtividadeFisica> lerAtividades() throws IOException, ClassNotFoundException {
        FileInputStream inputArquivo = new FileInputStream(this.getCaminho().toFile());
        ObjectInputStream inputObjeto = new ObjectInputStream(inputArquivo);

        AtividadeFisica atividadeTemp;
        ArrayList<AtividadeFisica> atividades = new ArrayList<>();

        while (true) {
            try {
                atividadeTemp = (AtividadeFisica) inputObjeto.readObject();
                atividades.add(atividadeTemp);
            } catch (EOFException e) {
                break;
            }
        }

        inputObjeto.close();
        inputArquivo.close();

        return atividades;
    }

    public ArrayList<AtividadeFeita> lerAtividadesFeitas() throws IOException, ClassNotFoundException {
        FileInputStream inputArquivo = new FileInputStream(this.getCaminho().toFile());
        ObjectInputStream inputObjeto = new ObjectInputStream(inputArquivo);

        AtividadeFeita atividadeTemp;
        ArrayList<AtividadeFeita> atividades = new ArrayList<>();

        while (true) {
            try {
                atividadeTemp = (AtividadeFeita) inputObjeto.readObject();
                atividades.add(atividadeTemp);
            } catch (EOFException e) {
                break;
            }
        }

        inputObjeto.close();
        inputArquivo.close();

        return atividades;
    }

}
