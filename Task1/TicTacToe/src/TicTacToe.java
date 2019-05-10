public class TicTacToe {
    private Board boards[];
    private Board currentBoard;
    private Player player1;
    private Player player2;
    private int numberOfGames;
    private int countOfGames;
    private int turn;
    private int scorePlayer1;
    private int scorePlayer2;
    private int scoreTies;
    private boolean gameFinished;
    private boolean roundFinished;
    private boolean cellMarked;
    private Player playerCurrentTurn;

    TicTacToe(Player player1, Player player2, int numberOfGames){
        this.boards =  new Board[numberOfGames];
        this.numberOfGames = numberOfGames;
        this.player1 = player1;
        this.player2 = player2;
        this.countOfGames = 0;
        this.scorePlayer1 = 0;
        this.scorePlayer2 = 0;
        this.scoreTies = 0;
        this.currentBoard =  new Board();
        this.cellMarked = false;
    }

    public int[] getScore(){
        return new int[]{scorePlayer1,scorePlayer2,scoreTies};
    }
    public void startGame(){
        this.currentBoard =  new Board();
        roundFinished = false;
        playerCurrentTurn =  player1;
    }
    public void assignTurn(){
        if(playerCurrentTurn.equals(player1)){
            playerCurrentTurn = player2;
        }
        else{
            playerCurrentTurn = player1;
        }
    }
    public void playTurn(int row, int column, Player player){
        cellMarked = false;
        currentBoard.mark(row, column, player.getSymbol());
        if (currentBoard.isCellMarked()){
            // repeat
            cellMarked = true;
        }
        else {
            if (currentBoard.isMarkWinner()){
                //end game start new one
                if (player.equals(this.player1)){
                    scorePlayer1++;
                    currentBoard.setWinner(player1);
                }
                else {
                    scorePlayer2++;
                    currentBoard.setWinner(player2);
                }
                roundFinished = true;
                boards[countOfGames] = this.currentBoard;
                countOfGames++;
            } else if (currentBoard.isBoardFull()){
                // end game tie
                scoreTies++;
                roundFinished = true;
                boards[countOfGames] = this.currentBoard;
                countOfGames++;
            }
        }
    }
    public Player getWinner(){
        return currentBoard.getWinner();
    }
    public boolean isRoundFinished(){
        return roundFinished;

    }
    public boolean isFinished(){
        if(numberOfGames == countOfGames)
            gameFinished = true;
        return gameFinished;
    }
    public Player getPlayerCurrentTurn(){
        return playerCurrentTurn;
    }
    public boolean isCellAlreadyMarked(){
        return cellMarked;
    }
    public Player getPlayer1(){
        return player1;
    }
    public Player getPlayer2(){
        return player2;
    }
}
