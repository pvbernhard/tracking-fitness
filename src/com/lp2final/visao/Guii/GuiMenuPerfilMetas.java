package com.lp2final.visao.Guii;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMenuPerfilMetas extends JFrame {

    VoltaJanela volta = new VoltaJanela();

    EditarCall editarCall = new EditarCall();
    EditarTemp editarTemp = new EditarTemp();

    Dimension tamTela = getToolkit().getScreenSize();
    int largT = tamTela.width;
    int altT = tamTela.height;

    int larg = (int) (largT*0.3);
    int alt = (int) (altT*0.5);

    public GuiMenuPerfilMetas() {
        super("Menu");


        setSize(larg, alt);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void menuMetas(){

        setLayout(new BorderLayout());//criar um borda em torno da janela

        //titulo
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());//criar um layout flow
        JLabel titulo = new JLabel("Editar Perfil");

        Font f = new Font("Verdana", Font.PLAIN,16);//Criar uma fonte -> nome da fonte/o formato regular/tamanho
        titulo.setFont(f);//adiciona a fonte no titulo

        panelTitulo.add(titulo);//adiciona informaçoes no painel
        //titulo

        //Painel onde o usario botara as informaçoes
        JPanel panelBoteoes = new JPanel();
        panelBoteoes.setLayout(null);

        //botoens
        JButton botaoCal = new JButton("Definir Metas De Calorias");
        botaoCal.addActionListener(editarCall);
        JButton botaoTemp = new JButton("Definir Metas De tempo");
        botaoTemp.addActionListener(editarTemp);

        //tamanho e local dos botoes
        botaoCal.setBounds( (larg/2) - 200/2,10+70*0,200,60);
        botaoTemp.setBounds((larg/2) - 200/2,10+70*1,200,60);


        panelBoteoes.add(botaoCal);
        panelBoteoes.add(botaoTemp);


        //Painel onde o usario botara as informaçoes
        JPanel panelVolta = new JPanel();
        panelVolta.setLayout(new FlowLayout());

        JButton botaoVolta = new JButton("Volta");
        botaoVolta.addActionListener(volta);

        panelVolta.add(botaoVolta);

        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)
        add(panelTitulo ,BorderLayout.NORTH );
        add(panelBoteoes , BorderLayout.CENTER);
        add(panelVolta , BorderLayout.SOUTH);

        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)

    }

    private class VoltaJanela implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    private class EditarCall implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Modificador m = new Modificador();
            m.alterarCal();

        }
    }

    private class EditarTemp implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Modificador m = new Modificador();
            m.alterarTemp();

        }
    }

}
