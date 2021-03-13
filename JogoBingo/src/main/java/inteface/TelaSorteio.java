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
 *              Implementação da tela do sorteio           *
 ***********************************************************/

package inteface;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import bingo.Sorteio;        

/**
 *
 * @author Mara de Lemos Gomes
 */
public class TelaSorteio implements ActionListener, InterfaceTela  {
    
    private JFrame pag;
    private JDesktopPane principal;
    private JButton botaoGirar;
    private JButton botaoParar;
    private JLabel bolaAmarela;
    private JLabel bolaLaranja;
    private JLabel bolaRosa;
    private JLabel bolaVerde;
    private JLabel bolaVermelha;
    private boolean controlaMovimento;
    private JLabel num1,num2,num3,num4,num5,num6,num7,num8,num9,num10,num11,num12,num13,num14,num15,
            num16,num17,num18,num19,num20,num21,num22,num23,num24,num25,num26,num27,num28,num29,num30,
            num31,num32,num33,num34,num35,num36,num37,num38,num39,num40,num41,num42,num43,num44,num45,
            num46,num47,num48,num49,num50,num51,num52,num53,num54,num55,num56,num57,num58,num59,num60,
            num61,num62,num63,num64,num65,num66,num67,num68,num69,num70,num71,num72,num73,num74,num75;
    private Sorteio sorteio;
    private JInternalFrame cartelas;
    String path;
    
    public TelaSorteio(Sorteio sorteio1, String path){
        
        this.path = path;
        sorteio = sorteio1;
        pag = new JFrame();
        principal = new JDesktopPane();
        botaoGirar = new JButton("Gire a roleta");
        botaoParar = new JButton("Parar");
        bolaAmarela = new JLabel();
        bolaLaranja = new JLabel();
        bolaRosa = new JLabel();
        bolaVerde = new JLabel();
        bolaVermelha = new JLabel();
        num1 = new JLabel();num2 = new JLabel();num3 = new JLabel();num4 = new JLabel();num5 = new JLabel();
        num6 = new JLabel();num7 = new JLabel();num8 = new JLabel();num9 = new JLabel();num10 = new JLabel();
        num11 = new JLabel();num12 = new JLabel();num13 = new JLabel();num14 = new JLabel();num15 = new JLabel();
        num16 = new JLabel();num17 = new JLabel();num18 = new JLabel();num19 = new JLabel();num20 = new JLabel();
        num21 = new JLabel();num22 = new JLabel();num23 = new JLabel();num24 = new JLabel();num25 = new JLabel();
        num26 = new JLabel();num27 = new JLabel();num28 = new JLabel();num29 = new JLabel();num30 = new JLabel();
        num31 = new JLabel();num32 = new JLabel();num33 = new JLabel();num34 = new JLabel();num35 = new JLabel();
        num36 = new JLabel();num37 = new JLabel();num38 = new JLabel();num39 = new JLabel();num40 = new JLabel();
        num41 = new JLabel();num42 = new JLabel();num43 = new JLabel();num44 = new JLabel();num45 = new JLabel();
        num46 = new JLabel();num47 = new JLabel();num48 = new JLabel();num49 = new JLabel();num50 = new JLabel();
        num51 = new JLabel();num52 = new JLabel();num53 = new JLabel();num54 = new JLabel();num55 = new JLabel();
        num56 = new JLabel();num57 = new JLabel();num58 = new JLabel();num59 = new JLabel();num60 = new JLabel();
        num61 = new JLabel();num62 = new JLabel();num63 = new JLabel();num64 = new JLabel();num65 = new JLabel();
        num66 = new JLabel();num67 = new JLabel();num68 = new JLabel();num69 = new JLabel();num70 = new JLabel();
        num71 = new JLabel();num72 = new JLabel();num73 = new JLabel();num74 = new JLabel();num75 = new JLabel();
        
        pag.setTitle("Sorteio"); //Define o titulo do frame
        pag.setSize(960,720); //Define o tamanho do frame
        pag.setLocationRelativeTo(null); //Centralizar o frame
        pag.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Encerrar a aplicação ao clicar em x
        pag.setResizable(false); //Cancelar(false) o redimensionamento do frame
        pag.setVisible(true); //Visibilidade do frame
        mostra();
    }
    
    @Override
    public void mostra(){
        principal.setLayout(null);
        principal.setBackground(Color.white);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(path+"/TextoNumSorteados.png"));
        label.setLocation(380, 0);
        label.setSize(453, 75);
        principal.add(label);
       
