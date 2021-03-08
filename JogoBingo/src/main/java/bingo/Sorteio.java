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

import inteface.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Mara de Lemos Gomes
 */

public class Sorteio {
    
    private  List<Jogador> jogadores;
    private List<Cartela> cartelas;
    private int[] numSorteados;
    private String vencedor;
    private String tipoCartela;
    private int qtdJogadores;
    private int qtdNumSorteados;
    
	/**
	 * Construtor da classe Sorteio
         * @param tipo Recebe se o jogo será iniciado como cartela cheia ou cartela linha/coluna
	 *
	 * @author Mara de Lemos Gomes
	 */
    public Sorteio(String tipo) {
        this.jogadores = new ArrayList<>();
        this.cartelas = new ArrayList<>();
	this.numSorteados = new int[75];
	this.vencedor = "";
        this.tipoCartela = tipo;
        this.qtdJogadores = 0;
        this.qtdNumSorteados = 0;
    }
    
    /**
     * Insere jogador no bingo
     * @param nome
     * 
     * @author Ary de Paula Canuto Neto
     */
    
    public void insereJogador(String nome){
        nome = nome.toUpperCase().trim();
        
        String nome1;
        int i;
        
        for(i = 0; i < jogadores.size(); i++){
            nome1 = jogadores.get(i).getUserName();
            nome1 = nome1.toUpperCase().trim();
            if(nome1.compareTo(nome) == 0){
                JOptionPane.showMessageDialog(null, "Esse nome já está sendo usado, tente outro.", "ERRO!", JOptionPane.ERROR_MESSAGE, null);
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
        }
		
		try{
            abrirArquivoParaEscrita(nome);
        }catch(IOException ex){
			//Não vai gerar a exceção pois a leitura do arquivo garante a existência dele
        }
    }
    
    public void RemoveJogador(int id) {

        if (id >= 0 && id < this.jogadores.size()) {
            jogadores.remove(id);
            cartelas.remove(id);
            this.qtdJogadores--;
        }else{
            JOptionPane.showConfirmDialog(null, " Jogador não existe ! ", " ERRO !" ,JOptionPane.DEFAULT_OPTION);
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
        
        for(i = 0; i < jogadores.size(); i++){
            if(jogadores.get(i).getUserName().compareTo(nome) == 0){
                JOptionPane.showConfirmDialog(null, " Nome já utilizado ! ", " ERRO !" ,JOptionPane.DEFAULT_OPTION);
                break;
            }
        }
        if(i == jogadores.size()){
            jogadores.get(id).setUserName(nome);
            JOptionPane.showConfirmDialog(null, " Nome alterado com Sucesso ! ", " SUCESSO !" ,JOptionPane.DEFAULT_OPTION);
        }
    }
    
    /**
     * Imprime o jogador da lista e sua cartela que corresponde ao indice recebido
     * 
     * @author Mara de Lemos Gomes
     */
    public String imprimeJogador(int indice){
        String aux = "";
        aux += cartelas.get(indice).imprimeCartela();
        aux += "<center>"+jogadores.get(indice).getUserName()+"<center>";
        return aux;
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
        BufferedReader arquivo = new BufferedReader(new FileReader("bancoDeDados/jogadores.txt"));
        String linha = "";
        while(true){
            if(linha != null){
                insereJogador(linha);
            }else{
                break;
            }
            linha = arquivo.readLine();
        }
        arquivo.close();
    }
	
    /**
     * Salva jogador no banco de dados
     * Pode gerar a exceção FileNotFoundException
     *
     * @author Thiago Goulart da Fonseca
     */
	public static void abrirArquivoParaEscrita(String nome) throws IOException{
        FileWriter fwArquivo;
        BufferedWriter bwArquivo;

       //Função leitura garante que arquivo existe, abrindo arquivo
            fwArquivo = new FileWriter("bancoDeDados/jogadores");
            bwArquivo = new BufferedWriter(fwArquivo);

            bwArquivo.append(nome + '\n');

		bwArquivo.close();
		fwArquivo.close();
    }
	
    public static void main(String[] args){
        
        /*
        try{
            sorteio1.leArquivo();
        }catch(IOException ex){
            JOptionPane.showConfirmDialog(null, "Banco de dados não encontrado! A aplicação será encerrada.", "ERRO!",JOptionPane.DEFAULT_OPTION);
            System.exit(0);
        }
        */
        TelaSorteio teste = new TelaSorteio();
    } 
}
