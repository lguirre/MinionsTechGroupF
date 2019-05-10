package com.tictactoe.minioms;

public class Player {
    private String name;
    private final char token ;

    public Player(String name, char token){
        this.name = name;
        this.token = token;
    }

    public String getName() {
        return this.name;
    }

    public char getToken(){
        return token;
    }
}