        //Criando roleta
       JLabel aste = new JLabel();
       aste.setIcon(new ImageIcon(path+"/roleta/AsteRoleta.png"));
       aste.setSize(200, 161);
       aste.setLocation(80,130);
       principal.add(aste);
       JLabel roda = new JLabel();
       roda.setIcon(new ImageIcon(path+"/roleta/CirculoRoleta.png"));
       roda.setSize(202, 210);
       roda.setLocation(80,50);
       principal.add(roda);
       bolaAmarela.setIcon(new ImageIcon(path+"/roleta/BolaAmarela.png"));
       bolaAmarela.setSize(30, 30);
       bolaAmarela.setLocation(100,173);
       principal.add(bolaAmarela);
       bolaLaranja.setIcon(new ImageIcon(path+"/roleta/BolaLaranja.png"));
       bolaLaranja.setSize(30, 30);
       bolaLaranja.setLocation(125,193);
       principal.add(bolaLaranja);
       bolaRosa.setIcon(new ImageIcon(path+"/roleta/BolaRosa.png"));
       bolaRosa.setSize(30, 30);
       bolaRosa.setLocation(160,194);
       principal.add(bolaRosa);
       bolaVerde.setIcon(new ImageIcon(path+"/roleta/BolaVerde.png"));
       bolaVerde.setSize(30, 30);
       bolaVerde.setLocation(122,174);
       principal.add(bolaVerde);
       bolaVermelha.setIcon(new ImageIcon(path+"/roleta/BolaVermelha.png"));
       bolaVermelha.setSize(30, 30);
       bolaVermelha.setLocation(178,183);
       principal.add(bolaVermelha);
       
       //Botão de sortear
       botaoGirar.setIcon(new ImageIcon(path+"/BotaoGireARoleta.png"));
       botaoGirar.setBackground(Color.black);
       botaoGirar.setSize(220, 35);
       botaoGirar.setLocation(50,275);
       botaoGirar.setVisible(true);
       principal.add(botaoGirar);
       botaoGirar.addActionListener(this);
       
       //Botão parar
       botaoParar.setIcon(new ImageIcon(path+"/BotaoPararRoleta.png"));
       botaoParar.setBackground(Color.black);
       botaoParar.setSize(220, 35);
       botaoParar.setLocation(50,275);
       botaoParar.setVisible(false);
       principal.add(botaoParar);
       botaoParar.addActionListener(this);
       
       //Numeros
       num1 = organizaNumeros(num1,1,0,1);num2 = organizaNumeros(num2,2,0,2);num3 = organizaNumeros(num3,3,0,3);num4 = organizaNumeros(num4,4,0,4);num5 = organizaNumeros(num5,5,0,5);
       num6 = organizaNumeros(num6,6,0,6);num7 = organizaNumeros(num7,7,0,7);num8 = organizaNumeros(num8,8,0,8);num9 = organizaNumeros(num9,9,0,9);num10 = organizaNumeros(num10,10,0,10);
       num11 = organizaNumeros(num11,11,0,11);num12 = organizaNumeros(num12,12,0,12);num13 = organizaNumeros(num13,13,0,13);num14 = organizaNumeros(num14,14,0,14);num15 = organizaNumeros(num15,15,0,15);
       num16 = organizaNumeros(num16,1,1,16);num17 = organizaNumeros(num17,2,1,17);num18 = organizaNumeros(num18,3,1,18);num19 = organizaNumeros(num19,4,1,19);num20 = organizaNumeros(num20,5,1,20);
       num21 = organizaNumeros(num21,6,1,21);num22 = organizaNumeros(num22,7,1,22);num23 = organizaNumeros(num23,8,1,23);num24 = organizaNumeros(num24,9,1,24);num25 = organizaNumeros(num25,10,1,25);
       num26 = organizaNumeros(num26,11,1,26);num27 = organizaNumeros(num27,12,1,27);num28 = organizaNumeros(num28,13,1,28);num29 = organizaNumeros(num29,14,1,29);num30 = organizaNumeros(num30,15,1,30);
       num31 = organizaNumeros(num31,1,2,31);num32 = organizaNumeros(num32,2,2,32);num33 = organizaNumeros(num33,3,2,33);num34 = organizaNumeros(num34,4,2,34);num35 = organizaNumeros(num35,5,2,35);
       num36 = organizaNumeros(num36,6,2,36);num37 = organizaNumeros(num37,7,2,37);num38 = organizaNumeros(num38,8,2,38);num39 = organizaNumeros(num39,9,2,39);num40 = organizaNumeros(num40,10,2,40);
       num41 = organizaNumeros(num41,11,2,41);num42 = organizaNumeros(num42,12,2,42);num43 = organizaNumeros(num43,13,2,43);num44 = organizaNumeros(num44,14,2,44);num45 = organizaNumeros(num45,15,2,45);
       num46 = organizaNumeros(num46,1,3,46);num47 = organizaNumeros(num47,2,3,47);num48 = organizaNumeros(num48,3,3,48);num49 = organizaNumeros(num49,4,3,49);num50 = organizaNumeros(num50,5,3,50);
       num51 = organizaNumeros(num51,6,3,51);num52 = organizaNumeros(num52,7,3,52);num53 = organizaNumeros(num53,8,3,53);num54 = organizaNumeros(num54,9,3,54);num55 = organizaNumeros(num55,10,3,55);
       num56 = organizaNumeros(num56,11,3,56);num57 = organizaNumeros(num57,12,3,57);num58 = organizaNumeros(num58,13,3,58);num59 = organizaNumeros(num59,14,3,59);num60 = organizaNumeros(num60,15,3,60);
       num61 = organizaNumeros(num61,1,4,61);num62 = organizaNumeros(num62,2,4,62);num63 = organizaNumeros(num63,3,4,63);num64 = organizaNumeros(num64,4,4,64);num65 = organizaNumeros(num65,5,4,65);
       num66 = organizaNumeros(num66,6,4,66);num67 = organizaNumeros(num67,7,4,67);num68 = organizaNumeros(num68,8,4,68);num69 = organizaNumeros(num69,9,4,69);num70 = organizaNumeros(num70,10,4,70);
       num71 = organizaNumeros(num71,11,4,71);num72 = organizaNumeros(num72,12,4,72);num73 = organizaNumeros(num73,13,4,73);num74 = organizaNumeros(num74,14,4,74);num75 = organizaNumeros(num75,15,4,75);
       
