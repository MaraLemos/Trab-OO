/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author maral
 */
public class Cartelinha extends JInternalFrame{
    
    Sorteio sorteio;
    int indice;
    
    public Cartelinha(Sorteio sorteio1, int i){
        sorteio = sorteio1;
        indice = i;
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(220,280));
        this.setTitle(sorteio.retornaNomeJogador(indice));
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setBackground(Color.white);
        this.pack();
        monta();
    }
    public void monta(){
        JLabel titulo = new JLabel();
        titulo.setLayout(new GridLayout(1,5));
        titulo.add(new JLabel("B"));
        titulo.add(new JLabel("I"));
        titulo.add(new JLabel("N"));
        titulo.add(new JLabel("G"));
        titulo.add(new JLabel("O"));
        JLabel numeros = new JLabel();
        numeros.setLayout(new GridLayout(5,5));
        int[] vet = sorteio.retornaCartela(indice);
        if(vet[0]<0){
            JLabel num = new JLabel(""+vet[0]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[0]));
        }
        if(vet[5]<0){
            JLabel num = new JLabel(""+vet[5]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[5]));
        }
        if(vet[10]<0){
            JLabel num = new JLabel(""+vet[10]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[10]));
        }
        if(vet[14]<0){
            JLabel num = new JLabel(""+vet[14]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[14]));
        }
        if(vet[19]<0){
            JLabel num = new JLabel(""+vet[19]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[19]));
        }
        if(vet[1]<0){
            JLabel num = new JLabel(""+vet[1]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[1]));
        }
        if(vet[6]<0){
            JLabel num = new JLabel(""+vet[6]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[6]));
        }
        if(vet[11]<0){
            JLabel num = new JLabel(""+vet[11]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[11]));
        }
        if(vet[15]<0){
            JLabel num = new JLabel(""+vet[15]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[15]));
        }
        if(vet[20]<0){
            JLabel num = new JLabel(""+vet[20]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[20]));
        }
        if(vet[2]<0){
            JLabel num = new JLabel(""+vet[2]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[2]));
        }
        if(vet[7]<0){
            JLabel num = new JLabel(""+vet[7]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[7]));
        }
        numeros.add(new JLabel("X"));
        if(vet[16]<0){
            JLabel num = new JLabel(""+vet[16]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[16]));
        }
        if(vet[21]<0){
            JLabel num = new JLabel(""+vet[21]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[21]));
        }
        if(vet[3]<0){
            JLabel num = new JLabel(""+vet[3]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[3]));
        }
        if(vet[8]<0){
            JLabel num = new JLabel(""+vet[8]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[8]));
        }
        if(vet[12]<0){
            JLabel num = new JLabel(""+vet[12]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[12]));
        }
        if(vet[17]<0){
            JLabel num = new JLabel(""+vet[17]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[17]));
        }
        if(vet[22]<0){
            JLabel num = new JLabel(""+vet[22]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[22]));
        }
        if(vet[4]<0){
            JLabel num = new JLabel(""+vet[4]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[4]));
        }
        if(vet[9]<0){
            JLabel num = new JLabel(""+vet[9]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[9]));
        }
        if(vet[13]<0){
            JLabel num = new JLabel(""+vet[13]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[13]));
        }
        if(vet[18]<0){
            JLabel num = new JLabel(""+vet[18]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[18]));
        }
        if(vet[23]<0){
            JLabel num = new JLabel(""+vet[23]*(-1));
            num.setForeground(Color.red);
            numeros.add(num);
        }else{
            numeros.add(new JLabel(""+vet[23]));
        }
        //JLabel nome = new JLabel(sorteio.retornaNomeJogador(indice));
        
        titulo.setPreferredSize(new Dimension(200,10));
        numeros.setPreferredSize(new Dimension(200,200));
        //nome.setPreferredSize(new Dimension(200,10));
        titulo.setBackground(Color.white);
        numeros.setBackground(Color.white);
        //nome.setBackground(Color.white);
        this.add(titulo);
        this.add(numeros);
        //this.add(nome);
    }
}
