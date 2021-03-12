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
 *          Classe auxiliar da classe TelaSorteio          *
 ***********************************************************/
package inteface;

import bingo.Sorteio;
import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author Mara de Lemos Gomes
 */
public class TelaInternaSorteio extends JInternalFrame{
    
    Sorteio sorteio;
    
    public TelaInternaSorteio(Sorteio sorteio1,String path){
        sorteio = sorteio1;
        this.setVisible(true);
        this.setTitle("Cartelas");
        this.setLayout(new FlowLayout());
        for(int i=0;i<sorteio.getQtdJogadores();i++){
           Cartelinha nova = new Cartelinha(sorteio,i,path);
           this.add(nova);
       }
    }
}
