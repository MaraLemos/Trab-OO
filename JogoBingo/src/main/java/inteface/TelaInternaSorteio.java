/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inteface;

import bingo.Cartelinha;
import bingo.Sorteio;
import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author maral
 */
public class TelaInternaSorteio extends JInternalFrame{
    
    Sorteio sorteio;
    
    public TelaInternaSorteio(Sorteio sorteio1){
        sorteio = sorteio1;
        this.setVisible(true);
        this.setTitle("Cartelas");
        this.setLayout(new FlowLayout());
        for(int i=0;i<sorteio.getQtdJogadores();i++){
           Cartelinha nova = new Cartelinha(sorteio,i);
           this.add(nova);
       }
    }
}
