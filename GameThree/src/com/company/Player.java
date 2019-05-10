package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Player {

    private String token;
    public Player() {
    }
    public Player(String ficha) {
        this.token = ficha;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void putToken(Table table){
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader (isr);
            System.out.print("Selection the Row   : ");
            int row = Integer.parseInt(br.readLine());
            System.out.print("Selection the Column: ");
            int column = Integer.parseInt(br.readLine());
            table.getThreeRowTablero()[row][column] = "   "+this.getToken();
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
