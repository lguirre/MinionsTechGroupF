package com.tictactoe.minioms;

public class Board {
    private char board[][];
    private char tokenWinner;
    private int turnsLeft;

    public Board(){
        this.board = new char[3][3];
        this.tokenWinner = ' ';
        this.turnsLeft = 9;
        this.tableOnBlanck();
    }

    public boolean stillOnPlay(){
        if(turnsLeft != 0)
            return true;
        return false;

    }

    public char getWinnerToken() {
        return tokenWinner;

    }

    //return true if was success the marked and false is was not success
    public boolean checkOffCell(int x, int y, char token){
        boolean market = false;
        if (turnsLeft > 0){
            if( board[x][y] ==' '){
                board[x][y] = token;
                turnsLeft--;
                market = true;
                boolean thereIsAWinner= reviewWinner(x, y, token);
                if(thereIsAWinner)
                {
                    tokenWinner = token;
                    this.turnsLeft = 0;
                }
            }
        }
        return market;

    }
    private boolean reviewWinner(int x, int y, char token){
        boolean thereIsAWinner = false;

        if (!thereIsAWinner){
            thereIsAWinner = reviewRow(x,y,token);
        }
        if (!thereIsAWinner){
            thereIsAWinner = reviewColumn(x,y,token);
        }
        if(!thereIsAWinner){
            // if the movement was in cells were is possible a diagonal review the diagonals
            if ((x+y !=1) && (x+y !=3)){
                thereIsAWinner = reviewDiagonals(token);
            }
        }
        return thereIsAWinner;

    }


    private boolean reviewDiagonals( char token ){
        // Checking for Diagonals for X or O victory.
        if (board[0][0]==board[1][1] && board[1][1]==board[2][2])
        {
            if (board[0][0]==token)
                return true;
            else if (board[0][0]==token)
                return false;
        }

        if (board[0][2]==board[1][1] && board[1][1]==board[2][0])
        {
            if (board[0][2]==token)
                return true;
            else if (board[0][2]==token)
                return false;
        }

        // Else if none of them have won then return 0
        return false;
    }

    private boolean reviewRow(int x, int y, char token){
        // Checking for Rows for X or O victory.
        for (int col = 0; col<3; col++) {
            if (board[0][col] == board[1][col] &&
                    board[1][col] == board[2][col]) {
                if (board[1][col] == token)
                    return true;
                else
                    return false;
            }
        }
        return false;
    }

    private boolean reviewColumn(int x,int y, char token){
        for (int row = 0; row<3; row++)
        {
            if (board[row][0]==board[row][1] &&
                    board[row][1]==board[row][2])
            {
                if (board[row][1]==token)
                    return true;
                else
                    return false;
            }
        }
        return false;
    }

    private void tableOnBlanck(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public char[][] getBoard(){
        return board;
    }
}