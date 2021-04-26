package com.lp2final.visao.Guii;

import com.lp2final.controle.PerfilControle;
import com.lp2final.modelo.Perfil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMenuAtividades extends JFrame {

    Dimension tamTela = getToolkit().getScreenSize();
    int largT = tamTela.width;
    int altT = tamTela.height;

    int larg = (int) (largT*0.3);
    int alt = (int) (altT*0.5);

    String arquivoPerfil;

    public GuiMenuAtividades(String arquivoPerfil){
        super("Menu");

        this.arquivoPerfil = arquivoPerfil;
        setSize(larg, alt);
        setLocationRelativeTo(null);
        setVisible(true);
    }



    public void atividadesMenu(){

        setLayout(new BorderLayout());//criar um borda em torno da janela

        //titulo
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());//criar um layout flow
        JLabel titulo = new JLabel("Perfil");

        Font f = new Font("Verdana", Font.PLAIN,16);//Criar uma fonte -> nome da fonte/o formato regular/tamanho
        titulo.setFont(f);//adiciona a fonte no titulo

        panelTitulo.add(titulo);//adiciona informaçoes no painel
        //titulo

        //Painel onde o usario botara as informaçoes
        JPanel panelBoteoes = new JPanel();
        panelBoteoes.setLayout(null);

        //botoens
        JButton botaoPerfil = new JButton("Adicionar atividade física");
        botaoPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JButton botaoEditar = new JButton("Listar atividades feitas");
        botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //tamanho e local dos botoes
        botaoPerfil.setBounds( (larg/2) - 150/2,10+70*0,150,60);
        botaoEditar.setBounds((larg/2) - 150/2,10+70*1,150,60);

        panelBoteoes.add(botaoPerfil);
        panelBoteoes.add(botaoEditar);

        //Painel onde o usario botara as informaçoes
        JPanel panelVolta = new JPanel();
        panelVolta.setLayout(new FlowLayout());

        JButton botaoVolta = new JButton("Volta");
        botaoVolta.addActionListener(e -> dispose());

        panelVolta.add(botaoVolta);

        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)
        add(panelTitulo, BorderLayout.NORTH );
        add(panelBoteoes, BorderLayout.CENTER);
        add(panelVolta, BorderLayout.SOUTH);

        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)

    }

}
