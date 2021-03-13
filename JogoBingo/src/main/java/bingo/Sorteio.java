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
 * Implementação dos atributos e métodos da classe Sorteio *
 ***********************************************************/
 
package bingo;

import java.util.*;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;

/**
 *
 * @author Mara de Lemos Gomes
 */

public class Sorteio {
    
    private final  List<Jogador> jogadores;
    private final List<Cartela> cartelas;
    private final int[] numSorteados;
    private String vencedor;
    private String tipoCartela;

    private int qtdJogadores;
    private int qtdNumSorteados;
    private String path;
    /**
     * Construtor da classe Sorteio
     *
     * @author Mara de Lemos Gomes
     * @param path //Caminho do arquivo que contem os jogadores
     */
    public Sorteio(String path){
        this.path = path;
        this.jogadores = new ArrayList<>();
        this.cartelas = new ArrayList<>();
	this.numSorteados = new int[75];
	this.vencedor = "";
        this.tipoCartela = "cheia";
        this.qtdJogadores = 0;
        this.qtdNumSorteados = 0;
    }
    
    /**
     * Modifica o tipo de jogo do Bingo
     * @param tipo
     * 
     * @author Ketleen Anne Faria
     */
    public void setTipoCartela(String tipo) {
        this.tipoCartela = tipo;
    }
    
    /**
     * Insere jogador no bingo
     * @param nome
     * @param pai //Recebe quem está chamando a função
     * 
     * @author Ary de Paula Canuto Neto
     */ 
    public void insereJogador(String nome, String pai){
        
        if(jogadores.size() < 4){
            nome = nome.toUpperCase().trim();
        
            String nome1;
            int i;

            for(i = 0; i < jogadores.size(); i++){
                nome1 = jogadores.get(i).getUserName();
                nome1 = nome1.toUpperCase().trim();
                if(nome1.compareTo(nome) == 0){
                    JOptionPane.showConfirmDialog(null, "Esse nome já está sendo usado, tente outro.", " ERRO !" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon(path + "/Erro.png"));
                    break;
                }
            }

            if(i == jogadores.size()){
                Jogador aux = new Jogador(nome);
                jogadores.add(aux);

                if(tipoCartela.compareTo("cheia") == 0){
                    cartelas.add(new CartelaCheia(aux.getCartelaAssoc()));
                }
                else{
                    cartelas.add(new CartelaLinha(aux.getCartelaAssoc()));
                }

                this.qtdJogadores++;

                if(pai.compareTo("arquivo") != 0){
                    try{
                        abrirArquivoParaEscrita(nome);
                    }catch(IOException ex){
                        //Não vai gerar a exceção pois a leitura do arquivo garante a existência dele
                    }
                }
            }
        }else{
            JOptionPane.showConfirmDialog(null, "A quantidade máxima de jogadores foi atingida", " PARE !" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon(path + "/pare.png"));
        }
    }
    
    /**
     * Remove jogador do bingo
     * @param id
     * 
     * @author Thiago Goulart da Fonseca
     */ 
    public void RemoveJogador(int id) {

        if (id >= 0 && id < this.jogadores.size()) {
            jogadores.remove(id);
            cartelas.remove(id);
            this.qtdJogadores--;
            atualizaBD();
        }else{
            JOptionPane.showConfirmDialog(null, " Jogador não existe ! ", " ERRO !" ,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(path + "/Erro.png"));
        }
    }
    
    /**
    * Edita o nome do jogador na lista de jogadores
    * 
    * @author Thiago Goulart da Fonseca
    * @param nome
    * @param id
    */
    
    public void editaJogador(String nome ,int id){
        int i;
        nome = nome.toUpperCase().trim();
        
        for(i = 0; i < jogadores.size(); i++){
            if(jogadores.get(i).getUserName().compareTo(nome) == 0){
                JOptionPane.showConfirmDialog(null, " Nome já utilizado ! ", " ERRO !" ,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(path + "/Erro.png"));
                break;
            }
        }
        if(i == jogadores.size()){
            jogadores.get(id).setUserName(nome);
            JOptionPane.showConfirmDialog(null, " Nome alterado com Sucesso ! ", " SUCESSO !", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(path + "/blz.png"));
            atualizaBD();
        }
    }
    
    
    /**
     * Retorna a quatidade de jogadores na lista
     * @return qtdJogadores
     * 
     * @author Mara de Lemos Gomes 
     */
    public int getQtdJogadores(){
        return qtdJogadores;
    }
    
