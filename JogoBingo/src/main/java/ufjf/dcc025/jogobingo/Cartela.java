/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufjf.dcc025.jogobingo;

/**
 * @author Mara de Lemos Gomes
 * Matrícula: 201965237A
 */
public class Cartela {
    
    public static void iniciaCartela(){
        int[] numeros = new int[24];
        for(int i=0; i< 24; i++){
            numeros[i] = (int)(Math.random() * 99);
        }
        System.out.println("Cartela:");
        for(int i=0; i< 24; i++){
            System.out.print(numeros[i] + " ");
        }
    }
    public static void main(String[] args){
        iniciaCartela();
    }   
}
