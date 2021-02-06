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
    }
    
    /**
     * Insere jogador no bingo
     * 
     * @author Ary de Paula Canuto Neto
     */
    
    public void insereJogador(){
        Scanner teclado = new Scanner(System.in);
        int id = 1;
        int resposta;
        String nome;
        System.out.println("Quer adicionar um jogador?\n (1) Sim\n (2) Não\n");
        resposta = teclado.nextInt();
        while(resposta < 1 && resposta > 2){
            System.out.println("Resposta inválida. Quer adicionar um jogador?\n (1) Sim\n (2) Não\n");
            resposta = teclado.nextInt();
        }
        while(resposta == 1){
            System.out.println("Qual o nome do jogador?");
        
            nome = teclado.next();
        
            jogadores.add(new Jogador(nome, id));
            cartelas.add(new CartelaLinha(id));
            id++;
            
            System.out.println("Quer adicionar outro jogador?\n (1) Sim\n (2) Não\n");
            resposta = teclado.nextInt();
        }
        
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
