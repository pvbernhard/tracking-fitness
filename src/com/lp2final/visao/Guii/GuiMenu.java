package com.lp2final.visao.Guii;

import com.lp2final.controle.GerarPdf;
import com.lp2final.modelo.Relatorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMenu extends JFrame {


    //EVENTOS MENU
    PdfCriar pdfCriar = new PdfCriar();
    AbrirPerfil abrirPerfil = new AbrirPerfil();
    Sobre sobre =  new Sobre();
    //EVENTOS MENU

    //MENU
    Dimension tamTela = getToolkit().getScreenSize();
    int largT = tamTela.width;
    int altT = tamTela.height;

    int larg = (int) (largT*0.3);
    int alt = (int) (altT*0.5);

    String arquivoPerfil;

    public GuiMenu(String arquivoPerfil){
        super("Menu");
        this.arquivoPerfil = arquivoPerfil;

        criarMenuSUperiorMenu();
        criarMenu(arquivoPerfil);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(larg, alt);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void criarMenuSUperiorMenu(){

        JMenu menuSuperior = new JMenu("Mais");//barra superior

        JMenuItem menuItem = new JMenuItem("Sobre");//informaçoes que iriam aparece quando aberta o menu
        menuItem.addActionListener(sobre);

        menuSuperior.add(menuItem);//adiciona o sobre dentro do mais

        JMenuBar barra = new JMenuBar();//mostra onde ficaria o menu criado a cima
        setJMenuBar(barra);
        barra.add(menuSuperior);
    }

    public void criarMenu(String arquivoPerfil){

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
        JButton botaoExercicios = new JButton("Atividade Física");
        botaoExercicios.addActionListener(e -> {
            GuiMenuAtividades g = new GuiMenuAtividades(arquivoPerfil);
            g.menu();
        });
        JButton botaoRelatorio = new JButton("Relatorio");
        botaoRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Relatorio relatorio = new Relatorio(arquivoPerfil);
                JOptionPane.showMessageDialog(null, relatorio,"Relatório", JOptionPane.PLAIN_MESSAGE);
            }
        });
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
            GuiMenuPerfil g = new GuiMenuPerfil(arquivoPerfil);
            g.perfilMenu();
        }
    }

    private class PdfCriar implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            GerarPdf p = new GerarPdf();
            p.criarPdf(arquivoPerfil);
            JOptionPane.showMessageDialog(null,"PDF Criado","Confirmacao",JOptionPane.PLAIN_MESSAGE);
        }
    }

    private class Sobre implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,"Criado por\nMario Pinto Freitas Filho" +
                    "\nPedro Vinnícius Bernhard","Sobre",JOptionPane.PLAIN_MESSAGE);
        }
    }


}
