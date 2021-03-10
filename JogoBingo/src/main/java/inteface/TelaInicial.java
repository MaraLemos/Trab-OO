/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inteface;

import bingo.Sorteio;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author ketleen
 */
public class TelaInicial extends JFrame implements ActionListener, InterfaceTela {

    private final JPanel painelBingo;
    private final JLabel bingo;
    private final JButton jogadores;
    private final JButton configuracao;
    private final JButton iniciar;
    private Sorteio sorteio1;
    
    public TelaInicial() {
        this.painelBingo = new JPanel();
        this.bingo = new JLabel();
        this.jogadores = new JButton("Jogadores");
        this.configuracao = new JButton("Configuração");
        this.iniciar = new JButton("Iniciar");
        
        this.setTitle("Tela Inicial");
    }

    @Override
    public void mostra() {

        //configura painelbingo
        this.painelBingo.setLayout(null);
        this.painelBingo.setSize(960,720);
        
        //configura bingo
        this.bingo.setIcon(new ImageIcon("imagens/TextoBingo.png"));
        this.bingo.setSize(499, 114);
        this.bingo.setLocation(252, 100);

        //configura botao jogadores
        jogadores.setIcon(new ImageIcon("imagens/Jogadores.png"));
        jogadores.setBackground(Color.black);
        jogadores.setSize(190, 178);
        
        jogadores.setBorderPainted(false); 
        jogadores.setContentAreaFilled(false); 
        jogadores.setFocusPainted(false);
        
        jogadores.setLocation(95, 500);
        jogadores.setVisible(false);

        jogadores.addActionListener(this);
        
        //configura botao configuracao
        configuracao.setIcon(new ImageIcon("imagens/Configuracoes.png"));
        configuracao.setBackground(Color.black);
        configuracao.setSize(190, 178);
        
        configuracao.setBorderPainted(false); 
        configuracao.setContentAreaFilled(false); 
        configuracao.setFocusPainted(false);
        
        configuracao.setLocation(390, 500);
        configuracao.setVisible(true);

        configuracao.addActionListener(this);

        
        //configura botao iniciar
        iniciar.setIcon(new ImageIcon("imagens/iniciar.png"));
        iniciar.setBackground(Color.black);
        iniciar.setSize(190, 178);
        
        iniciar.setBorderPainted(false); 
        iniciar.setContentAreaFilled(false); 
        iniciar.setFocusPainted(false);
        
        iniciar.setLocation(680, 500);
        iniciar.setVisible(false);

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
    public void actionPerformed(ActionEvent a) {
        String tipo = "";
        
        if(a.getSource()==jogadores){
            
//           TelaJogadores addJogador = new TelaJogadores();

        }
        if(a.getSource()==configuracao){
            String opcoes[]= {"cheia", "linha"};
            Object showInputDialog = JOptionPane.showInputDialog(configuracao,opcoes,
                    "Escolha o tipo de Cartela",JOptionPane.INFORMATION_MESSAGE, 
                    new ImageIcon("imagens/Configuracoes.png"),opcoes, opcoes[0]);
            tipo = showInputDialog.toString();
            
            sorteio1 = new Sorteio();
            sorteio1.setTipoCartela(tipo);
            
            jogadores.setVisible(true);
            iniciar.setVisible(true);
            configuracao.setVisible(false);
            
            try {
                sorteio1.leArquivo();
            } catch (IOException ex) {
                JOptionPane.showConfirmDialog(null, "Banco de dados não encontrado! A aplicação será encerrada.", "ERRO!",JOptionPane.DEFAULT_OPTION);
                System.exit(0);
            }
        }       
        
        if(a.getSource()==iniciar){
            if(sorteio1.getQtdJogadores() < 2){
                JOptionPane.showMessageDialog(null,"É necessário cadastrar jogadores");
            }else{
                this.setVisible(false);
                TelaSorteio telaSorteio = new TelaSorteio(sorteio1);
            }  
        }
    }

}
