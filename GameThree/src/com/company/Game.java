package com.company;

public class Game {
    boolean winner = false;

    public Game() {

    }
    public void play(Player playerOne, Player playerTwo, Table table){
        for (int turnPlay = 1; turnPlay <= 9; turnPlay++) {
            if(turnPlay%2==0){
                playerTwo.putToken(table);
                winner = table.checkWinner(playerTwo);
            }else{
                playerOne.putToken(table);
                winner = table.checkWinner(playerOne);
            }
            table.drawThreeRow();
            if(winner){
                break;
            }
        }
        if(winner){
            System.out.println("You Win Out  :)!!!");
        }else{
            System.out.println("RETRY :( !!!");
        }
    }
}
