package com.lp2final.visao.Guii;

import com.lp2final.controle.AtividadesControle;
import com.lp2final.controle.PerfilControle;
import com.lp2final.modelo.AtividadeFeita;
import com.lp2final.modelo.AtividadeFisica;
import com.lp2final.modelo.Perfil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.Instant;

public class Modificador extends JFrame{

    private JTextField nomeF;
    private JTextField idadeF;
    private JTextField alturaF;
    private JTextField pesoF;

    private JTextField callF;
    private JTextField tempF;


    private final AlterarNomeAction alterarNomeAction = new AlterarNomeAction();
    private final AlterarIdadeAction alterarIdadeAction = new AlterarIdadeAction();
    private final AlterarAlturaAction alterarAlturaAction = new AlterarAlturaAction();
    private final AlterarPesoAction alterarPesoAction = new AlterarPesoAction();

    private final AlterarCallAction alterarCallAction = new AlterarCallAction();
    private final AlterarTempAction alterarTempAction = new AlterarTempAction();

    Dimension tamTela = getToolkit().getScreenSize();
    int largT = tamTela.width;
    int altT = tamTela.height;

    int larg = (int) (largT*0.4);
    int alt = (int) (altT*0.2);

    String nomeArquivo = "";

    PerfilControle p;
    Perfil perfil;

    AtividadeFeita atividadeFeita;

    public Modificador(String nomeArquivo){
        super("Alterar");
        this.nomeArquivo = nomeArquivo;

        p = new PerfilControle(this.nomeArquivo);
        perfil = p.getPerfil();

        setSize(larg, alt);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public Modificador(AtividadeFeita atividadeFeita, String nomeArquivo) {
        super("Atividade");
        this.atividadeFeita = atividadeFeita;
        this.nomeArquivo = nomeArquivo;

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

    public void alterarAtividade(){
        setLayout(new BorderLayout());//criar um borda em torno da janela

        //titulo
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        JLabel titulo = new JLabel("Atividade Feita");

        Font f = new Font("Verdana", Font.PLAIN,16);
        titulo.setFont(f);

        panelTitulo.add(titulo);
        //titulo

        //Painel onde o usario botara as informaçoes
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Descrição");
        JTextField field1 = new JTextField(45);

        JLabel label2 = new JLabel("Duração (minutos)");
        JTextField field2 = new JTextField(40);

        //adicona as informaçoes no painel
        panel.add(label1);
        panel.add(field1);
        panel.add(label2);
        panel.add(field2);


        //Painel onde o usario botara as informaçoes

        //Painel onde ficaria o botam de confirmaçao
        JPanel panelBoteoes = new JPanel();
        panelBoteoes.setLayout(new FlowLayout());

        JButton botaoConfirmar = new JButton("Confirmar");//criar botao e seu nome
        botaoConfirmar.addActionListener(e -> {
            atividadeFeita.setDescricao(field1.getText());
            atividadeFeita.setDuracao(Double.parseDouble(field2.getText()));
            AtividadesControle atividadesControle = new AtividadesControle(nomeArquivo);
            try {
                atividadesControle.escreverAtividadeFeita(atividadeFeita);
            } catch (IOException | ClassNotFoundException ioException) {
                ioException.printStackTrace();
            }
            dispose();
        });

        panelBoteoes.add(botaoConfirmar);//adicona o botal no painel
        //Painel onde ficaria o botam de confirmaçao

        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)
        add(panelTitulo ,BorderLayout.NORTH );
        add(panel , BorderLayout.CENTER);
        add(panelBoteoes , BorderLayout.SOUTH);
        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)

    }

    public void adicionarAtividade(){
        setLayout(new BorderLayout());//criar um borda em torno da janela

        //titulo
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        JLabel titulo = new JLabel("Nova Atividade");

        Font f = new Font("Verdana", Font.PLAIN,16);
        titulo.setFont(f);

        panelTitulo.add(titulo);
        //titulo

        //Painel onde o usario botara as informaçoes
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label0 = new JLabel("Atividade");
        JTextField field0 = new JTextField(45);

        JLabel label1 = new JLabel("Descrição");
        JTextField field1 = new JTextField(45);

        JLabel label2 = new JLabel("Duração (minutos)");
        JTextField field2 = new JTextField(40);

        //adicona as informaçoes no painel
        panel.add(label0);
        panel.add(field0);
        panel.add(label1);
        panel.add(field1);
        panel.add(label2);
        panel.add(field2);


        //Painel onde o usario botara as informaçoes

        //Painel onde ficaria o botam de confirmaçao
        JPanel panelBoteoes = new JPanel();
        panelBoteoes.setLayout(new FlowLayout());

        JButton botaoConfirmar = new JButton("Confirmar");//criar botao e seu nome
        botaoConfirmar.addActionListener(e -> {

            try {
                new AtividadesControle(nomeArquivo).escreverAtividade(new AtividadeFisica(field0.getText(), null));
                new AtividadesControle(nomeArquivo).escreverAtividadeFeita(new AtividadeFeita(new PerfilControle(nomeArquivo).getPerfil(), Instant.now(), new AtividadeFisica(field0.getText(), null), field1.getText(), Double.parseDouble(field2.getText())));
            } catch (IOException | ClassNotFoundException ioException) {
                ioException.printStackTrace();
            }
            dispose();
        });

        panelBoteoes.add(botaoConfirmar);//adicona o botal no painel
        //Painel onde ficaria o botam de confirmaçao

        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)
        add(panelTitulo ,BorderLayout.NORTH );
        add(panel , BorderLayout.CENTER);
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