    /**
     * sorteia os numeros para o bingo
     * 
     * @author Ary de Paula Canuto Neto
     * @return int //Retorna o numero sorteado
     */
    public int roleta(){
        int i;
	Random random = new Random();
	int numero = random.nextInt(75) + 1;
        
        //Verifica se um número já foi sorteado
        for(i=0; i < qtdNumSorteados; i++){
            if(numSorteados[i] == numero){
                return 0; //Numero já foi sorteado
            }
        }
        
        //Vetor foi todo percorrido e o número não está vetor
        numSorteados[qtdNumSorteados] = numero;
        qtdNumSorteados++;
            
        return numero;
    }
    
    /**
     * Verifica se o número sorteado está em alguma cartela
     * 
     * @author Mara de Lemos Gomes
     * @return boolean //Retorn true caso haja um vendedor e false caso contrário
     */
    public boolean verificaCartelas(int numero){
        if(numero == 0)
            return false;
        
         //marca o numero e checa se a cartela cumpre os requisitos para ganhar o jogo
            for(int j = 0; j < cartelas.size(); j++){
                cartelas.get(j).marcaNum(numero);
                if(cartelas.get(j).verificaVitoria() == true){
                    vencedor = jogadores.get(j).getUserName();
                    return true;
                }
            }
        return false;
    }
    
    /**
     * Retorna o id do Jogador vencedor, ou -1 se não existe um vencedor
     * @return vencedor
     *
     * @author Mara de Lemos Gomes
     */
    public String getVencedor(){
	return vencedor;
    }
    
    /**
     * Faz a leitura do arquivo txt que possui userNames de jogadores e os adiciona ao sorteio
     * Pode gerar a exceção FileNotFoundException
     *
     * @author Mara de Lemos Gomes
     */
    public void leArquivo() throws IOException{
        BufferedReader arquivo = new BufferedReader(new FileReader(path+"/bancoDeDados/jogadores.txt"));
        String linha = "";
        
        //Enquanto houver mais linhas
        while(arquivo.ready()){
            linha = arquivo.readLine();
            
            if(linha != null && linha != ""){
                insereJogador(linha,"arquivo");
            }
        }
        arquivo.close();
    }
	
    /**
     * Salva jogador no banco de dados
     * Pode gerar a exceção FileNotFoundException
     * @param nome
     *
     * @author Thiago Goulart da Fonseca
     */
    public void abrirArquivoParaEscrita(String nome) throws IOException{
        FileWriter fwArquivo;
        BufferedWriter bwArquivo;
       //Função leitura garante que arquivo existe, abrindo arquivo, passando true para acrescentar dados e não substituir
        fwArquivo = new FileWriter(path+"/bancoDeDados/jogadores.txt",true);
        bwArquivo = new BufferedWriter(fwArquivo);

        bwArquivo.write(nome);
        bwArquivo.newLine();
            
	bwArquivo.close();
        fwArquivo.close();
    }
    
    /**
     * Atualiza arquivo em caso de exclusão ou alteração de um jogador
     *
     *
     * @author Mara de Lemos Gomes
     */
    public void atualizaBD(){
        try{
            FileWriter arquivo = new FileWriter(path+"/bancoDeDados/jogadores.txt",false);
            BufferedWriter bwArquivo = new BufferedWriter(arquivo);
            String nome = "";
            for(int i = 0; i < jogadores.size(); i++){
                nome = jogadores.get(i).getUserName();
                bwArquivo.write(nome);
                bwArquivo.newLine();
            }

            bwArquivo.close();
            arquivo.close();
        
        }catch(IOException ex){
            //Leitura de arquivo garante que arquivo existe
        }
    }
    
    /**
     * Retorna a cartela do id recebido
     *
     * @author Mara de Lemos Gomes
     * @param i
     * @return vetor de números
     */
    public int[] retornaCartela(int i){
        return cartelas.get(i).getNumeros();
    }
    
    /**
     * Retorna nome do jogador do id recebido
     *
     * @author Mara de Lemos Gomes
     * @param i
     * @return nome
     */
    public String retornaNomeJogador(int i){
        return jogadores.get(i).getUserName();
    }
}
