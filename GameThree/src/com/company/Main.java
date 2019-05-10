package com.company;

public class Main {

    public static void main(String[] args) {

        Player playerOne= new Player("X");
        Player playerTwo= new Player();
        playerTwo.setToken("O");
        Table table = new Table();
        table.drawThreeRow();
        Game game = new Game();
        game.play(playerOne,playerTwo,table);

    }

}

