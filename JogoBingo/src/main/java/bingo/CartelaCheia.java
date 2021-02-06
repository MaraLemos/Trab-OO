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

/****************************************************************
 * Implementação dos atributos e métodos da classe CartelaCheia *
 ****************************************************************/
package bingo;

/**
 *
 * @author Mara de Lemos Gomes
 */
public class CartelaCheia extends Cartela{
    
    /**
    * Construtor da classe CartelaLinha
    * @param identificador
    * 
    * @author Mara de Lemos Gomes
    */
    public CartelaCheia(int identificador){
        id = identificador;
        numeros = new int[24];
        numMarcados = 0;
        iniciaCartela();
    }
    
    /**
    * Verifica se a cartela foi totalmente preenchida
    * @return boolean
    * 
    * @author Mara de Lemos Gomes
    */
    @Override
    protected boolean verificaVitoria() {
        return numMarcados == 24;
    }
}
