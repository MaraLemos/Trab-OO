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
 * Implementação dos atributos e métodos da classe Cartela *
 ***********************************************************/

package bingo;

import java.util.Random;

/**
 *
 * @author Mara de Lemos Gomes
 */
 
public class Cartela {
    
    private static int id;
    private static int[] numeros;
    private static int numMarcados;
    
	/**
    * Construtor da classe cartela
	* @param identificador
    * 
    * @author Mara de Lemos Gomes
    */
    public Cartela(int identificador){
        id = identificador;
        numeros = new int[24];
        numMarcados = 0;
        iniciaCartela();
    }
    
	/**
    * Retorna Id da cartela
    * 
    * @author Mara de Lemos Gomes
    */
    public int getId(){
        return id;
    }
    
	/**
    * Retorna a quantidade de números marcados
    * 
    * @author Mara de Lemos Gomes
    */
    public int getNumMarcados(){
        return numMarcados;
    }
    
    /**
    * Marca número se ele existe na cartela
    * 
    * @author Mara de Lemos Gomes
    * @param num
    */
    public static void addNumMarcados(int num){
        if(buscaNum(num))
            numMarcados++;
    }
    
	/**
    * Verifica se o número está na cartela
    * @param num
	*
    * @author 
    */
    
    /**
    * Insere os números no vetor numeros em ordem crescente
    * @param num
    * @param tam
    * 
    * @author Mara de Lemos Gomes
    */
    private static int insereOrd(int num, int tam){
        int i, j;
        if (tam == 0) {
            numeros[0] = num;
            tam++;
            return tam;
        } else {
            for (i = 0; i < tam; i++) {
                //Se número já existe no vetor, não faz nada
                if(num == numeros[i]){
                    return tam;
                }
                //Se número é menor do que qualquer elemento do vetor
                if (num < numeros[i]) {
                    //Arrasta os demais elementos e insere número
                    for (j = tam - 1; j >= i; j--) {
                        numeros[j + 1] = numeros[j];
                    }
                    numeros[i] = num;
                    tam++;
                    return tam;
                }
            }
            //Se número é maior do que qualquer elemento do vetor
            numeros[tam] = num;
            tam++;
            return tam;
        }
    }
    
    /**
    * Sorteia números aleatórios para formar cartela
    * 
    * @author Mara de Lemos Gomes
    */
    private static void iniciaCartela(){
        
        //Cada cartela é única e possui 24 números aleatórios variando de 1 a 75.
        
        int tam = 0,aux;
        Random random = new Random();
        
        //A coluna "B" é utilizada para os números de 1 a 15
        while(tam != 5){
            aux = random.nextInt(15) + 1;
            tam = insereOrd(aux, tam);
        }
        
        //A coluna "I" varia de 16 a 30
        tam = 6;
        while(tam != 5){
            aux = random.nextInt(15) + 16;
            tam = insereOrd(aux, tam);
        }
        
        //"N" de 31 a 45
        tam = 11;
        while(tam != 4){
            aux = random.nextInt(15) + 31;
            tam = insereOrd(aux, tam);
        }
        
        //"G" de 46 a 60
        tam = 15;
        while(tam != 5){
            aux = random.nextInt(15) + 46;
            tam = insereOrd(aux, tam);
        }
        
        //"O" de 61 a 75
        tam = 20;
        while(tam != 5){
            aux = random.nextInt(15) + 61;
            tam = insereOrd(aux, tam);
        }
    }
    
    
    //verifica se o numero está dentro dos limites que possui na cartela
    // e depois se o numero passado está na  cartela
    
    public static boolean buscaNum(int num){
        if(num >= 0 && num <= 75){
            for(int i=0; i < numeros.length; i++){
                if(numeros[i] == num)
                    return true;
            }
            return false;
        }
        else
            return false;
            
    }
    
    public void imprimeCartela(){
        System.out.println("Cartela:");
        for(int i=0; i< 24; i++){
            System.out.print(numeros[i] + " ");
        }
    }
    
    
    
    public static void main(String[] args){
        Cartela mara = new Cartela(01);
        mara.imprimeCartela();
        System.out.print(mara.getId());
        System.out.println(" " + mara.buscaNum(8));
    }   
    
}
