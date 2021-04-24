package com.lp2final.controle;

import com.lp2final.modelo.AtividadeFeita;
import com.lp2final.modelo.AtividadeFisica;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        FileOutputStream outputArquivo = new FileOutputStream(this.getCaminho().toFile(), acrescentar);
        ObjectOutputStream outputObjeto = new ObjectOutputStream(outputArquivo);

        outputObjeto.writeObject(atividadeFisica);

        outputObjeto.close();
        outputArquivo.close();
    }

    public void escreverAtividadeFeita(AtividadeFeita atividadeFeita) throws IOException {
        this.escreverAtividadeFeita(atividadeFeita, true);
    }

    public void escreverAtividadeFeita(AtividadeFeita atividadeFeita, Boolean acrescentar) throws IOException {
        FileOutputStream outputArquivo = new FileOutputStream(this.getCaminho().toFile(), acrescentar);
        ObjectOutputStream outputObjeto = new ObjectOutputStream(outputArquivo);

        outputObjeto.writeObject(atividadeFeita);

        outputObjeto.close();
        outputArquivo.close();
    }

}
