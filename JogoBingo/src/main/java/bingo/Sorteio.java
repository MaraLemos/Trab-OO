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
    private int qtdJogadores;
	/**
	 * Construtor da classe Sorteio
	 *
	 * @author Mara de Lemos Gomes
	 */
    public Sorteio(String tipo) {
        this.jogadores = new ArrayList<>();
		this.cartelas = new ArrayList<>();
		this.numSorteados = new int[75];
		this.vencedor = 0;
                this.tipoCartela = tipo;
                this.qtdJogadores = 0;
    }
    
    /**
     * Insere jogador no bingo
     * @param nome
     * 
     * @author Ary de Paula Canuto Neto
     */
    
    public void insereJogador(String nome){
        nome = nome.toUpperCase().trim();
        
        String nome1;
        int i;
        
        for(i = 0; i < jogadores.size(); i++){
            nome1 = jogadores.get(i).getUserName();
            nome1 = nome1.toUpperCase().trim();
            if(nome1.compareTo(nome) == 0){
                JOptionPane.showMessageDialog(null, "Esse nome já está sendo usado, tente outro.", "ERRO!", JOptionPane.ERROR_MESSAGE, null);
                break;
            }
        }
        
        if(i == jogadores.size()){
            jogadores.add(new Jogador(nome, qtdJogadores));
        
            if(tipoCartela.compareTo("cheia") == 0){
                cartelas.add(new CartelaCheia(qtdJogadores));
            }
            else{
                cartelas.add(new CartelaLinha(qtdJogadores));
            }

            this.qtdJogadores++;
        }
    }
    
    public void RemoveJogador(int id) {

        if (id >= 0 && id < this.jogadores.size()) {
            jogadores.remove(id);
            cartelas.remove(id);
            this.qtdJogadores--;
        }else{
            JOptionPane.showConfirmDialog(null, " Jogador não existe ! ", " ERRO !" ,JOptionPane.DEFAULT_OPTION);
        }
    }
    
    /**
    * Edita o nome do jogador na lista de jogadores
    * 
    * @author Thiago Goulart da Fonseca
    * @param nome
    * @param id
    */
    
    public void editaJogador(String nome ,int id){
        int i;
        
        for(i = 0; i < jogadores.size(); i++){
            if(jogadores.get(i).getUserName().compareTo(nome) == 0){
                JOptionPane.showConfirmDialog(null, " Nome já utilizado ! ", " ERRO !" ,JOptionPane.DEFAULT_OPTION);
                break;
            }
        }
        if(i == jogadores.size()){
            jogadores.get(id).setUserName(nome);
            JOptionPane.showConfirmDialog(null, " Nome alterado com Sucesso ! ", " SUCESSO !" ,JOptionPane.DEFAULT_OPTION);
        }
    }
    
    /**
     * Imprime todos os jogadores da lista e sua cartela
     * 
     * @author Mara de Lemos Gomes
     */
    public void imprimeJogadores(){
        for(int i = 0; i < jogadores.size(); i++){
            System.out.println(jogadores.get(i).getUserName());
            cartelas.get(i).imprimeCartela();   
        }
    }
    
    /**
     * Retorna a quatidade de jogadores na lista
     * @return qtdJogadores
     * 
     * @author Mara de Lemos Gomes 
     */
    public int getQtdJogadores(){
        return qtdJogadores;
    }
    
    /**
     * sorteia os numeros para o bingo
     * 
     * @author Ary de Paula Canuto Neto
     */
    public void roleta(){
        int numero = (int) (1 + Math.random() * 74);
        System.out.println(numero); //coloquei aqui só para ajudar na visualização
        int i;
        
        //verifica se o numero ja foi sorteado
        for(i = 0; i < numSorteados.length; i++){
            if(numSorteados[i] == numero){
                break;
            }
        }
        
        //insere o numero sorteado na primeira posição disponivel
        for(int k = 0; k < numSorteados.length; k++){
            if(numSorteados[k] == 0){
                numSorteados[k] = numero;
                break;
            }
        }
        
        //marca o numero e checa se a cartela cumpre os requisitos para ganhar o jogo
        if(i == numSorteados.length){
            for(int j = 0; j < cartelas.size(); j++){
                cartelas.get(j).marcaNum(numero);
                if(cartelas.get(j).verificaVitoria() == true){
                    System.out.println("vitoria!");
                }
            }
        }
    }
    
    public static void main(String[] args){
        Sorteio sorteio1 = new Sorteio("cheia"); 
        sorteio1.insereJogador("Maria");
        sorteio1.insereJogador("Joao");
        sorteio1.insereJogador("Joao");
        System.out.println(sorteio1.getQtdJogadores());
        sorteio1.imprimeJogadores();
        
        sorteio1.RemoveJogador(0);
        System.out.println(sorteio1.getQtdJogadores());
        
        sorteio1.roleta();
        sorteio1.roleta();
        sorteio1.roleta();
        sorteio1.roleta();
        sorteio1.roleta();
        sorteio1.roleta();
        sorteio1.roleta();
        
        sorteio1.imprimeJogadores();
    } 
}
