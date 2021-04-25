package com.lp2final.modelo;

import java.util.ArrayList;

public class Relatorio {
    private final Perfil perfil;
    private final ArrayList<AtividadeFeita> atividadesFeitas;

    public Relatorio(Perfil perfil, ArrayList<AtividadeFeita> atividadesFeitas) {
        this.perfil = perfil;
        this.atividadesFeitas = atividadesFeitas;

        this.atividadesFeitas.sort((o1, o2) -> o2.getData().compareTo(o1.getData()));
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public ArrayList<AtividadeFeita> getAtividadesFeitas() {
        return atividadesFeitas;
    }
}
