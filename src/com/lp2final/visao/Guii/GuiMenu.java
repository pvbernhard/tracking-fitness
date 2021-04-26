package com.lp2final.visao.Guii;

import com.lp2final.controle.GerarPdf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMenu extends JFrame {


    //EVENTOS MENU
    PdfCriar pdfCriar = new PdfCriar();
    AbrirPerfil abrirPerfil = new AbrirPerfil();
    //EVENTOS MENU

    //MENU
    Dimension tamTela = getToolkit().getScreenSize();
    int largT = tamTela.width;
    int altT = tamTela.height;

    int larg = (int) (largT*0.3);
    int alt = (int) (altT*0.5);

    public GuiMenu(){
        super("Menu");
        criarMenuSUperiorMenu();
        criarMenu();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(larg, alt);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void criarMenuSUperiorMenu(){

        JMenu menuSuperior = new JMenu("Mais");//barra superior

        JMenuItem menuItem = new JMenuItem("Sobre");//informaçoes que iriam aparece quando aberta o menu

        menuSuperior.add(menuItem);//adiciona o sobre dentro do mais


        JMenuItem menuDoidao = new JMenuItem("Doidao");
        menuSuperior.add(menuItem);

        JMenuBar barra = new JMenuBar();//mostra onde ficaria o menu criado a cima
        setJMenuBar(barra);
        barra.add(menuSuperior);
    }

    public void criarMenu(){

        setLayout(new BorderLayout());//criar um borda em torno da janela

        //titulo
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());//criar um layout flow
        JLabel titulo = new JLabel("Menu Principal");

        Font f = new Font("Verdana", Font.PLAIN,16);//Criar uma fonte -> nome da fonte/o formato regular/tamanho
        titulo.setFont(f);//adiciona a fonte no titulo

        panelTitulo.add(titulo);//adiciona informaçoes no painel
        //titulo

        //Painel onde o usario botara as informaçoes
        JPanel panelBoteoes = new JPanel();
        panelBoteoes.setLayout(null);

        //botoens
        JButton botaoPerfil = new JButton("Perfil");
        botaoPerfil.addActionListener(abrirPerfil);
        JButton botaoExercicios = new JButton("Lista De Exercicios");
        JButton botaoRelatorio = new JButton("Relatorio");
        JButton botaoPdf = new JButton("Gerar PDF");
        botaoPdf.addActionListener(pdfCriar);

        //tamanho e local dos botoes
        botaoPerfil.setBounds( (larg/2) - 150/2,10+70*0,150,60);
        botaoExercicios.setBounds((larg/2) - 150/2,10+70*1,150,60);
        botaoRelatorio.setBounds((larg/2) - 150/2,10+70*2,150,60);
        botaoPdf.setBounds((larg/2) - 150/2,10+70*3,150,60);

        panelBoteoes.add(botaoPerfil);
        panelBoteoes.add(botaoExercicios);
        panelBoteoes.add(botaoRelatorio);
        panelBoteoes.add(botaoPdf);


        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)
        add(panelTitulo ,BorderLayout.NORTH );
        add(panelBoteoes , BorderLayout.CENTER);

        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)

    }


    private class AbrirPerfil implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            GuiMenuPerfil g = new GuiMenuPerfil();
            g.perfilMenu();
        }
    }

    private class PdfCriar implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            GerarPdf p = new GerarPdf();
            p.criarPdf("Perfil");
            JOptionPane.showMessageDialog(null,"PDF Criado","Confirmacao",JOptionPane.PLAIN_MESSAGE);
        }
    }


}
