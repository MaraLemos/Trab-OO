/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inteface;

import bingo.Sorteio;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author maral
 */
public class TelaInternaSorteio extends JInternalFrame{
    
    Sorteio sorteio;
    JScrollPane rolagem;
    
    public TelaInternaSorteio(Sorteio sorteio1){
        sorteio = sorteio1;
        setTitle("Cartelas");
        setSize(950,300);
        setVisible(true);
        setLocation(0, 370);
        setResizable(false);
        setBackground(Color.white);
        setLayout(new FlowLayout());
        
        rolagem = new JScrollPane();
           //rolagem.setLayout();
        //Cartelas
       for(int i=0;i<sorteio.getQtdJogadores();i++){
           this.add(imprimeCartela(i));
       }
      
       
    }
    public JLabel imprimeCartela(int i){
        JLabel cartela = new JLabel();
        cartela.setIcon(new ImageIcon("./imagens/Cartela.png"));
        cartela.setSize(211,250);
        cartela.setLocation(50 + i*211,0);
        JLabel textoCartela = new JLabel("<html><body><font size="+6+"><br>"+sorteio.imprimeJogador(i)+"</font></body></html>");
        textoCartela.setLayout(null);
        textoCartela.setSize(211,250);
        cartela.add(textoCartela);
        return cartela;
    }
}
