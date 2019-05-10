/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threeinarow.ui;
import threeinarow.Board;

/**
 *
 * @author veymarmc
 */
public class BoardConsoleUI implements BoardUI{
    Board board;
    
    public BoardConsoleUI() {
        this.board = new Board();
    }
    
    public void resetBoard() {
        this.board.resetBoard();
    }
    
    public boolean isGameOver() {
        return board.isGameOver();
    }
    
    public void showBoard() {
        String[][] config = this.board.getConfiguration();
        
        for (int i = 0; i < config.length; i++) {
            for (int j = 0; j < config[i].length; j++) {
                System.out.print(config[i][j] + " ");            
            }
            System.out.println("");
        }    
    }
    
    public boolean isValidOption(int option) {
        return this.board.isValidOption(option);
    }
    
    public boolean setMovement(int option, boolean turn) {
        return this.board.setMovement(option, turn);
    }
    
    public boolean isFull() {
        return this.board.isFull();
    }
}
