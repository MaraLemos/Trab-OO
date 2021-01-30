/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.Random;

/**
 *
 * @author ketleen
 */
public class Teste {
    // Sorteio de numeros aleatrorios

    public static void main(String[] args){

        int numero;
        int[] vetor = new int[24];
        Random random = new Random();

        for(int i=0; i<vetor.length; i++){
             numero = random.nextInt(60) + 1;
             for(int j=0; j<vetor.length; j++){
                   if(numero == vetor[j] && j != i){
                         numero = random.nextInt(60) + 1;
                   }else{
                        vetor[i] = numero;
                   }
             }
        }
        
        //Apresentar na tela o resultado
        for(int i=0; i<vetor.length; i++){
             System.out.print(vetor[i]+"  ");
        }
    }
}
