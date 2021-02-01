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

/**
 *
 * @author Mara de Lemos Gomes
 */

public class Sorteio {
    
    private List<Jogador> jogadores;
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
}
