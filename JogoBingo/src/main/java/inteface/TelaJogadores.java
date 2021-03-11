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
 *         Implementação da tela de jogadores              *
 ***********************************************************/

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
