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
 * Implementação dos atributos e métodos da classe Sorteio *
 ***********************************************************/
 
package bingo;

import inteface.*;
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
    private int qtdNumSorteados;
    
	/**
	 * Construtor da classe Sorteio
         * @param tipo Recebe se o jogo será iniciado como cartela cheia ou cartela linha/coluna
	 *
	 * @author Mara de Lemos Gomes
	 */
    public Sorteio(String tipo) {
        this.jogadores = new ArrayList<>();
        this.cartelas = new ArrayList<>();
	this.numSorteados = new int[75];
	this.vencedor = -1;
        this.tipoCartela = tipo;
        this.qtdJogadores = 0;
        this.qtdNumSorteados = 0;
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
            Jogador aux = new Jogador(nome);
            jogadores.add(aux);
        
            if(tipoCartela.compareTo("cheia") == 0){
                cartelas.add(new CartelaCheia(aux.getCartelaAssoc()));
            }
            else{
                cartelas.add(new CartelaLinha(aux.getCartelaAssoc()));
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
            System.out.println(jogadores.get(i).getId());
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
        int i;
        boolean controle = true;
		Random random = new Random();
		int numero = random.nextInt(75) + 1;
        
        //Verifica se um número já foi sorteado, caso contrario adiciona ao vetor de sorteados
        while(controle == true){
            if(qtdNumSorteados == 0){
                numSorteados[0] = numero;
                qtdNumSorteados++;
                controle = false;
            }else{
                for(i=0; i < qtdNumSorteados; i++)
                    if(numSorteados[i] == numero){
                        numero = random.nextInt(75) + 1;
                        break;
                    }
                
                //Vetor foi todo percorrido e o número não está vetor
                if(i == qtdNumSorteados){
                    numSorteados[qtdNumSorteados] = numero;
                    qtdNumSorteados++;
                    controle = false;
                }
            }
        }
        
        //marca o numero e checa se a cartela cumpre os requisitos para ganhar o jogo
        
            for(int j = 0; j < cartelas.size(); j++){
                cartelas.get(j).marcaNum(numero);
                if(cartelas.get(j).verificaVitoria() == true){
                    JOptionPane.showConfirmDialog(null, " Parabéns " + jogadores.get(j).getUserName() + "! Você ganhou!", " VITÓRIA !",JOptionPane.DEFAULT_OPTION);
                    vencedor = j;
                }
            }
    }
    
    /**
     * Retorna o id do Jogador vencedor, ou -1 se não existe um vencedor
     * @return vencedor
     *
     * @author Mara de Lemos Gomes
     */
    public int getVencedor(){
	return vencedor;
    }
      
    public static void main(String[] args){
        /*
        Sorteio sorteio1 = new Sorteio("cheia"); 
        sorteio1.insereJogador("Maria");
        sorteio1.insereJogador("Joao");
        sorteio1.insereJogador("Joao");
        sorteio1.insereJogador("Carlos");
        System.out.println(sorteio1.getQtdJogadores());
        sorteio1.imprimeJogadores();
        
        sorteio1.RemoveJogador(0);
        //System.out.println(sorteio1.getQtdJogadores());
        
		while(sorteio1.getVencedor() == -1){
			sorteio1.roleta();
		}
		
        sorteio1.imprimeJogadores();
        */
        TelaSorteio teste = new TelaSorteio();
        
    } 
}
