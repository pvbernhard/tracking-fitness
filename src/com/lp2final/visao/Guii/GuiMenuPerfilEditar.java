package com.lp2final.visao.Guii;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMenuPerfilEditar extends JFrame {

    VoltaJanela volta = new VoltaJanela();
    EditarNome editarNome = new EditarNome();
    EditarIdade editarIdade = new EditarIdade();
    EditarAltura editarAltura = new EditarAltura();
    EditarPeso editarPeso = new EditarPeso();

    Dimension tamTela = getToolkit().getScreenSize();
    int largT = tamTela.width;
    int altT = tamTela.height;

    int larg = (int) (largT*0.3);
    int alt = (int) (altT*0.5);

    String nomeArquivo;

    public GuiMenuPerfilEditar(String nomeArquivo){
        super("Editar");
        this.nomeArquivo = nomeArquivo;

        setSize(larg, alt);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void menuEditar(){

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
        JButton botaoNome = new JButton("Editar Nome");
        botaoNome.addActionListener(editarNome);
        JButton botaoIdade = new JButton("Editar Idade");
        botaoIdade.addActionListener(editarIdade);
        JButton botaoAltura = new JButton("Editar Altura");
        botaoAltura.addActionListener(editarAltura);
        JButton botaoPeso = new JButton("Editar Peso");
        botaoPeso.addActionListener(editarPeso);

        //tamanho e local dos botoes
        botaoNome.setBounds( (larg/2) - 150/2,10+70*0,150,60);
        botaoIdade.setBounds((larg/2) - 150/2,10+70*1,150,60);
        botaoAltura.setBounds((larg/2) - 150/2,10+70*2,150,60);
        botaoPeso.setBounds((larg/2) - 150/2,10+70*3,150,60);

        panelBoteoes.add(botaoNome);
        panelBoteoes.add(botaoIdade);
        panelBoteoes.add(botaoAltura);
        panelBoteoes.add(botaoPeso);


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

    private class EditarNome implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Modificador m = new Modificador(nomeArquivo);
            m.alterarNome();

        }
    }

    private class EditarIdade implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Modificador m = new Modificador(nomeArquivo);
            m.alterarIdade();
        }
    }

    private class EditarAltura implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Modificador m = new Modificador(nomeArquivo);
            m.alteraAltura();
        }
    }

    private class EditarPeso implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Modificador m = new Modificador(nomeArquivo);
            m.alteraPeso();
        }
    }

}
