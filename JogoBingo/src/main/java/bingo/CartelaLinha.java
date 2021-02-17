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

/****************************************************************
 * Implementação dos atributos e métodos da classe CartelaLinha *
 ****************************************************************/
package bingo;

/**
 *
 * @author Mara de Lemos Gomes
 */
public class CartelaLinha extends Cartela{
    
    /**
    * Construtor da classe CartelaLinha
    * @param identificador
    * 
    * @author Mara de Lemos Gomes
    */
    public CartelaLinha(int identificador){
        id = identificador;
        numeros = new int[24];
        numMarcados = 0;
        iniciaCartela();
    }

    /**
    * Verifica se uma das linhas ou colunas da cartela foram preenchidas
    * @return boolean
    * 
    * @author Mara de Lemos Gomes
    */
    @Override
    protected boolean verificaVitoria() {
        
        //Verifica se a coluna "B" foi marcada
        if(numeros[0] < 0 && numeros[1] < 0 && numeros[2] < 0 && numeros[3] < 0 && numeros[4] < 0)
            return true;
        
        //Verifica se a coluna "I" foi marcada
        else if(numeros[5] < 0 && numeros[6] < 0 && numeros[7] < 0 && numeros[8] < 0 && numeros[9] < 0)
            return true;
        
        //Verifica se a coluna "N" foi marcada
        else if(numeros[10] < 0 && numeros[11] < 0 && numeros[12] < 0 && numeros[13] < 0)
            return true;
        
        //Verifica se a coluna "G" foi marcada
        else if(numeros[14] < 0 && numeros[15] < 0 && numeros[16] < 0 && numeros[17] < 0 && numeros[18] < 0)
            return true;
        
        //Verifica se a coluna "O" foi marcada
        else if(numeros[19] < 0 && numeros[20] < 0 && numeros[21] < 0 && numeros[22] < 0 && numeros[23] < 0)
            return true;
        
        //Verifica se a linha 1 foi marcada
        else if(numeros[0] < 0 && numeros[5] < 0 && numeros[10] < 0 && numeros[14] < 0 && numeros[19] < 0)
            return true;
        
        //Verifica se a linha 2 foi marcada
        else if(numeros[1] < 0 && numeros[6] < 0 && numeros[11] < 0 && numeros[15] < 0 && numeros[20] < 0)
            return true;
        
        //Verifica se a linha 3 foi marcada
        else if(numeros[2] < 0 && numeros[7] < 0 && numeros[16] < 0 && numeros[21] < 0)
            return true;
        
        //Verifica se a linha 4 foi marcada
        else if(numeros[3] < 0 && numeros[8] < 0 && numeros[12] < 0 && numeros[17] < 0 && numeros[22] < 0)
            return true;
        
        //Verifica se a linha 5 foi marcada
        else if(numeros[4] < 0 && numeros[9] < 0 && numeros[13] < 0 && numeros[18] < 0 && numeros[23] < 0)
            return true;
        
        //Caso nenhuma das opções tenham sido marcadas
        return false;
    }
}
