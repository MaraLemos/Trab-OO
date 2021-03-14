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
    private JButton excluir;
    private JButton editar;
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
        this.excluir = new JButton();
        this.editar = new JButton();

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
        
        excluir.setIcon(new ImageIcon(path+"/BotaoExcluir.png"));
        excluir.setBackground(Color.white);
        excluir.setSize(82, 82);
        excluir.setLocation(800, 500);
        excluir.setVisible(true); 
        excluir.setBorderPainted(false); 
        excluir.setContentAreaFilled(false); 
        excluir.setFocusPainted(false);
        excluir.addActionListener(this);
        
        editar.setIcon(new ImageIcon(path+"/BotaoEditar.png"));
        editar.setBackground(Color.white);
        editar.setSize(82, 82);
        editar.setLocation(50, 500);
        editar.setVisible(true); 
        editar.setBorderPainted(false); 
        editar.setContentAreaFilled(false); 
        editar.setFocusPainted(false);
        editar.addActionListener(this);
        
        this.painelJogadores.add(addJogador);
        this.painelJogadores.add(voltar);
        this.painelJogadores.add(excluir);
        this.painelJogadores.add(editar);
        
        
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
                if(nome != null){
                    sorteio.insereJogador(nome,"tela");
                }
            }else{
                JOptionPane.showConfirmDialog(null, "A quantidade máxima de jogadores foi atingida", " PARE !" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon(path + "/pare.png"));
            }
        }
        if(a.getSource() == excluir){
            if(sorteio.getQtdJogadores() > 0){
                int opcao = JOptionPane.showConfirmDialog(null, "Você irá excluir o último jogador a ser inserido, tem certeza que deseja remover?", "Removendo um jogador", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(opcao == 0){
                    sorteio.removeJogador(sorteio.getQtdJogadores() - 1);
                }
            }
            else{
                JOptionPane.showConfirmDialog(null, "Não há jogadores!", " PARE !" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon(path + "/pare.png"));
            }
        }
        if(a.getSource() == editar){
            String id0, id1 = "1", id2 = "2", id3 = "3", id4 = "4";
            if(sorteio.getQtdJogadores() > 0){
                id0 = JOptionPane.showInputDialog(null,"Qual jogador voce quer editar o nome? 1, 2, 3 ou 4: ", "Editando um jogador",JOptionPane.QUESTION_MESSAGE);
                if(id0.equals(id1))
                {
                    int id5 = Integer.parseInt(id1);
                    String nome = JOptionPane.showInputDialog(null,"Digite um username: ", "Editando um jogador",JOptionPane.QUESTION_MESSAGE);
                    sorteio.editaJogador(nome, id5 - 1);
                }
                else if(id0.equals(id2))
                {
                    int id5 = Integer.parseInt(id2);
                    String nome = JOptionPane.showInputDialog(null,"Digite um username: ", "Editando um jogador",JOptionPane.QUESTION_MESSAGE);
                    sorteio.editaJogador(nome, id5 - 1);
                }
                else if(id0.equals(id3))
                {
                    int id5 = Integer.parseInt(id3);
                    String nome = JOptionPane.showInputDialog(null,"Digite um username: ", "Editando um jogador",JOptionPane.QUESTION_MESSAGE);
                    sorteio.editaJogador(nome, id5 - 1);
                }
                else if(id0.equals(id4))
                {
                    int id5 = Integer.parseInt(id4);
                    String nome = JOptionPane.showInputDialog(null,"Digite um username: ", "Editando um jogador",JOptionPane.QUESTION_MESSAGE);
                    sorteio.editaJogador(nome, id5 - 1);
                }
            }
            else{
                JOptionPane.showConfirmDialog(null, "Não há jogadores!", " PARE !" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon(path + "/pare.png"));
            }
        }
    }

}
