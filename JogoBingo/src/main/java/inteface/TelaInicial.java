/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inteface;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author ketleen
 */
public class TelaInicial extends JFrame implements ActionListener, InterfaceTela {

    private final JPanel painelBingo;
    private final JLabel bingo;
    private JButton jogadores;
    private JButton configuracao;
    private JButton iniciar;

    public TelaInicial() {
        this.painelBingo = new JPanel();
        this.bingo = new JLabel();
        this.jogadores = new JButton("Jogadores");
        this.configuracao = new JButton("Configuração");
        this.iniciar = new JButton("Iniciar");
    }

    @Override
    public void mostra() {

        //configura painelbingo
        this.painelBingo.setLayout(null);
        this.painelBingo.setSize(960, 720);

        //configura bingo
        this.bingo.setIcon(new ImageIcon("imagens/TextoBingo.png"));
        this.bingo.setSize(499, 114);
        this.bingo.setLocation(252, 100);

        //configura botao jogadores
        jogadores.setIcon(new ImageIcon("imagens/Jogadores.png"));
        //jogadores.setLayout(new GridLayout(40,40,40,40));
        jogadores.setBackground(Color.black);
        jogadores.setSize(190, 178);
        jogadores.setLocation(90, 450);
        jogadores.setVisible(true);

        jogadores.addActionListener(this);

        //configura botao configuracao
        configuracao.setIcon(new ImageIcon("imagens/Configuracoes.png"));
        //configuracao.setLayout(null);
        configuracao.setBackground(Color.black);
        configuracao.setSize(190, 178);
        configuracao.setLocation(360, 450);
        configuracao.setVisible(true);

        configuracao.addActionListener(this);

        //configura botao iniciar
        iniciar.setIcon(new ImageIcon("imagens/iniciar.png"));
        //iniciar.setLayout(null);
        iniciar.setBackground(Color.black);
        iniciar.setSize(190, 178);
        iniciar.setLocation(610, 450);
        iniciar.setVisible(true);

        iniciar.addActionListener(this);

        this.painelBingo.add(bingo);
        this.painelBingo.add(jogadores);
        this.painelBingo.add(configuracao);
        this.painelBingo.add(iniciar);
        add(this.painelBingo);

    }

    public static void main(String[] args) {

        TelaInicial telainicial = new TelaInicial();
        telainicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telainicial.setSize(960, 720);
        telainicial.setLayout(null);
        telainicial.setBackground(Color.white);

        telainicial.mostra();
        telainicial.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
