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
public class MainUIConsole implements MainUI{
    private BoardUI boardUI;
    private boolean turn = false;
    
    public MainUIConsole() {
        this.boardUI = new BoardConsoleUI();
        
        this.executeMenuLogic(this::executeMainMenu);
    }
    
    private void executeMenuLogic(MenuExecutor menuExecutor) {
        boolean exit = false;
        
        while (!exit) {
            exit = menuExecutor.executeMenu();
        }
        
        System.out.println("thanks for playing!");
    }
    
    private boolean executeMainMenu() {
        boolean exit = false;
        
        this.showMainMenu();
        int option = ConsoleUIUtils.readOptionMenu(1,2);
        
        switch (option) {
            case 1 : this.play();
                break;
            case 2 : exit = true;
        }
        
        return exit;
    }
    
    private void showMainMenu() {
        String title = "Three On A Line";
        String options[] = {"1.- Play now!",
                            "2.- Exit"};
        ConsoleUIUtils.showMenu(title, options);
    }
    
    private void play() {
        this.executeMenuLogic(this::executePlayMenu);
    }
    
    private boolean executePlayMenu() {
        boolean exit = false;
        this.showPlayMenu();
        int option = ConsoleUIUtils.readOptionMenu(1,2);
        
        switch (option) {
            case 1 : 
                this.boardUI.resetBoard();
                this.executeMenuLogic(this::executeInitANewGame);
                break;
            case 2 : exit = true;
        }
        
        return exit;
    }
    
    private void showPlayMenu() {
        String title = "Three On A Line - Please choose an option";
        String options[] = {"1.- Init a new Game!",
                            "2.- Exit of the game"};
        ConsoleUIUtils.showMenu(title, options);
    }
    
    private boolean executeInitANewGame() {
        boolean exit = false;
        boolean finish = false;
        
        this.showMovementMenu();
        int option = ConsoleUIUtils.readOptionMenu(1,2);
        
        switch (option) {
            case 1 : finish = this.makeAMovement();
                break;
            case 2 : exit = true;
        }
        
        if(finish) {
            System.out.println("the Game has finished!");
        }
        
        return exit;
    }
    
    private void showMovementMenu() {
        String title = "Three On A Line - Make a movement - Please choose an option";
        String options[] = {"1.- Chose an option from 1-9 which is available",
                            "2.- Exit of the game"};
        ConsoleUIUtils.showMenu(title, options);
    }
    
    private boolean makeAMovement() {
        boolean gameOver = this.boardUI.isGameOver();
        if(!this.boardUI.isFull() && !gameOver) {
            boolean isValidOption = false;
            int movement = 0;
            this.boardUI.showBoard();

            while(!isValidOption) {
                movement = ConsoleUIUtils.readOptionMenu(1, 9);
                isValidOption = this.boardUI.isValidOption(movement);
            }
            this.turn = !this.turn;
            gameOver = this.boardUI.setMovement(movement, this.turn);       
            this.boardUI.showBoard();
        }
        
        return gameOver;
    }
}

interface MenuExecutor {
    public boolean executeMenu();
}
