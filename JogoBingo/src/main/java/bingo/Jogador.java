/************************************************************
 * Universidade Federal de Juiz de Fora - UFJF              *
 * Instituto de Ciências Exatas                             *
 * Departamento de Ciência da Computação                    *
 * Disciplina: DCC025 – Orientação a Objetos - 2020.3       *
 * Professor: Gleiph Ghiotto Lima de Menezes                *
 * Aluno(s): Ary de Paula Canuto Neto                       *
 *           Ketleen Anne Faria                             *
 *           Mara de Lemos Gomes                            *
 *           Thiago Goulart da Fonseca                      *
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
    private int id;
    private static int cartelaAssoc;
	
	/**
	 * Construtor da classe Jogador
	 * @param userName
	 * @param id
	 *
	 * @author Ketleen Anne Faria
	 */
    public Jogador(String userName, int id) {
        this.userName = userName;
        this.id = id;   
        this.cartelaAssoc = id;
    }
	
	/**
    * Retorna UserName de Jogador
    * 
    * @author Ketleen Anne Faria
    */
    public String getUserName() {
        return userName;
    }

	/**
    * Modifica UserName de Jogador
    * 
    * @author Ketleen Anne Faria
    */
    public void setUserName(String userName) {
        this.userName = userName;
    }

	/**
    * Retorna Id de Jogador
    * 
    * @author Ketleen Anne Faria
    */
    public int getId() {
        return id;
    }
}
