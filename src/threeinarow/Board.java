/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threeinarow;

/**
 *
 * @author veymarmc
 */
public class Board {
    private String [][] board;
    private boolean gameOver;
    public Board () {
        this.board = new String[3][3];
        
        this.resetBoard();
    }
    
    public void resetBoard() {        
        int position = 0;
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                this.board[i][j] = (++position) + "";            
            }
            System.out.println(' ');
        }
        
        gameOver = false;
    }
    
    public boolean isGameOver() {
        return this.gameOver;
    }
    
    public String[][] getConfiguration() {
        return this.board;
    }
    
    public boolean isFull() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if(!this.board[i][j].equals("O") || this.board[i][j].equals("X")) {
                    return false;
                }
            }
        }
                
        return true;
    }
    
    public boolean isValidOption(int option) {
        boolean isValid = false;
        int position = 0;
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                position++;
                if(position == option){
                    isValid = !this.board[i][j].equals("X") || !this.board[i][j].equals("Y");
                }
            }
        }
        
        return isValid;
    }
    
    public boolean setMovement(int option, boolean turn) {
        int position = 0;
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                position++;
                if(position == option){
                    this.board[i][j] = turn ? "X" : "O";
                    if(this.verifyState(i, j)) {
                        this.gameOver = true;
                        return this.gameOver;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean verifyState(int i, int j) {
        String position = i + "" + j;
        boolean diagonal = false;
        boolean isDiagonal = false;
        int digI = 0, digJ = 0;
        
        
        switch (position) {
            case "00" :
                digI = 2;
                digJ = 2;
                isDiagonal = true;
                break;
            case "02" :
                digI = 2;
                digJ = 0;
                isDiagonal = true;
                break;
            case "20" :
                digI = 0;
                digJ = 2;
                isDiagonal = true;
                break;
            case "22" :
                digI = 0;
                digJ = 0;
                isDiagonal = true;
                break;
            case "11" :
                digI = 0;
                digJ = 0;
                diagonal = this.verifyDiagonal(i, j);
                break;
        }
        
        if(isDiagonal){
            diagonal = this.verifyDiagonal(i, j, digI, digJ);
        }
        
        return diagonal || this.verifyVertical(j) || this.verifyHorizontal(i);
    }
    
    private boolean verifyDiagonal(int i, int j) {
        return (this.board[i][j].equals(this.board[0][0]) &&
                this.board[0][0].equals(this.board[2][2])) ||
                (this.board[i][j].equals(this.board[2][0]) &&
                this.board[0][2].equals(this.board[2][0]));
    }
    
    private boolean verifyDiagonal(int i, int j, int digI, int digJ) {
        return this.board[i][j].equals(this.board[digI][digJ]) &&
                this.board[digI][digJ].equals(this.board[1][1]);
    }
    
    private boolean verifyVertical(int j) {
        return this.board[0][j].equals(this.board[1][j]) &&
                this.board[1][j].equals(this.board[2][j]);
    }
    
    private boolean verifyHorizontal(int i) {
        return this.board[i][0].equals(this.board[i][1]) &&
                this.board[i][1].equals(this.board[i][2]);
    }
}
