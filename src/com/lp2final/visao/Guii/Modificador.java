package com.lp2final.visao.Guii;

import com.lp2final.controle.PerfilControle;
import com.lp2final.modelo.Perfil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Modificador extends JFrame{

    private PerfilControle p = new PerfilControle("Perfil");
    private Perfil perfil = p.getPerfil();

    private JTextField nomeF;
    private JTextField idadeF;
    private JTextField alturaF;
    private JTextField pesoF;

    private JTextField callF;
    private JTextField tempF;


    private AlterarNomeAction alterarNomeAction = new AlterarNomeAction();
    private AlterarIdadeAction alterarIdadeAction = new AlterarIdadeAction();
    private AlterarAlturaAction alterarAlturaAction = new AlterarAlturaAction();
    private AlterarPesoAction alterarPesoAction = new AlterarPesoAction();

    private AlterarCallAction alterarCallAction = new AlterarCallAction();
    private AlterarTempAction alterarTempAction = new AlterarTempAction();


    //MENU
    Dimension tamTela = getToolkit().getScreenSize();
    int largT = tamTela.width;
    int altT = tamTela.height;

    int larg = (int) (largT*0.4);
    int alt = (int) (altT*0.2);

    public Modificador(){
        super("Alterar");


        setSize(larg, alt);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public void alterarNome(){
        setLayout(new BorderLayout());//criar um borda em torno da janela

        //titulo
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        JLabel titulo = new JLabel("Alterar Nome");

        Font f = new Font("Verdana", Font.PLAIN,16);
        titulo.setFont(f);

        panelTitulo.add(titulo);
        //titulo

        //Painel onde o usario botara as informaçoes
        JPanel panelCadastro = new JPanel();
        panelCadastro.setLayout(new FlowLayout());

        JLabel nomeJ = new JLabel("Nome");
        nomeF = new JTextField(40);

        //adicona as informaçoes no painel
        panelCadastro.add(nomeJ);
        panelCadastro.add(nomeF);


        //Painel onde o usario botara as informaçoes

        //Painel onde ficaria o botam de confirmaçao
        JPanel panelBoteoes = new JPanel();
        panelBoteoes.setLayout(new FlowLayout());

        JButton botaoConfirmar = new JButton("Confirmar");//criar botao e seu nome
        botaoConfirmar.addActionListener(alterarNomeAction);

        panelBoteoes.add(botaoConfirmar);//adicona o botal no painel
        //Painel onde ficaria o botam de confirmaçao

        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)
        add(panelTitulo ,BorderLayout.NORTH );
        add(panelCadastro , BorderLayout.CENTER);
        add(panelBoteoes , BorderLayout.SOUTH);
        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)

    }

    public void alterarIdade(){
        setLayout(new BorderLayout());//criar um borda em torno da janela

        //titulo
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        JLabel titulo = new JLabel("Alterar Idade");

        Font f = new Font("Verdana", Font.PLAIN,16);
        titulo.setFont(f);

        panelTitulo.add(titulo);
        //titulo

        //Painel onde o usario botara as informaçoes
        JPanel panelCadastro = new JPanel();
        panelCadastro.setLayout(new FlowLayout());

        JLabel idadeJ = new JLabel("Idade");
        idadeF = new JTextField(40);

        //adicona as informaçoes no painel
        panelCadastro.add(idadeJ);
        panelCadastro.add(idadeF);


        //Painel onde o usario botara as informaçoes

        //Painel onde ficaria o botam de confirmaçao
        JPanel panelBoteoes = new JPanel();
        panelBoteoes.setLayout(new FlowLayout());

        JButton botaoConfirmar = new JButton("Confirmar");//criar botao e seu nome
        botaoConfirmar.addActionListener(alterarIdadeAction);

        panelBoteoes.add(botaoConfirmar);//adicona o botal no painel
        //Painel onde ficaria o botam de confirmaçao

        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)
        add(panelTitulo ,BorderLayout.NORTH );
        add(panelCadastro , BorderLayout.CENTER);
        add(panelBoteoes , BorderLayout.SOUTH);
        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)

    }

    public void alteraAltura(){
        setLayout(new BorderLayout());//criar um borda em torno da janela

        //titulo
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        JLabel titulo = new JLabel("Alterar Altura");

        Font f = new Font("Verdana", Font.PLAIN,16);
        titulo.setFont(f);

        panelTitulo.add(titulo);
        //titulo

        //Painel onde o usario botara as informaçoes
        JPanel panelCadastro = new JPanel();
        panelCadastro.setLayout(new FlowLayout());

        JLabel alturaJ = new JLabel("Altura");
        alturaF = new JTextField(40);

        //adicona as informaçoes no painel
        panelCadastro.add(alturaJ);
        panelCadastro.add(alturaF);


        //Painel onde o usario botara as informaçoes

        //Painel onde ficaria o botam de confirmaçao
        JPanel panelBoteoes = new JPanel();
        panelBoteoes.setLayout(new FlowLayout());

        JButton botaoConfirmar = new JButton("Confirmar");//criar botao e seu nome
        botaoConfirmar.addActionListener(alterarAlturaAction);

        panelBoteoes.add(botaoConfirmar);//adicona o botal no painel
        //Painel onde ficaria o botam de confirmaçao

        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)
        add(panelTitulo ,BorderLayout.NORTH );
        add(panelCadastro , BorderLayout.CENTER);
        add(panelBoteoes , BorderLayout.SOUTH);
        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)

    }

    public void alteraPeso(){
        setLayout(new BorderLayout());//criar um borda em torno da janela

        //titulo
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        JLabel titulo = new JLabel("Alterar Peso");

        Font f = new Font("Verdana", Font.PLAIN,16);
        titulo.setFont(f);

        panelTitulo.add(titulo);
        //titulo

        //Painel onde o usario botara as informaçoes
        JPanel panelCadastro = new JPanel();
        panelCadastro.setLayout(new FlowLayout());

        JLabel pesoJ = new JLabel("Peso");
        pesoF = new JTextField(40);

        //adicona as informaçoes no painel
        panelCadastro.add(pesoJ);
        panelCadastro.add(pesoF);


        //Painel onde o usario botara as informaçoes

        //Painel onde ficaria o botam de confirmaçao
        JPanel panelBoteoes = new JPanel();
        panelBoteoes.setLayout(new FlowLayout());

        JButton botaoConfirmar = new JButton("Confirmar");//criar botao e seu nome
        botaoConfirmar.addActionListener(alterarPesoAction);

        panelBoteoes.add(botaoConfirmar);//adicona o botal no painel
        //Painel onde ficaria o botam de confirmaçao

        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)
        add(panelTitulo ,BorderLayout.NORTH );
        add(panelCadastro , BorderLayout.CENTER);
        add(panelBoteoes , BorderLayout.SOUTH);
        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)

    }


    public void alterarCal(){

        setLayout(new BorderLayout());//criar um borda em torno da janela

        //titulo
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        JLabel titulo = new JLabel("Meta");

        Font f = new Font("Verdana", Font.PLAIN,16);
        titulo.setFont(f);

        panelTitulo.add(titulo);
        //titulo

        //Painel onde o usario botara as informaçoes
        JPanel panelCadastro = new JPanel();
        panelCadastro.setLayout(new FlowLayout());

        JLabel callJ = new JLabel("Calorias");
        callF = new JTextField(40);

        //adicona as informaçoes no painel
        panelCadastro.add(callJ);
        panelCadastro.add(callF);


        //Painel onde o usario botara as informaçoes

        //Painel onde ficaria o botam de confirmaçao
        JPanel panelBoteoes = new JPanel();
        panelBoteoes.setLayout(new FlowLayout());

        JButton botaoConfirmar = new JButton("Confirmar");//criar botao e seu nome
        botaoConfirmar.addActionListener(alterarCallAction);

        panelBoteoes.add(botaoConfirmar);//adicona o botal no painel
        //Painel onde ficaria o botam de confirmaçao

        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)
        add(panelTitulo ,BorderLayout.NORTH );
        add(panelCadastro , BorderLayout.CENTER);
        add(panelBoteoes , BorderLayout.SOUTH);
        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)
    }

    public void alterarTemp(){

        setLayout(new BorderLayout());//criar um borda em torno da janela

        //titulo
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        JLabel titulo = new JLabel("Meta");

        Font f = new Font("Verdana", Font.PLAIN,16);
        titulo.setFont(f);

        panelTitulo.add(titulo);
        //titulo

        //Painel onde o usario botara as informaçoes
        JPanel panelCadastro = new JPanel();
        panelCadastro.setLayout(new FlowLayout());

        JLabel tempJ = new JLabel("Tempo");
        tempF = new JTextField(40);

        //adicona as informaçoes no painel
        panelCadastro.add(tempJ);
        panelCadastro.add(tempF);


        //Painel onde o usario botara as informaçoes

        //Painel onde ficaria o botam de confirmaçao
        JPanel panelBoteoes = new JPanel();
        panelBoteoes.setLayout(new FlowLayout());

        JButton botaoConfirmar = new JButton("Confirmar");//criar botao e seu nome
        botaoConfirmar.addActionListener(alterarTempAction);

        panelBoteoes.add(botaoConfirmar);//adicona o botal no painel
        //Painel onde ficaria o botam de confirmaçao

        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)
        add(panelTitulo ,BorderLayout.NORTH );
        add(panelCadastro , BorderLayout.CENTER);
        add(panelBoteoes , BorderLayout.SOUTH);
        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)
    }


    private class AlterarNomeAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = nomeF.getText();
            p.editarPerfil("Nome", nome);
            perfil.setNome(nome);
            dispose();
        }
    }

    private class AlterarIdadeAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = idadeF.getText();
            p.editarPerfil("Nome", nome);
            perfil.setIdade( Integer.valueOf(nome).intValue());
            dispose();
        }
    }

    private class AlterarAlturaAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = alturaF.getText();
            p.editarPerfil("Nome", nome);
            perfil.setAltura( Double.valueOf(nome).doubleValue());
            dispose();
        }
    }

    private class AlterarPesoAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = pesoF.getText();
            p.editarPerfil("Nome", nome);
            perfil.setPeso( Double.valueOf(nome).doubleValue());
            dispose();
        }
    }

    private class AlterarCallAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = callF.getText();
            p.editarPerfil("MetaCal",nome);
            perfil.setMetaCal(nome);
            dispose();
        }
    }

    private class AlterarTempAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = tempF.getText();
            p.editarPerfil("MetaTemp",nome);
            perfil.setMetaTemp(nome);
            dispose();
        }
    }

}