       principal.add(num1);principal.add(num2);principal.add(num3);principal.add(num4);principal.add(num5);
       principal.add(num6);principal.add(num7);principal.add(num8);principal.add(num9);principal.add(num10);
       principal.add(num11);principal.add(num12);principal.add(num13);principal.add(num14);principal.add(num15);
       principal.add(num16);principal.add(num17);principal.add(num18);principal.add(num19);principal.add(num20);
       principal.add(num21);principal.add(num22);principal.add(num23);principal.add(num24);principal.add(num25);
       principal.add(num26);principal.add(num27);principal.add(num28);principal.add(num29);principal.add(num30);
       principal.add(num31);principal.add(num32);principal.add(num33);principal.add(num34);principal.add(num35);
       principal.add(num36);principal.add(num37);principal.add(num38);principal.add(num39);principal.add(num40);
       principal.add(num41);principal.add(num42);principal.add(num43);principal.add(num44);principal.add(num45);
       principal.add(num46);principal.add(num47);principal.add(num48);principal.add(num49);principal.add(num50);
       principal.add(num51);principal.add(num52);principal.add(num53);principal.add(num54);principal.add(num55);
       principal.add(num56);principal.add(num57);principal.add(num58);principal.add(num59);principal.add(num60);
       principal.add(num61);principal.add(num62);principal.add(num63);principal.add(num64);principal.add(num65);
       principal.add(num66);principal.add(num67);principal.add(num68);principal.add(num69);principal.add(num70);
       principal.add(num71);principal.add(num72);principal.add(num73);principal.add(num74);principal.add(num75);
       
