public class GameManager {
    private TicTacToe ticTacToeGame;
    private DisplayTicTacToe gameConsole;

    GameManager(){
        gameConsole = new DisplayTicTacToe();
    }

    public void init(){
        gameConsole.displayStartGame();
        Player player1 = new Player(gameConsole.getPlayer1(), gameConsole.getSymbolPlayer1());
        Player player2 = new Player(gameConsole.getPlayer2(), gameConsole.getSymbolPlayer2());
        int numberOfGames = gameConsole.getNumberOfGames();
        ticTacToeGame = new TicTacToe(player1, player2, numberOfGames);
        ticTacToeGame.startGame();
        playGame();
    }
    public void playGame(){
        while(!ticTacToeGame.isFinished()) {
            playRound();
        }
        gameConsole.displayEndOfGame(ticTacToeGame.getScore());
        gameConsole.displayScore(ticTacToeGame.getScore(), ticTacToeGame.getPlayer1(), ticTacToeGame.getPlayer2());
    }
    public  void playRound(){
        ticTacToeGame.startGame();
        while (!ticTacToeGame.isRoundFinished()){
            playTurn();
            ticTacToeGame.assignTurn();
        }
        gameConsole.displayResult(ticTacToeGame.getWinner());
        gameConsole.displayScore(ticTacToeGame.getScore(), ticTacToeGame.getPlayer1(), ticTacToeGame.getPlayer2());
        gameConsole.cleanBoard();
    }
    public void playTurn(){
        Player playerWithTurn = ticTacToeGame.getPlayerCurrentTurn();
        int [] positionPlayed = new int[2];
        do {
            positionPlayed = gameConsole.requestMove(playerWithTurn);
            ticTacToeGame.playTurn(positionPlayed[0], positionPlayed[1], playerWithTurn);
            if (ticTacToeGame.isCellAlreadyMarked())
                gameConsole.displayCellExist();
        } while (ticTacToeGame.isCellAlreadyMarked());
        gameConsole.markInBoard(positionPlayed[0], positionPlayed[1], playerWithTurn.getSymbol());
        gameConsole.displayBoard(ticTacToeGame.getPlayer1(), ticTacToeGame.getPlayer2());
    }

}
