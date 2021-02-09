/************************************************************
 * Universidade Federal de Juiz de Fora - UFJF              *
 * Instituto de Ciências Exatas                             *
 * Departamento de Ciência da Computação                    *
 * Disciplina: DCC025 – Orientação a Objetos - 2020.3       *
 * Professor: Gleiph Ghiotto Lima de Menezes                *
 * Aluno(s): Ary de Paula Canuto Neto                       *
 *           Ketleen Anne Faria                             *
 *           Mara de Lemos Gomes                            *
 *           Thiago Goulart da Fonseca                      *
 * Versão: 1.0.0                                            *
 *                    TRABALHO PRÁTICO                      *
 ************************************************************/

/***********************************************************
 * Implementação dos atributos e métodos da classe Sorteio *
 ***********************************************************/
 
package bingo;

import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Mara de Lemos Gomes
 */

public class Sorteio {
    
    private  List<Jogador> jogadores;
    private List<Cartela> cartelas;
    private int[] numSorteados;
    private int vencedor;
    private String tipoCartela;
    private int id;
	/**
	 * Construtor da classe Sorteio
	 *
	 * @author Mara de Lemos Gomes
	 */
    public Sorteio() {
        this.jogadores = new ArrayList<>();
		this.cartelas = new ArrayList<>();
		this.numSorteados = new int[75];
		this.vencedor = 0;
                this.id = 0;
    }
    
    /**
     * Insere jogador no bingo
     * 
     * @author Ary de Paula Canuto Neto
     */
    
    public void insereJogador(String nome){
        nome = nome.toUpperCase().trim();
        
        this.id = 1;
        String nome1;
        
        for(int i = 0; i < jogadores.size(); i++){
            nome1 = jogadores.get(i).getUserName();
            nome1 = nome1.toUpperCase().trim();
            if(nome1.compareTo(nome) == 0){
                JOptionPane.showMessageDialog(null, "Esse nome já está sendo usado, tente outro.", "ERRO!", JOptionPane.ERROR_MESSAGE, null);
                return;
            }
        }
        jogadores.add(new Jogador(nome, id));
        
        if(tipoCartela == "cheia"){
            cartelas.add(new CartelaCheia(id));
        }
        else{
            cartelas.add(new CartelaLinha(id));
        }
        
        id++;
    }
    
    public void RemoveJogador(int id) {

        if (id >= 0 && id < this.jogadores.size()) {
            for (int i = id; i < this.jogadores.size() - 1; i++) {
                this.jogadores.set(i, this.jogadores.get(i + 1));
            }
        }else{
            JOptionPane.showConfirmDialog(null, " Jogador não existe ! ", " ERRO !" ,JOptionPane.DEFAULT_OPTION);
        }
    }
}
