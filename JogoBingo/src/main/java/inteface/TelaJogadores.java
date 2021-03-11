/** **********************************************************
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
 *********************************************************** */
/** *********************************************************
 *         Implementação da tela de jogadores              *
 ********************************************************** */
package inteface;

import bingo.Jogador;
import bingo.Sorteio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author ketleen
 * @param
 */
public class TelaJogadores extends JFrame implements ActionListener, InterfaceTela {

    private JLabel imagemJogadores;
   // private final JPanel painelJogadores;
   // private JPanel painelAddJogadores;//colocar um JoptionPane
    private Jogador jogador;
    private Sorteio sorteio;

    public TelaJogadores() {

     //   this.painelJogadores = new JPanel();
        this.imagemJogadores = new JLabel();
        //  this.painelAddJogadores = new JPanel();
        sorteio = new Sorteio();
        
        //nao entendi oq é aqui mas fé
        this.setTitle("Jogadores");
        this.setSize(960, 720);
        this.setLayout(null);
        this.setVisible(true);
        mostra();
    }

    @Override
    public void mostra() {


        //configura imagemJogadores
        this.imagemJogadores.setIcon(new ImageIcon("imagens/TextoJogadores.png"));
        this.imagemJogadores.setSize(392, 82);
        this.imagemJogadores.setLocation(252, 100);
  

        //verifica qtd de jogadores
        if (sorteio.getQtdJogadores() == 0) {

        }
        this.add(this.imagemJogadores);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
