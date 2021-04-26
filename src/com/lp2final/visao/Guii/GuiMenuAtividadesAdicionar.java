package com.lp2final.visao.Guii;

import com.lp2final.controle.AtividadesBD;
import com.lp2final.controle.AtividadesControle;
import com.lp2final.controle.PerfilControle;
import com.lp2final.modelo.AtividadeFeita;
import com.lp2final.modelo.AtividadeFisica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.function.IntFunction;

public class GuiMenuAtividadesAdicionar extends JFrame {

    Dimension tamTela = getToolkit().getScreenSize();
    int largT = tamTela.width;
    int altT = tamTela.height;

    int larg = (int) (largT*0.3);
    int alt = (int) (altT*0.5);

    String arquivoPerfil;
    AtividadeFisica atividadeFisica;

    public GuiMenuAtividadesAdicionar(String arquivoPerfil){
        super("Menu");
        this.arquivoPerfil = arquivoPerfil;

        try {
            if (new AtividadesControle(arquivoPerfil).lerAtividades().size() == 0) {
                AtividadesBD atividadesBD = new AtividadesBD(arquivoPerfil);
            }

            setSize(larg, alt);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        setLocationRelativeTo(null);
        setVisible(true);
    }



    public void atividadesAdicionarMenu(){
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
        ArrayList<AtividadeFisica> atividades = null;
        try {
            atividades = atividadesControle.lerAtividades();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> atividadesNomes = new ArrayList<>();
        for (AtividadeFisica atividade : atividades) {
            atividadesNomes.add(atividade.getNome());
        }

        JComboBox atividadesLista = new JComboBox(atividadesNomes.toArray(value -> new String[0]));

        //botoens
        JButton botaoSelecionarAtividade = new JButton("Selecionar Atividade");
        ArrayList<AtividadeFisica> finalAtividades = atividades;
        botaoSelecionarAtividade.addActionListener(e -> {
            String escolha = atividadesLista.getSelectedItem().toString();
            for (AtividadeFisica atividadeFisica : finalAtividades) {
                if (atividadeFisica.getNome().equals(escolha)) {
                    AtividadeFeita atividadeFeita = new AtividadeFeita(new PerfilControle(arquivoPerfil).getPerfil(), Instant.now(), atividadeFisica, "", 0.0);
                    Modificador modificador = new Modificador(atividadeFeita, arquivoPerfil);
                    modificador.alterarAtividade();
                    break;
                }
            }
            // AtividadeFeita(Perfil perfil, Instant data, AtividadeFisica atividadeFisica, String descricao, Double duracao)
            //atividadeFeita = new AtividadeFeita(arquivoPerfil, Instant.now(), atividadesLista.getSelectedItem().toString(), )
        });
        JButton botaoNovaAtividade = new JButton("Nova Atividade");
        botaoNovaAtividade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Modificador(arquivoPerfil).adicionarAtividade();
            }
        });

        //tamanho e local dos botoes
        atividadesLista.setBounds((larg/2) - 350/2,10+70*0,350,60);

        botaoSelecionarAtividade.setBounds( (larg/2) - 150/2,10+70*1,150,60);
        botaoNovaAtividade.setBounds((larg/2) - 150/2,10+70*2,150,60);

        panelBotoes.add(atividadesLista);
        panelBotoes.add(botaoSelecionarAtividade);
        panelBotoes.add(botaoNovaAtividade);

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


