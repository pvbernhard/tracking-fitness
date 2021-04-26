package com.lp2final.visao.Guii;

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

        setSize(larg, alt);
        setLocationRelativeTo(null);
        setVisible(true);
    }



    public void atividadesAdicionarMenu(){
        setLayout(new BorderLayout()); //criar um borda em torno da janela

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
        JButton botaoPerfil = new JButton("Selecionar Atividade");
        ArrayList<AtividadeFisica> finalAtividades = atividades;
        botaoPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String escolha = atividadesLista.getSelectedItem().toString();
                for (AtividadeFisica atividadeFisica : finalAtividades) {
                    if (atividadeFisica.getNome().equals(escolha)) {
                        AtividadeFeita atividadeFeita = new AtividadeFeita(new PerfilControle(arquivoPerfil).getPerfil(), Instant.now(), atividadeFisica, "", 0.0);
                        Modificador modificador = new Modificador(atividadeFeita);
                        modificador.alterarAtividade();
                        break;
                    }
                }
                // AtividadeFeita(Perfil perfil, Instant data, AtividadeFisica atividadeFisica, String descricao, Double duracao)
                //atividadeFeita = new AtividadeFeita(arquivoPerfil, Instant.now(), atividadesLista.getSelectedItem().toString(), )
            }
        });
        JButton botaoEditar = new JButton("Nova Atividade");
        botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //tamanho e local dos botoes
        atividadesLista.setBounds((larg/2) - 350/2,10+70*0,350,60);

        botaoPerfil.setBounds( (larg/2) - 150/2,10+70*1,150,60);
        botaoEditar.setBounds((larg/2) - 150/2,10+70*2,150,60);

        panelBoteoes.add(atividadesLista);
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


