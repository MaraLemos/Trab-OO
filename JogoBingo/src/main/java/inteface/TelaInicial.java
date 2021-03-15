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
 *               Frame Inicial do jogo                     *
 ********************************************************** */
package inteface;

import bingo.Sorteio;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author Ketleen Anne Faria
 */
public class TelaInicial extends JFrame implements ActionListener, InterfaceTela {

    private final JPanel painelBingo;
    private final JLabel bingo;
    private final JButton jogadores;
    private final JButton configuracao;
    private final JButton iniciar;
    private Sorteio sorteio1;
    private static String path;
    private static TelaInicial telainicial;
    
    public TelaInicial() {
        this.painelBingo = new JPanel();
        this.bingo = new JLabel();
        this.jogadores = new JButton("Jogadores");
        this.configuracao = new JButton("Configuração");
        this.iniciar = new JButton("Iniciar");

        this.setTitle("Tela Inicial");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(960, 720);
        setLayout(null);
        setBackground(Color.white);
        setLocationRelativeTo(null);
        mostra();
        setVisible(true);
        setResizable(false);
    }

    @Override
    public void mostra() {

        //configura painelbingo
        this.painelBingo.setLayout(null);
        this.painelBingo.setSize(960, 720);
        this.painelBingo.setBackground(Color.getHSBColor(330,95,100));
        
        //configura bingo
        this.bingo.setIcon(new ImageIcon(path + "/TextoBingo.png"));
        this.bingo.setSize(499, 114);
        this.bingo.setLocation(252, 100);

        //configura botao jogadores
        jogadores.setIcon(new ImageIcon(path + "/Jogadores.png"));
        jogadores.setBackground(Color.black);
        jogadores.setSize(190, 178);

        jogadores.setBorderPainted(false);
        jogadores.setContentAreaFilled(false);
        jogadores.setFocusPainted(false);

        jogadores.setLocation(95, 450);
        jogadores.setVisible(false);

        jogadores.addActionListener(this);

        //configura botao configuracao
        configuracao.setIcon(new ImageIcon(path + "/Configuracoes.png"));
        configuracao.setBackground(Color.black);
        configuracao.setSize(190, 178);

        configuracao.setBorderPainted(false);
        configuracao.setContentAreaFilled(false);
        configuracao.setFocusPainted(false);

        configuracao.setLocation(390, 450);
        configuracao.setVisible(true);

        configuracao.addActionListener(this);

        //configura botao iniciar
        iniciar.setIcon(new ImageIcon(path + "/iniciar.png"));
        iniciar.setBackground(Color.black);
        iniciar.setSize(190, 178);

        iniciar.setBorderPainted(false);
        iniciar.setContentAreaFilled(false);
        iniciar.setFocusPainted(false);

        iniciar.setLocation(680, 450);
        iniciar.setVisible(false);

        iniciar.addActionListener(this);

        this.painelBingo.add(bingo);
        this.painelBingo.add(jogadores);
        this.painelBingo.add(configuracao);
        this.painelBingo.add(iniciar);
        add(this.painelBingo);

    }

    public static void main(String[] args) {
        
        JOptionPane.showMessageDialog(null,"Para começar selecione a pasta Resources");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = fileChooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            TelaInicial.path = file.getAbsolutePath();
			if(!(path.contains("Resource"))){
                JOptionPane.showMessageDialog(null,"A pasta resources não foi selecionada");
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(null,"A pasta resources não foi selecionada");
            System.exit(0);
        }

        telainicial = new TelaInicial();
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        String tipo = "";

        //açao botao jogadores
        if (a.getSource() == jogadores) {
            
            telainicial.setVisible(false);
            TelaJogadores addJogador = new TelaJogadores(sorteio1, path,telainicial);
    

        }

        //açao botao configuração
        if (a.getSource() == configuracao) {
            String opcoes[] = {"cheia", "linha"};
            Object showInputDialog = JOptionPane.showInputDialog(configuracao,"",
                    "Escolha o tipo de Cartela", JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon(path + "/ConfiguracoesIcon.png"), opcoes, opcoes[0]);
            tipo = showInputDialog.toString();

            sorteio1 = new Sorteio(path);
            sorteio1.setTipoCartela(tipo);

            jogadores.setVisible(true);
            iniciar.setVisible(true);
            configuracao.setVisible(false);

            try {
                sorteio1.leArquivo();
            } catch (IOException ex) {
                JOptionPane.showConfirmDialog(null, "Banco de dados não encontrado! A aplicação será encerrada.", "ERRO!", JOptionPane.DEFAULT_OPTION);
                System.exit(0);
            }
        }

        //açao botao iniciar
        if (a.getSource() == iniciar) {
            if (sorteio1.getQtdJogadores() < 2) {
                JOptionPane.showMessageDialog(null,"É necessário cadastrar jogadores", "ERRO !",JOptionPane.ERROR_MESSAGE, new ImageIcon(path + "/Erro.png"));
            } else {
                this.setVisible(false);
                TelaSorteio telaSorteio = new TelaSorteio(sorteio1, path);
            }
        }
    }

}
