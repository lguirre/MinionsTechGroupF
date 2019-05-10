package com.tictactoe.minioms;

import java.util.Scanner;

public class GameInterface {
    private Scanner scanner;
    private TictactoeGame tictactoePlay;

    public GameInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Enter the Name first Player");
        String name1 = this.scanner.next();
        System.out.println("Enter the Name second Player");
        String name2 = this.scanner.next();
        System.out.println("Select number of games");
        int numberOfGames = this.scanner.nextInt();
        this.tictactoePlay = new TictactoeGame(name1,name2,numberOfGames);

        do {
            int x = getParamX();
            int y = getParamY();
            if(!tictactoePlay.checkOff(x, y)){
                System.out.println("invalid trow");
            }
            printTable();
            } while(this.tictactoePlay.onPlay());
        System.out.println(tictactoePlay.getTotalScore());

    }

    private void printTable() {
        char board[][] = tictactoePlay.getCurrentBoardOnPlay().getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int getParamX() {
        int paramX;
        try {
            System.out.println("insert the number of file");
            paramX = this.scanner.nextInt();
            if (paramX > 2)
                return getParamX();
            return paramX;
        } catch (Exception var2) {
            System.out.println("only is accepted numbers");
            return getParamX();
        }
    }

    private int getParamY() {
        int paramY;
        try {
            System.out.println("insert the number of column");
            paramY = this.scanner.nextInt();
            if (paramY > 2)
                return getParamY();
            return paramY;
        } catch (Exception var2) {
            System.out.println("only is accepted numbers");
            return getParamX();
        }
    }
}
