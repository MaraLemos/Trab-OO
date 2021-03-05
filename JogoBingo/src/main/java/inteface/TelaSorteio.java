/************************************************************
 * Universidade Federal de Juiz de Fora - UFJF              *
 * Instituto de Ciências Exatas                             *
 * Departamento de Ciência da Computação                    *
 * Disciplina: DCC025 – Orientação a Objetos - 2020.3       *
 * Professor: Gleiph Ghiotto Lima de Menezes                *
 * Aluno(s): Ary de Paula Canuto Neto - MAT 201965560C      *
 *           Ketleen Anne Faria - MAT 201965066AC           *
 *           Mara de Lemos Gomes - MAT 201965237A           *
 *           Thiago Goulart da Fonseca - MAT 201865119AB    *
 * Versão: 1.0.0                                            *
 *                    TRABALHO PRÁTICO                      *
 ************************************************************/

/***********************************************************
 *              Implementação da tela do sorteio           *
 ***********************************************************/

package inteface;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Mara de Lemos Gomes
 */
public class TelaSorteio implements ActionListener{
    
    private JFrame pag = new JFrame();
    private JButton botaoGirar = new JButton("Gire a roleta");
    private JButton botaoParar = new JButton("Parar");
           
    public TelaSorteio(){
        
        pag.setTitle("Sorteio"); //Define o titulo do frame
        pag.setSize(1920,1080); //Define o tamanho do frame
        pag.setLocationRelativeTo(null); //Centralizar o frame
        pag.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Encerrar a aplicação ao clicar em x
        pag.setResizable(false); //Cancelar(false) o redimensionamento do frame
        pag.setVisible(true); //Visibilidade do frame
        mostra();
    }
    private void mostra(){
        Container principal = pag.getContentPane();
        principal.setLayout(null);
        principal.setBackground(Color.white);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("imagens/TextoNumSorteados.png"));
        label.setLocation(700, 0);
        label.setSize(453, 75);
        principal.add(label);
       
        //Criando roleta
       JLabel aste = new JLabel();
       aste.setIcon(new ImageIcon("imagens/roleta/AsteRoleta.png"));
       aste.setSize(200, 161);
       aste.setLocation(80,130);
       principal.add(aste);
       JLabel roda = new JLabel();
       roda.setIcon(new ImageIcon("imagens/roleta/CirculoRoleta.png"));
       roda.setSize(202, 210);
       roda.setLocation(80,50);
       principal.add(roda);
       JLabel bolaAmarela = new JLabel();
       bolaAmarela.setIcon(new ImageIcon("imagens/roleta/BolaAmarela.png"));
       bolaAmarela.setSize(30, 30);
       bolaAmarela.setLocation(100,173);
       principal.add(bolaAmarela);
       JLabel bolaLaranja = new JLabel();
       bolaLaranja.setIcon(new ImageIcon("imagens/roleta/BolaLaranja.png"));
       bolaLaranja.setSize(30, 30);
       bolaLaranja.setLocation(125,193);
       principal.add(bolaLaranja);
       JLabel bolaRosa = new JLabel();
       bolaRosa.setIcon(new ImageIcon("imagens/roleta/BolaRosa.png"));
       bolaRosa.setSize(30, 30);
       bolaRosa.setLocation(160,194);
       principal.add(bolaRosa);
       JLabel bolaVerde = new JLabel();
       bolaVerde.setIcon(new ImageIcon("imagens/roleta/BolaVerde.png"));
       bolaVerde.setSize(30, 30);
       bolaVerde.setLocation(122,174);
       principal.add(bolaVerde);
       JLabel bolaVermelha = new JLabel();
       bolaVermelha.setIcon(new ImageIcon("imagens/roleta/BolaVermelha.png"));
       bolaVermelha.setSize(30, 30);
       bolaVermelha.setLocation(178,183);
       principal.add(bolaVermelha);
       
       //Botão de sortear
       botaoGirar.setIcon(new ImageIcon("imagens/BotaoGireARoleta.png"));
       botaoGirar.setBackground(Color.black);
       botaoGirar.setSize(220, 35);
       botaoGirar.setLocation(50,275);
       botaoGirar.setVisible(true);
       principal.add(botaoGirar);
       botaoGirar.addActionListener(this);
       
       //Botão parar
       botaoParar.setIcon(new ImageIcon("imagens/BotaoPararRoleta.png"));
       botaoParar.setSize(220, 35);
       botaoParar.setLocation(60,275);
       botaoParar.add(botaoParar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botaoGirar){
            botaoGirar.setVisible(false);
            botaoParar.setVisible(true);
        }
    }
    
}
