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
        JLabel B = new JLabel("B");
        B.setHorizontalAlignment(SwingConstants.CENTER);
        B.setVerticalAlignment(SwingConstants.CENTER);
        titulo.add(B);
        JLabel I = new JLabel("I");
        I.setHorizontalAlignment(SwingConstants.CENTER);
        I.setVerticalAlignment(SwingConstants.CENTER);
        titulo.add(I);
        JLabel N = new JLabel("N");
        N.setHorizontalAlignment(SwingConstants.CENTER);
        N.setVerticalAlignment(SwingConstants.CENTER);
        titulo.add(N);
        JLabel G = new JLabel("G");
        G.setHorizontalAlignment(SwingConstants.CENTER);
        G.setVerticalAlignment(SwingConstants.CENTER);
        titulo.add(G);
        JLabel O = new JLabel("O");
        O.setHorizontalAlignment(SwingConstants.CENTER);
        O.setVerticalAlignment(SwingConstants.CENTER);
        titulo.add(O);
        JLabel numeros = new JLabel();
        numeros.setLayout(new GridLayout(5,5));
        int[] vet = sorteio.retornaCartela(indice);
        if(vet[0]<0){
            JLabel num = new JLabel(""+vet[0]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[0]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[5]<0){
            JLabel num = new JLabel(""+vet[5]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[5]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[10]<0){
            JLabel num = new JLabel(""+vet[10]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[10]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[14]<0){
            JLabel num = new JLabel(""+vet[14]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[14]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[19]<0){
            JLabel num = new JLabel(""+vet[19]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[19]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[1]<0){
            JLabel num = new JLabel(""+vet[1]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[1]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[6]<0){
            JLabel num = new JLabel(""+vet[6]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[6]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[11]<0){
            JLabel num = new JLabel(""+vet[11]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[11]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[15]<0){
            JLabel num = new JLabel(""+vet[15]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[15]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[20]<0){
            JLabel num = new JLabel(""+vet[20]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[20]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[2]<0){
            JLabel num = new JLabel(""+vet[2]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[2]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[7]<0){
            JLabel num = new JLabel(""+vet[7]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[7]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        
        JLabel centro = new JLabel();
        centro.setIcon(new ImageIcon("imagens/Cartela.png"));
        centro.setHorizontalAlignment(SwingConstants.CENTER);
        centro.setVerticalAlignment(SwingConstants.CENTER);
        centro.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        numeros.add(centro);
        
        if(vet[16]<0){
            JLabel num = new JLabel(""+vet[16]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[16]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[21]<0){
            JLabel num = new JLabel(""+vet[21]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[21]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[3]<0){
            JLabel num = new JLabel(""+vet[3]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[3]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[8]<0){
            JLabel num = new JLabel(""+vet[8]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[8]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[12]<0){
            JLabel num = new JLabel(""+vet[12]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[12]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[17]<0){
            JLabel num = new JLabel(""+vet[17]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[17]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[22]<0){
            JLabel num = new JLabel(""+vet[22]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[22]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[4]<0){
            JLabel num = new JLabel(""+vet[4]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[4]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[9]<0){
            JLabel num = new JLabel(""+vet[9]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[9]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[13]<0){
            JLabel num = new JLabel(""+vet[13]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[13]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[18]<0){
            JLabel num = new JLabel(""+vet[18]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[18]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        if(vet[23]<0){
            JLabel num = new JLabel(""+vet[23]*(-1));
            num.setForeground(Color.red);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }else{
            JLabel num = new JLabel(""+vet[23]);
            num.setHorizontalAlignment(SwingConstants.CENTER);
            num.setVerticalAlignment(SwingConstants.CENTER);
            num.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            numeros.add(num,BorderLayout.CENTER);
        }
        
        titulo.setPreferredSize(new Dimension(200,10));
        numeros.setPreferredSize(new Dimension(200,200));
        numeros.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        titulo.setBackground(Color.white);
        numeros.setBackground(Color.white);
        this.add(titulo);
        this.add(numeros);
    }
}
