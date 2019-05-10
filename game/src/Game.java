import java.util.Scanner;

public class Game {
    private Table[] tables;
    private Table tableOnGame;
    private Player playerOne;
    private Player playerTwo;
    Scanner readConsole = new Scanner(System.in);

    Game(Player playerOne, Player playerTwo, int numberGames){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.tableOnGame = new Table();
        tables = new Table[numberGames];
    }

    public void getScore(){

    }

    public Player setTurn(){
        if (playerOne.isTurn()){
            playerTwo.setTurn(true);
            System.out.println("dos"+playerTwo.isTurn());
            playerOne.setTurn(false);
            System.out.println("uno"+playerOne.isTurn());
            return playerOne;
        }
        if (playerTwo.isTurn()){
            playerOne.setTurn(true);
            System.out.println("uno"+playerOne.isTurn());
            playerTwo.setTurn(false);
            System.out.println("dos"+playerTwo.isTurn());
            return playerTwo;
        }
        playerTwo.setTurn(true);
        return playerOne;
    }

    public void startGame(){

        do {
            tableOnGame.setCurrentPlayer(setTurn());
            System.out.println("write position horizontal");
            int positionHorizontal = readConsole.nextInt();
            System.out.println("write position vertical");
            int positionVertical = readConsole.nextInt();
            tableOnGame.setPieceInTable(positionHorizontal, positionVertical);
        } while (!isGameComplete() && tableOnGame.getEmptyPosition());
    }

    public boolean isGameComplete(){
        return tableOnGame.comparePlay();
    }

    public static void main(String[] args) {
        Player playerOne = new Player("Carmen", '*');
        Player playerTwo = new Player("Juan", '#');
        Game game = new Game(playerOne, playerTwo, 3);
        game.startGame();
    }
}
