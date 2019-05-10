package com.tictactoe.minioms;

public class TictactoeGame {
    private Board boards [];
    private Player player1;
    private Player player2;
    private int quantityOfGamesLeft;
    private Player currentPlayer;

    public TictactoeGame(String player1Name, String player2Name, int numberOfGames){
        this.player1 = new Player(player1Name ,'X');
        this.player2 = new Player(player2Name, 'O');
        this.boards = new Board[numberOfGames];
        this.createBoards(numberOfGames);
        this.quantityOfGamesLeft  = numberOfGames -1;
        this.currentPlayer = player1;
    }

    public String getTotalScore(){
        char player1Token = player1.getToken();
        char player2Token = player2.getToken();
        int player1Score = 0;
        int player2Score = 0;
        for (int i = 0; i < boards.length; i++) {
            if (player1Token == (boards[i].getWinnerToken()))
                player1Score++;
            else if (player2Token == (boards[i].getWinnerToken()))
                player2Score++;
        }
        return player1.getName() + " " + player1Score + " - " + player2Score + " " + player2.getName();

    }

    // create number of boards given
    private void createBoards(int numberOfGames){
        for (int i = 0; i < numberOfGames; i++) {
            Board board = new Board();
            boards[i] = board;
        }
    }
     // call the cell check cell and if the check is success change the current player
    public boolean checkOff(int x, int y){
        if(checkOffInCell(x,y,currentPlayer)){
            return nextPlayer();
        }
        return false;

    }
     // change the current player
    private boolean nextPlayer() {
        if (player1.getToken() == currentPlayer.getToken())
            currentPlayer =  player2;
        else
            currentPlayer = player1;
        return true;
    }

    // return true if the check is success only check into a cell if there are board to play
    private boolean checkOffInCell(int x, int y, Player player){
        if ( quantityOfGamesLeft <= 0 ){
            return boards[boardId()].checkOffCell(x,y,player.getToken());
        }
        return false;
    }
     // return the id of the boards able to play
    private int boardId(){
        int boardId = quantityOfGamesLeft;
        if(!boards[boardId].stillOnPlay()) {
            quantityOfGamesLeft--;
        }
        return quantityOfGamesLeft;
    }

    public boolean onPlay(){
        return boards[0].stillOnPlay();
    }

    // return a the board on play
    public Board getCurrentBoardOnPlay() {
        if (onPlay())
            return boards[boardId()];
        return boards[0];
    }
}
