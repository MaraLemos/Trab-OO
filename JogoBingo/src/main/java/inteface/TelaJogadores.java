/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inteface;

import bingo.Jogador;
import bingo.Sorteio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author ketleen
 * @param ae
 */
public class TelaJogadores extends JFrame implements ActionListener, InterfaceTela {

    private JTable tableJogadores;
    private JPanel painelJogadores;
    private JPanel painelAddJogadores;
    private Jogador cadastro;
    private Sorteio jogador;

    public TelaJogadores() {
        this.tableJogadores = new JTable();
        this.painelJogadores = new JPanel();
        this.painelAddJogadores = new JPanel();
        jogador = new Sorteio();
        
        this.setTitle("Jogadores");
        mostra();
    }

 
    @Override
    public void mostra() {
        
        //configura painel
        painelJogadores.setSize(960, 720);
        painelJogadores.setLayout(null);
      
      
        if(jogador.getQtdJogadores()==0){
            
        }
        
        painelJogadores.setVisible(true);
       
        mostra();
    }   
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
