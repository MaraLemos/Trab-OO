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
    private JButton[] excluir;
    private JButton[] editar;
    private String path;
    private TelaInicial telainicial;
    private JLabel nomes;   
	
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
        this.sorteio = sorteio;
        excluir = new JButton[4];
        editar = new JButton[4];
        
        //Configura a JFrame
        this.setTitle("Jogadores");
        this.setSize(960, 720);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.white);
        this.setResizable(false);
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
        
        int j = 250;
        for(int i = 0; i < sorteio.getQtdJogadores(); i++){
            JLabel label = new JLabel(sorteio.retornaNomeJogador(i));
           
            excluir[i] = new JButton();
            editar[i] = new JButton();
            
            excluir[i].setIcon(new ImageIcon(path+"/BotaoExcluir.png"));
            excluir[i].setBackground(Color.white);
            excluir[i].setSize(30, 30);
            excluir[i].setLocation(642, j);
            excluir[i].setVisible(true); 
            excluir[i].setBorderPainted(false); 
            excluir[i].setContentAreaFilled(false); 
            excluir[i].setFocusPainted(false);
            excluir[i].addActionListener(this);
            
            editar[i].setIcon(new ImageIcon(path+"/BotaoEditar.png"));
            editar[i].setBackground(Color.white);
            editar[i].setSize(30, 30);
            editar[i].setLocation(592, j);
            editar[i].setVisible(true); 
            editar[i].setBorderPainted(false); 
            editar[i].setContentAreaFilled(false); 
            editar[i].setFocusPainted(false);
            editar[i].addActionListener(this);
           
            label.setLocation(300, j);
            label.setSize(120, 30);
            label.setVisible(true);
            
            this.painelJogadores.add(label);
            this.painelJogadores.add(excluir[i]);
            this.painelJogadores.add(editar[i]);
            j += 100;
        }
        
        
        this.painelJogadores.add(addJogador);
        this.painelJogadores.add(voltar);
        
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
                if(nome != null){
                    sorteio.insereJogador(nome,"tela");
                    TelaJogadores nova = new TelaJogadores(sorteio,path,telainicial);
                    this.dispose();
                }
            }else{
                JOptionPane.showConfirmDialog(null, "A quantidade máxima de jogadores foi atingida", " PARE !" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon(path + "/pare.png"));
            }
        }
        if(a.getSource() == excluir[0]){
            if(sorteio.getQtdJogadores() > 0){
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja remover este jogador?", "Removendo um jogador", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(opcao == 0){
                    sorteio.removeJogador(0);
                    TelaJogadores nova = new TelaJogadores(sorteio,path,telainicial);
                    this.dispose();
                }
                
            }
            else{
                JOptionPane.showConfirmDialog(null, "Não há jogadores!", " PARE !" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon(path + "/pare.png"));
            }
        }
        if(a.getSource() == excluir[1]){
            if(sorteio.getQtdJogadores() > 0){
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja remover este jogador?", "Removendo um jogador", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(opcao == 0){
                    sorteio.removeJogador(1);
                    TelaJogadores nova = new TelaJogadores(sorteio,path,telainicial);
                    this.dispose();
                }
                
            }
            else{
                JOptionPane.showConfirmDialog(null, "Não há jogadores!", " PARE !" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon(path + "/pare.png"));
            }
        }
        if(a.getSource() == excluir[2]){
            if(sorteio.getQtdJogadores() > 0){
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja remover este jogador?", "Removendo um jogador", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(opcao == 0){
                    sorteio.removeJogador(2);
                    TelaJogadores nova = new TelaJogadores(sorteio,path,telainicial);
                    this.dispose();
                }
                
            }
            else{
                JOptionPane.showConfirmDialog(null, "Não há jogadores!", " PARE !" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon(path + "/pare.png"));
            }
        }
        if(a.getSource() == excluir[3]){
            if(sorteio.getQtdJogadores() > 0){
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja remover este jogador?", "Removendo um jogador", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(opcao == 0){
                    sorteio.removeJogador(3);
                    TelaJogadores nova = new TelaJogadores(sorteio,path,telainicial);
                    this.dispose();
                }
                
            }
            else{
                JOptionPane.showConfirmDialog(null, "Não há jogadores!", " PARE !" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon(path + "/pare.png"));
            }
        }
        
        if(a.getSource() == editar[0]){
            if(sorteio.getQtdJogadores() > 0){
                String nome = JOptionPane.showInputDialog(null,"Digite um username: ", "Editando um jogador",JOptionPane.QUESTION_MESSAGE);
                if(nome != null){
                    sorteio.editaJogador(nome, 0);
                    TelaJogadores nova = new TelaJogadores(sorteio,path,telainicial);
                    this.dispose();
                }
            }
        }
        if(a.getSource() == editar[1]){
            if(sorteio.getQtdJogadores() > 0){
                String nome = JOptionPane.showInputDialog(null,"Digite um username: ", "Editando um jogador",JOptionPane.QUESTION_MESSAGE);
                if(nome != null){
                    sorteio.editaJogador(nome, 1);
                    TelaJogadores nova = new TelaJogadores(sorteio,path,telainicial);
                    this.dispose();
                }
                
            }
        }
        if(a.getSource() == editar[2]){
            if(sorteio.getQtdJogadores() > 0){
                String nome = JOptionPane.showInputDialog(null,"Digite um username: ", "Editando um jogador",JOptionPane.QUESTION_MESSAGE);
                if(nome != null){
                    sorteio.editaJogador(nome, 2);
                    TelaJogadores nova = new TelaJogadores(sorteio,path,telainicial);
                    this.dispose();
                }
            }
        }
        if(a.getSource() == editar[3]){
            if(sorteio.getQtdJogadores() > 0){
                String nome = JOptionPane.showInputDialog(null,"Digite um username: ", "Editando um jogador",JOptionPane.QUESTION_MESSAGE);
                if(nome != null){
                    sorteio.editaJogador(nome, 3);
                    TelaJogadores nova = new TelaJogadores(sorteio,path,telainicial);
                    this.dispose();
                }
            }
        }
        
    }

}
