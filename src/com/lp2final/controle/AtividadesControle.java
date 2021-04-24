package com.lp2final.controle;

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

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public void escreverAtividadeBD(AtividadeFisica atividadeFisica) throws IOException {
        this.escreverAtividadeBD(atividadeFisica, true);
    }

    public void escreverAtividadeBD(AtividadeFisica atividadeFisica, Boolean acrescentar) throws IOException {
        Path caminho = Paths.get(this.PASTA, this.nomeArquivo);
        FileOutputStream outputArquivo = new FileOutputStream(caminho.toFile(), acrescentar);
        ObjectOutputStream outputObjeto = new ObjectOutputStream(outputArquivo);

        outputObjeto.writeObject(atividadeFisica);

        outputObjeto.close();
        outputArquivo.close();
    }
}
