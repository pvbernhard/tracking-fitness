package com.lp2final.visao;

import com.lp2final.controle.PerfilControle;
import com.lp2final.modelo.Perfil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame {
    //declaro jtextField como objeto para eu poder interagir com eles nos eventos
    private JTextField nomeF;
    private JTextField idadeF;
    private JTextField alturaF;
    private JTextField pesoF;


    //eventos
    Salvar salvar = new Salvar();
    Fechar fechar = new Fechar();
    //eventos

    public Gui(){
        super("Criar Perfil");//criar nome da janela
        criarMenuSuperiorDeCriarPerfil();
        criarFormulario();
    }
    //criaçao do perfil
    public void criarMenuSuperiorDeCriarPerfil(){
        //eventos
        NovoAction a = new NovoAction();
        //eventos

        JMenu menuSuperior = new JMenu("Mais");//barra superior

        JMenuItem menuItem = new JMenuItem("Apagar Informacoes");//informaçoes que iriam aparece quando aberta o menu
        menuItem.addActionListener(a);//execulta a ação que esta em NovoAction

        menuSuperior.add(menuItem);//adiciona o sobre dentro do mais


        JMenuItem menuDoidao = new JMenuItem("Doidao");
        menuSuperior.add(menuItem);

        JMenuBar barra = new JMenuBar();//mostra onde ficaria o menu criado a cima
        setJMenuBar(barra);
        barra.add(menuSuperior);
    }

    public void criarFormulario(){
        setLayout(new BorderLayout());//criar um borda em torno da janela

        //titulo
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());//criar um layout flow
        JLabel titulo = new JLabel("Criar Perfil");

        Font f = new Font("Verdana", Font.PLAIN,16);//Criar uma fonte -> nome da fonte/o formato regular/tamanho
        titulo.setFont(f);//adiciona a fonte no titulo

        panelTitulo.add(titulo);//adiciona informaçoes no painel
        //titulo

        //Painel onde o usario botara as informaçoes
        JPanel panelCadastro = new JPanel();
        panelCadastro.setLayout(new FlowLayout());

        JLabel nomeJ = new JLabel("Nome");
        nomeF = new JTextField(40);//onde iria bota as inforçoes do Jlabel e bota o tamanho no contrutor

        JLabel idadeJ = new JLabel("Idade");
        idadeF = new JTextField(40);//onde iria bota as inforçoes do Jlabel e bota o tamanho no contrutor

        JLabel alturaJ = new JLabel("Altura");
        alturaF = new JTextField(40);//onde iria bota as inforçoes do Jlabel e bota o tamanho no contrutor

        JLabel pesoJ = new JLabel("Peso");
        pesoF = new JTextField(40);//onde iria bota as inforçoes do Jlabel e bota o tamanho no contrutor
        //adicona as informaçoes no painel
        panelCadastro.add(nomeJ);
        panelCadastro.add(nomeF);

        panelCadastro.add(idadeJ);
        panelCadastro.add(idadeF);

        panelCadastro.add(alturaJ);
        panelCadastro.add(alturaF);

        panelCadastro.add(pesoJ);
        panelCadastro.add(pesoF);
        //Painel onde o usario botara as informaçoes

        //Painel onde ficaria o botam de confirmaçao
        JPanel panelBoteoes = new JPanel();
        panelBoteoes.setLayout(new FlowLayout());

        JButton botaoConfirmar = new JButton("Confirmar");//criar botao e seu nome
        botaoConfirmar.addActionListener(salvar);

        panelBoteoes.add(botaoConfirmar);//adicona o botal no painel
        //Painel onde ficaria o botam de confirmaçao

        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)
        add(panelTitulo ,BorderLayout.NORTH );
        add(panelCadastro , BorderLayout.CENTER);
        add(panelBoteoes , BorderLayout.SOUTH);
        //adiciona cade painel em seua posiçoes podem ser (NORTH, SOUTH,WEST,EAST,CENTER)

    }
    //criaçao do perfil

    Dimension tamTela = getToolkit().getScreenSize();
    int largT = tamTela.width;
    int altT = tamTela.height;

    int larg = (int) (largT*0.3);
    int alt = (int) (altT*0.5);

    public Gui(boolean menu){
        super("Menu");
        menu = true;
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
        JButton botaoExercicios = new JButton("Lista De Exercicios");
        JButton botaoRelatorio = new JButton("Relatorio");
        JButton botaoPdf = new JButton("Gerar PDF");

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



    //EVENTOS

    //apaga tudo que esta nos campos de valores
    private class NovoAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            //resetar os valores dos Fields
            nomeF.setText("");
            idadeF.setText("");
            alturaF.setText("");
            pesoF.setText("");
        }
    }
    // fecha a pagina
    private class Fechar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            //resetar os valores dos Fields
            System.exit(0);
        }
    }
    //criar o arquivos com as informaçoes dadas
    private class Salvar extends PerfilControle implements ActionListener {

        PerfilControle p = new PerfilControle("Perfil");
        Perfil perfil;
        @Override
        public void actionPerformed(ActionEvent evento) {
            //componete pai /nome da mensagem/titulo da mensagem
            //tranformaçao do tipo JTextField para Stringo e depois para int e double
            String nome = nomeF.getText();
            String idadeString = idadeF.getText();
            String alturaString = alturaF.getText();
            String pesoString = pesoF.getText();

            if(nome.equals("") || idadeString.equals("") || alturaString.equals("") || pesoString.equals("")){
                JOptionPane.showMessageDialog(null,"Um dos campos nao foi preenchido","Erro",JOptionPane.PLAIN_MESSAGE);
            }else{

                int idade = Integer.parseInt(idadeString);
                double altura = Double.parseDouble(alturaString);
                double peso = Double.parseDouble(pesoString);

                perfil = new Perfil(nome,idade,altura,peso);

                JOptionPane.showMessageDialog(null,"Cadastro Concluido","Cadastro",JOptionPane.PLAIN_MESSAGE);
                p.criarArq(perfil,p);
                Gui g = new Gui(true);
                dispose();
            }

        }
    }

}
