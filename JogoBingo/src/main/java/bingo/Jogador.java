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
 * Implementação dos atributos e métodos da classe Jogador *
 ***********************************************************/
 
package bingo;

/**
 *
 * @author Ketleen Anne Faria
 */

public class Jogador {
    
    private String userName ;
    private static int geraId = 1;
    private final int id;
    private int cartelaAssoc;
	
	/**
	 * Construtor da classe Jogador
	 * @param userName
	 * @param id
	 *
	 * @author Ketleen Anne Faria
	 */
    public Jogador(String userName) {
        this.userName = userName;
        this.id = geraId++;   
        this.cartelaAssoc = id;
    }
	
	/**
    * Retorna UserName de Jogador
    * @return userName
    * 
    * @author Ketleen Anne Faria
    */
    public String getUserName() {
        return userName;
    }

	/**
    * Modifica UserName de Jogador
    * @param userName
    * 
    * @author Ketleen Anne Faria
    */
    public void setUserName(String userName) {
        this.userName = userName;
    }

	/**
    * Retorna Id de Jogador
    * @return id
    * 
    * @author Ketleen Anne Faria
    */
    public int getId() {
        return id;
    }
    
    /**
    * Retorna o id da cartela associada ao Jogador
    * @return cartelaAssoc
    * 
    * @author Mara de Lemos Gomes
    */
    public int getCartelaAssoc() {
        return cartelaAssoc;
    }
}