       cartelas = new TelaInternaSorteio(sorteio,path);
       cartelas.setSize(940,350);
       cartelas.setLocation(0, 330);
       principal.add(cartelas);
       pag.add(principal);
    }
    
    public JLabel organizaNumeros(JLabel x,int coluna,int linha,int imagem){
        x.setIcon(new ImageIcon(path+"/Numeros/"+imagem+".png")); 
        x.setSize(40,40);
        x.setLocation(240 + coluna*40,100 + linha*40);
        return x;
    }
    public void sorteia(){
        int x = 0;
        while(x == 0){
            x = sorteio.roleta();
        }
        
        if(x == 1)
            num1.setIcon(new ImageIcon(path+"/Numeros/1v.png"));
        if(x == 2)
            num2.setIcon(new ImageIcon(path+"/Numeros/2v.png"));
        if(x == 3)
            num3.setIcon(new ImageIcon(path+"/Numeros/3v.png"));
        if(x == 4)
            num4.setIcon(new ImageIcon(path+"/Numeros/4v.png"));
        if(x == 5)
            num5.setIcon(new ImageIcon(path+"/Numeros/5v.png"));
        if(x == 6)
            num6.setIcon(new ImageIcon(path+"/Numeros/6v.png"));
        if(x == 7)
            num7.setIcon(new ImageIcon(path+"/Numeros/7v.png"));
        if(x == 8)
            num8.setIcon(new ImageIcon(path+"/Numeros/8v.png"));
        if(x == 9)
            num9.setIcon(new ImageIcon(path+"/Numeros/9v.png"));
        if(x == 10)
            num10.setIcon(new ImageIcon(path+"/Numeros/10v.png"));
        if(x == 11)
            num11.setIcon(new ImageIcon(path+"/Numeros/11v.png"));
        if(x == 12)
            num12.setIcon(new ImageIcon(path+"/Numeros/12v.png"));
        if(x == 13)
            num13.setIcon(new ImageIcon(path+"/Numeros/13v.png"));
        if(x == 14)
            num14.setIcon(new ImageIcon(path+"/Numeros/14v.png"));
        if(x == 15)
            num15.setIcon(new ImageIcon(path+"/Numeros/15v.png"));
        if(x == 16)
            num16.setIcon(new ImageIcon(path+"/Numeros/16v.png"));
        if(x == 17)
            num17.setIcon(new ImageIcon(path+"/Numeros/17v.png"));
        if(x == 18)
            num18.setIcon(new ImageIcon(path+"/Numeros/18v.png"));
        if(x == 19)
            num19.setIcon(new ImageIcon(path+"/Numeros/19v.png"));
        if(x == 20)
            num20.setIcon(new ImageIcon(path+"/Numeros/20v.png"));
        if(x == 21)
            num21.setIcon(new ImageIcon(path+"/Numeros/21v.png"));
        if(x == 22)
            num22.setIcon(new ImageIcon(path+"/Numeros/22v.png"));
        if(x == 23)
            num23.setIcon(new ImageIcon(path+"/Numeros/23v.png"));
        if(x == 24)
            num24.setIcon(new ImageIcon(path+"/Numeros/24v.png"));
        if(x == 25)
            num25.setIcon(new ImageIcon(path+"/Numeros/25v.png"));
        if(x == 26)
            num26.setIcon(new ImageIcon(path+"/Numeros/26v.png"));
        if(x == 27)
            num27.setIcon(new ImageIcon(path+"/Numeros/27v.png"));
        if(x == 28)
            num28.setIcon(new ImageIcon(path+"/Numeros/28v.png"));
        if(x == 29)
            num29.setIcon(new ImageIcon(path+"/Numeros/29v.png"));
        if(x == 30)
            num30.setIcon(new ImageIcon(path+"/Numeros/30v.png"));
        if(x == 31)
            num31.setIcon(new ImageIcon(path+"/Numeros/31v.png"));
        if(x == 32)
            num32.setIcon(new ImageIcon(path+"/Numeros/32v.png"));
        if(x == 33)
            num33.setIcon(new ImageIcon(path+"/Numeros/33v.png"));
        if(x == 34)
            num34.setIcon(new ImageIcon(path+"/Numeros/34v.png"));
        if(x == 35)
            num35.setIcon(new ImageIcon(path+"/Numeros/35v.png"));
        if(x == 36)
            num36.setIcon(new ImageIcon(path+"/Numeros/36v.png"));
        if(x == 37)
            num37.setIcon(new ImageIcon(path+"/Numeros/37v.png"));
        if(x == 38)
            num38.setIcon(new ImageIcon(path+"/Numeros/38v.png"));
        if(x == 39)
            num39.setIcon(new ImageIcon(path+"/Numeros/39v.png"));
        if(x == 40)
            num40.setIcon(new ImageIcon(path+"/Numeros/40v.png"));
        if(x == 41)
            num41.setIcon(new ImageIcon(path+"/Numeros/41v.png"));
        if(x == 42)
            num42.setIcon(new ImageIcon(path+"/Numeros/42v.png"));
        if(x == 43)
            num43.setIcon(new ImageIcon(path+"/Numeros/43v.png"));
        if(x == 44)
            num44.setIcon(new ImageIcon(path+"/Numeros/44v.png"));
        if(x == 45)
            num45.setIcon(new ImageIcon(path+"/Numeros/45v.png"));
        if(x == 46)
            num46.setIcon(new ImageIcon(path+"/Numeros/46v.png"));
        if(x == 47)
            num47.setIcon(new ImageIcon(path+"/Numeros/47v.png"));
        if(x == 48)
            num48.setIcon(new ImageIcon(path+"/Numeros/48v.png"));
        if(x == 49)
            num49.setIcon(new ImageIcon(path+"/Numeros/49v.png"));
        if(x == 50)
            num50.setIcon(new ImageIcon(path+"/Numeros/50v.png"));
        if(x == 51)
            num51.setIcon(new ImageIcon(path+"/Numeros/51v.png"));
        if(x == 52)
            num52.setIcon(new ImageIcon(path+"/Numeros/52v.png"));
        if(x == 53)
            num53.setIcon(new ImageIcon(path+"/Numeros/53v.png"));
        if(x == 54)
            num54.setIcon(new ImageIcon(path+"/Numeros/54v.png"));
        if(x == 55)
            num55.setIcon(new ImageIcon(path+"/Numeros/55v.png"));
        if(x == 56)
            num56.setIcon(new ImageIcon(path+"/Numeros/56v.png"));
        if(x == 57)
            num57.setIcon(new ImageIcon(path+"/Numeros/57v.png"));
        if(x == 58)
            num58.setIcon(new ImageIcon(path+"/Numeros/58v.png"));
        if(x == 59)
            num59.setIcon(new ImageIcon(path+"/Numeros/59v.png"));
        if(x == 60)
            num60.setIcon(new ImageIcon(path+"/Numeros/60v.png"));
        if(x == 61)
            num61.setIcon(new ImageIcon(path+"/Numeros/61v.png"));
        if(x == 62)
            num62.setIcon(new ImageIcon(path+"/Numeros/62v.png"));
        if(x == 63)
            num63.setIcon(new ImageIcon(path+"/Numeros/63v.png"));
        if(x == 64)
            num64.setIcon(new ImageIcon(path+"/Numeros/64v.png"));
        if(x == 65)
            num65.setIcon(new ImageIcon(path+"/Numeros/65v.png"));
        if(x == 66)
            num66.setIcon(new ImageIcon(path+"/Numeros/66v.png"));
        if(x == 67)
            num67.setIcon(new ImageIcon(path+"/Numeros/67v.png"));
        if(x == 68)
            num68.setIcon(new ImageIcon(path+"/Numeros/68v.png"));
        if(x == 69)
            num69.setIcon(new ImageIcon(path+"/Numeros/69v.png"));
        if(x == 70)
            num70.setIcon(new ImageIcon(path+"/Numeros/70v.png"));
        if(x == 71)
            num71.setIcon(new ImageIcon(path+"/Numeros/71v.png"));
        if(x == 72)
            num72.setIcon(new ImageIcon(path+"/Numeros/72v.png"));
        if(x == 73)
            num73.setIcon(new ImageIcon(path+"/Numeros/73v.png"));
        if(x == 74)
            num74.setIcon(new ImageIcon(path+"/Numeros/74v.png"));
        if(x == 75)
            num75.setIcon(new ImageIcon(path+"/Numeros/75v.png"));
        
        if(sorteio.verificaCartelas(x)){
            cartelas.dispose();
            cartelas = new TelaInternaSorteio(sorteio,path);
            cartelas.setSize(940,350);
            cartelas.setLocation(0, 330);
            principal.add(cartelas);
            JOptionPane.showConfirmDialog(null," Parabéns " + sorteio.getVencedor() + "! Você ganhou!"," VITÓRIA !", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(path + "/Vitoria.png"));
            System.exit(0);
        }
    }
    public void movimenta(JLabel a){
        int x = new Random().nextInt(78) + 100;
	int y = new Random().nextInt(53) + 120;
        a.setLocation(x, y);
    }
    
    public void movimentaBolas(){
        if(controlaMovimento == true){
            movimenta(bolaAmarela);
            movimenta(bolaLaranja);
            movimenta(bolaRosa);
            movimenta(bolaVerde);
            movimenta(bolaVermelha);
            
        }
    }
    
    public void retornaPosicaoInicial(){
        
        bolaAmarela.setLocation(100,173);
        bolaLaranja.setLocation(125,193);
        bolaRosa.setLocation(160,194);
        bolaVerde.setLocation(122,174);
        bolaVermelha.setLocation(178,183);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botaoGirar){
            controlaMovimento = true;
            botaoGirar.setVisible(false);
            botaoParar.setVisible(true);
            movimentaBolas();
        }
        if(e.getSource() == botaoParar){
            controlaMovimento = false;
            botaoGirar.setVisible(true);
            botaoParar.setVisible(false);
            retornaPosicaoInicial();
            sorteia();
            cartelas.dispose();
            cartelas = new TelaInternaSorteio(sorteio,path);
            cartelas.setSize(940,330);
            cartelas.setLocation(0, 350);
            principal.add(cartelas);
        }
    }
    
}
