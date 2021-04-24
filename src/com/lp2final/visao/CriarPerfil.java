package com.lp2final.visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarPerfil {
    private JPanel panelCriarPerfil;
    private JButton criarPerfilButton;
    private JTextField textFieldNome;
    private JTextField textFieldIdade;
    private JTextField textFieldAltura;
    private JTextField textFieldPeso;

    public CriarPerfil() {
        panelCriarPerfil.setPreferredSize(new Dimension(320, 400));
        criarPerfilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Verificar dados ...");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Criar Perfil");
        frame.setContentPane(new CriarPerfil().panelCriarPerfil);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
