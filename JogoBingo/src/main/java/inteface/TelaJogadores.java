/** **********************************************************
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
 *********************************************************** */
/** *********************************************************
 *         Implementação da tela de jogadores              *
 ********************************************************** */
package inteface;

import bingo.Jogador;
import bingo.Sorteio;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author ketleen
 * @param
 */
public class TelaJogadores extends JFrame implements ActionListener, InterfaceTela {

    private JLabel imagemJogadores;
    private final JPanel painelJogadores;
    private JButton addJogador;
    private JButton voltar;
    private String path;
    private TelaInicial telainicial;
	
   // private JPanel painelAddJogadores; //colocar um JoptionPane
    private Jogador jogador;
    private Sorteio sorteio;

    public TelaJogadores(Sorteio sorteio,String path, TelaInicial telainicial) {
        
        this.telainicial = telainicial;
	this.path = path;
        this.painelJogadores = new JPanel();
        this.imagemJogadores = new JLabel();
        this.addJogador = new JButton();
        this.voltar = new JButton();
        //  this.painelAddJogadores = new JPanel(); //colocar um JoptionPane
        this.sorteio = sorteio;
        
        //Configura a JFrame
        this.setTitle("Jogadores");
        this.setSize(960, 720);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.white);
        mostra();
    }

    @Override
    public void mostra() {


        //configura imagemJogadores
        this.imagemJogadores.setIcon(new ImageIcon(path+"/TextoJogadores.png"));
        this.imagemJogadores.setSize(392, 82);
        this.imagemJogadores.setLocation(284, 100);
        
        
        //configura PainelJogadores
        this.painelJogadores.setSize(960, 720);
        this.painelJogadores.setLayout(null);
        this.painelJogadores.add(imagemJogadores);
        this.painelJogadores.setBackground(Color.white);
        
        addJogador.setIcon(new ImageIcon(path+"/BotaoMais.png"));
        addJogador.setBackground(Color.white);
        addJogador.setSize(82, 82);
        addJogador.setLocation(800, 100);
        addJogador.setVisible(true);
        addJogador.setBorderPainted(false); 
        addJogador.setContentAreaFilled(false); 
        addJogador.setFocusPainted(false);
        addJogador.addActionListener(this);
        
        voltar.setIcon(new ImageIcon(path+"/BotaoVoltar.png"));
        voltar.setBackground(Color.white);
        voltar.setSize(82, 82);
        voltar.setLocation(50, 100);
        voltar.setVisible(true);
        voltar.setBorderPainted(false); 
        voltar.setContentAreaFilled(false); 
        voltar.setFocusPainted(false);
        voltar.addActionListener(this);
        
        this.painelJogadores.add(addJogador);
        this.painelJogadores.add(voltar);
        
        
        
        //verifica qtd de jogadores
        if (sorteio.getQtdJogadores() == 0) {

        }
        this.add(this.painelJogadores);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if(a.getSource() == voltar ){
            telainicial.setVisible(true);
            this.dispose();
        }
        if(a.getSource() == addJogador){
            if(sorteio.getQtdJogadores() < 4){
                String nome;
                nome = JOptionPane.showInputDialog(null,"Digite um username: ", "Adicionando novo jogador",JOptionPane.QUESTION_MESSAGE);
                sorteio.insereJogador(nome,"tela");
            }else{
                JOptionPane.showConfirmDialog(null, "A quantidade máxima de jogadores foi atingida", " PARE !" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon(path + "/pare.png"));
            }
        }
    }

}
