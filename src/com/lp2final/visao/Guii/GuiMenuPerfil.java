package com.lp2final.visao.Guii;

import com.lp2final.controle.PerfilControle;
import com.lp2final.modelo.Perfil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuiMenuPerfil extends JFrame {

    VoltaJanela volta = new VoltaJanela();
    AbrirEditarPerfil abrirEditarPerfil = new AbrirEditarPerfil();
    AbrirEditarMetas abrirEditarMetas = new AbrirEditarMetas();
    MostrarPerfil mostrarPerfil = new MostrarPerfil();
    MostrarPesos mostrarPesos = new MostrarPesos();

    Dimension tamTela = getToolkit().getScreenSize();
    int largT = tamTela.width;
    int altT = tamTela.height;

    int larg = (int) (largT*0.3);
    int alt = (int) (altT*0.5);

    String arquivoPerfil;

    public GuiMenuPerfil(String arquivoPerfil){
        super("Menu");
        this.arquivoPerfil = arquivoPerfil;


        setSize(larg, alt);
        setLocationRelativeTo(null);
        setVisible(true);
    }



    public void perfilMenu(){

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
        JButton botaoPerfil = new JButton("Mostra Perfil");
        botaoPerfil.addActionListener(mostrarPerfil);
        JButton botaoEditar = new JButton("Editar Perfil");
        botaoEditar.addActionListener(abrirEditarPerfil);
        JButton botaoDefinir = new JButton("Definir metas de (cal/temp)");
        botaoDefinir.addActionListener(abrirEditarMetas);
        JButton botaoMostrar = new JButton("Mostrar todos os pesos");
        botaoMostrar.addActionListener(mostrarPesos);

        //tamanho e local dos botoes
        botaoPerfil.setBounds( (larg/2) - 150/2,10+70*0,150,60);
        botaoEditar.setBounds((larg/2) - 150/2,10+70*1,150,60);
        botaoDefinir.setBounds((larg/2) - 200/2,10+70*2,200,60);
        botaoMostrar.setBounds((larg/2) - 200/2,10+70*3,200,60);

        panelBoteoes.add(botaoPerfil);
        panelBoteoes.add(botaoEditar);
        panelBoteoes.add(botaoDefinir);
        panelBoteoes.add(botaoMostrar);


        //Painel onde o usario botara as informaçoes
        JPanel panelVolta = new JPanel();
        panelVolta.setLayout(new FlowLayout());

        JButton botaoVolta = new JButton("Volta");
        botaoVolta.addActionListener(volta);

        panelVolta.add(botaoVolta);

        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)
        add(panelTitulo, BorderLayout.NORTH );
        add(panelBoteoes, BorderLayout.CENTER);
        add(panelVolta, BorderLayout.SOUTH);

        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)

    }


    private class VoltaJanela implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }


    private class AbrirEditarPerfil implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            GuiMenuPerfilEditar g = new GuiMenuPerfilEditar(arquivoPerfil);
            g.menuEditar();
        }
    }

    private class AbrirEditarMetas implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            GuiMenuPerfilMetas g = new GuiMenuPerfilMetas(arquivoPerfil);
            g.menuMetas();
        }
    }
    private class MostrarPerfil implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            PerfilControle p = new PerfilControle("Perfil");
            Perfil perfil = p.getPerfil();
            String nome = perfil.getNome();
            String idade =  perfil.getIdade()+"";
            String altura = perfil.getAltura()+"";
            String peso = perfil.getPeso()+"";
            String imc = perfil.imcClassificacao();
            String metaCal = perfil.getMetaCal();
            String metaTemp = perfil.getMetaTemp();

            JOptionPane.showMessageDialog(null,"Nome: "+nome+"\nIdade: "+idade+"\nAltura: "+altura+"" +
                    "\nPeso: "+peso+"\nVoce está com: "+imc +
                    "\nMeta De Calorias Diarias: "+metaCal+"\nMeta De Tempo Diario: "+metaTemp,"Perfil",JOptionPane.PLAIN_MESSAGE);
        }
    }

    private class MostrarPesos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            PerfilControle p = new PerfilControle(arquivoPerfil);
            ArrayList<String> pesos = p.getPesototal();
            ArrayList<String> datas = p.getDataPesoTotal();
            String info ="";

            for(int i = 0;i<pesos.size();i++){

                info ="Data: " +datas.get(i) + "  Peso:"+pesos.get(i)+"\n";
            }

            JOptionPane.showMessageDialog(null,info,"Perfil",JOptionPane.PLAIN_MESSAGE);

        }
    }


}
