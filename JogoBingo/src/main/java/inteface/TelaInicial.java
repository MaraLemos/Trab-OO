/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inteface;

import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author ketleen
 */
public class TelaInicial extends JFrame {

    private final JPanel painelBingo;
    private final JLabel bingo;
    public TelaInicial() {
        this.painelBingo = new JPanel();
        this.bingo = new JLabel();
    }

    private void paintPanel() {
           this.painelBingo.setPreferredSize(new Dimension(300, 60));
           this.bingo.setIcon(new ImageIcon("/home/ketleen/Documentos/BingoOO certo/JogoB"));
      
    }

  
    private void paintFrame() {
        paintPanel();
        this.painelBingo.add(bingo);
        add(this.painelBingo, BorderLayout.CENTER);
    }

    public static void main(String[] args) {

        TelaInicial telainicial = new TelaInicial();

        telainicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telainicial.setExtendedState(MAXIMIZED_BOTH);
        telainicial.setLayout(new BorderLayout());
        telainicial.paintFrame();

        telainicial.setVisible(true);
    }

    

}
