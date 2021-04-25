package com.lp2final.modelo;

import com.lp2final.controle.PerfilControle;

import java.util.ArrayList;

public class Relatorio {
    private final Perfil perfil;
    private final ArrayList<AtividadeFeita> atividadesFeitas;

    public Relatorio(String nomeArquivoPerfil, ArrayList<AtividadeFeita> atividadesFeitas) {
        PerfilControle perfilControle = new PerfilControle(nomeArquivoPerfil);
        this.atividadesFeitas = atividadesFeitas;

        this.perfil = perfilControle.getPerfil();

        sortAtividadesFeitas();
    }

    public Relatorio(Perfil perfil, ArrayList<AtividadeFeita> atividadesFeitas) {
        this.perfil = perfil;
        this.atividadesFeitas = atividadesFeitas;

        sortAtividadesFeitas();
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public ArrayList<AtividadeFeita> getAtividadesFeitas() {
        return atividadesFeitas;
    }

    private void sortAtividadesFeitas() {
        this.getAtividadesFeitas().sort((o1, o2) -> o2.getData().compareTo(o1.getData()));
    }
}
