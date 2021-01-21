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

package ufjf.dcc025.jogobingo;

/**
 * @author Mara de Lemos Gomes
 * Matrícula: 201965237A
 */
public class Cartela {
    
    private static int[] numeros;
    private static String jogadorAssoc;
    private static int numMarcados;
    
    public Cartela(String nome){
        numeros = new int[24];
        numMarcados = 0;
        jogadorAssoc = nome;
        iniciaCartela();
    }
    
    public int getNumMarcados(){
        return numMarcados;
    }
    
    public String getJogadorAssoc(){
        return jogadorAssoc;
    }
    
    public void addNumMarcados(){
        if(buscaNum())
            numMarcados++;
    }
    
    private static boolean buscaNum(){
        return false;
    }
    private static int insereOrd(int num, int tam){
        int i, j;
        if (tam == 0) {
            numeros[0] = num;
            tam++;
            return tam;
        } else {
            for (i = 0; i < tam; i++) {
                if (num < numeros[i]) {
                    for (j = tam - 1; j >= i; j--) {
                        numeros[j + 1] = numeros[j];
                    }
                    numeros[i] = num;
                    tam++;
                    return tam;
                }
            }
            numeros[tam] = num;
            tam++;
            return tam;
        }
    }
    private static void iniciaCartela(){
        
        int tam = 0,aux;
        for(int i=0; i< 24; i++){
            aux = (int)(Math.random() * 99);
            tam = insereOrd(aux, tam);
        }
    }
    
    public void imprimeCartela(){
        System.out.println("Cartela:");
        for(int i=0; i< 24; i++){
            System.out.print(numeros[i] + " ");
        }
    }
    
    public static void main(String[] args){
        Cartela mara = new Cartela("Mara");
        mara.imprimeCartela();
        System.out.print(mara.getJogadorAssoc());
    }   
}
