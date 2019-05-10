/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threeinarow.ui;

/**
 *
 * @author veymarmc
 */
public interface BoardUI {    
    public void showBoard();
    
    public boolean isValidOption(int option);
    
    public boolean setMovement(int option, boolean turn);
    
    public boolean isFull();
    
    public void resetBoard();
    
    public boolean isGameOver();
}
