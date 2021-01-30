/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

/**
 *
 * @author ketleen
 */

//classe jogador com nome de usuario e id

public class Jogador {
    
    private String userName ;
    private int id;
    
    public Jogador(String userName, int id) {
        this.userName = userName;
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
