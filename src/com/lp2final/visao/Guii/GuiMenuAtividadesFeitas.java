package com.lp2final.visao.Guii;

import com.lp2final.controle.AtividadesControle;
import com.lp2final.controle.PerfilControle;
import com.lp2final.modelo.AtividadeFeita;
import com.lp2final.modelo.AtividadeFisica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;

public class GuiMenuAtividadesFeitas extends JFrame {

    Dimension tamTela = getToolkit().getScreenSize();
    int largT = tamTela.width;
    int altT = tamTela.height;

    int larg = (int) (largT*0.4);
    int alt = (int) (altT*0.5);

    String arquivoPerfil;

    public GuiMenuAtividadesFeitas(String arquivoPerfil){
        super("Menu");

        this.arquivoPerfil = arquivoPerfil;
        setSize(larg, alt);
        setLocationRelativeTo(null);
        setVisible(true);
    }



    public void menu(){

        setLayout(new BorderLayout()); //criar um borda em torno da janela

        //titulo
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());//criar um layout flow
        JLabel titulo = new JLabel("Atividades");

        Font f = new Font("Verdana", Font.PLAIN,16);//Criar uma fonte -> nome da fonte/o formato regular/tamanho
        titulo.setFont(f);//adiciona a fonte no titulo

        panelTitulo.add(titulo);//adiciona informaçoes no painel
        //titulo

        //Painel onde o usario botara as informaçoes
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(null);

        AtividadesControle atividadesControle = new AtividadesControle(arquivoPerfil);
        ArrayList<AtividadeFeita> atividades = null;
        try {
            atividades = atividadesControle.lerAtividadesFeitas();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> atividadesNomes = new ArrayList<>();
        for (AtividadeFeita atividade : atividades) {
            atividadesNomes.add(atividade.toString());
        }

        JComboBox atividadesLista = new JComboBox(atividadesNomes.toArray(value -> new String[0]));



        //tamanho e local dos botoes
        atividadesLista.setBounds((larg/2) - 550/2,10+70*0,550,60);

        panelBotoes.add(atividadesLista);

        //Painel onde o usario botara as informaçoes
        JPanel panelVolta = new JPanel();
        panelVolta.setLayout(new FlowLayout());

        JButton botaoVolta = new JButton("Volta");
        botaoVolta.addActionListener(e -> dispose());

        panelVolta.add(botaoVolta);

        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)
        add(panelTitulo, BorderLayout.NORTH );
        add(panelBotoes, BorderLayout.CENTER);
        add(panelVolta, BorderLayout.SOUTH);

        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)

    }

}
