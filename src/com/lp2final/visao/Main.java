package com.lp2final.visao;

import com.lp2final.controle.GerarPdf;
import com.lp2final.controle.Menu;
import com.lp2final.controle.PerfilControle;
import com.lp2final.modelo.Perfil;
import com.lp2final.visao.Guii.Gui;
import com.lp2final.visao.Guii.GuiMenu;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String arquivoPerfil = "Perfil";
        PerfilControle p = new PerfilControle(arquivoPerfil);
        //Gui
        if(!p.perfilExist()) {
            Gui face = new Gui(arquivoPerfil);
        }else{
            GuiMenu face = new GuiMenu(arquivoPerfil);
        }



    }

}
