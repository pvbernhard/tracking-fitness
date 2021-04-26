package com.lp2final.visao;

import com.lp2final.controle.PerfilControle;
import com.lp2final.visao.Guii.Gui;
import com.lp2final.visao.Guii.GuiMenu;

public class Main {

    public static void main(String[] args) {

        String arquivoPerfil = "Perfil";
        PerfilControle p = new PerfilControle(arquivoPerfil);
        //Gui
        if(!p.perfilExist()) {
            new Gui(arquivoPerfil);
        }else{
            new GuiMenu(arquivoPerfil);
        }



    }

}
