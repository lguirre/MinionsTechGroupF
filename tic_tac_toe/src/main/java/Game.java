import java.util.Scanner;

public class Game {

    private Scanner in;
    private Board board;
    private Player playerO;
    private Player playerX;
    private int plays;

    public Game() {
        in = new Scanner(System.in);
        board = new Board();
        plays = 0;
    }

    public void start() {
        String namePlayer;
        System.out.println("Start Game");
        System.out.print("Enter name the first payer: ");
        namePlayer = in.nextLine();
        playerO = new Player(namePlayer, "o");

        System.out.print("Enter name the second payer: ");
        namePlayer = in.nextLine();
        playerX = new Player(namePlayer, "x");


        String yourOption = "";
        do {

            menuDisplay();
            yourOption = in.nextLine();
            if (yourOption.equalsIgnoreCase( "1")) {
                startGame();
            }
            playerX.displayStatus();
            playerO.displayStatus();

        } while (!yourOption.equalsIgnoreCase("0"));


    }

    private void startGame() {
        board.clear();
        plays++;
        int position;
        Player playerFirst = setFirstTurn(plays);
        Player playerSecond = setSecondTurn(plays);

        do{
            board.print();
            System.out.println("0.- End program.");
            System.out.print("[1-9].- "+playerFirst.getName()+" turn mark his position: ");
            position = in.nextInt();
            if(position!=0){
                if(position<10 && position>0){
                    board.setFigure(playerFirst.getSing(), position);
                    if( board.checkWinner(playerFirst.getSing())){
                        playerFirst.addWin();
                        playerSecond.addlost();
                        board.print();
                        break;
                    }
                }
                board.print();
                System.out.println("0.- End program.");
                System.out.print("[1-9].- "+playerSecond.getName()+" turn mark his position: ");
                position = in.nextInt();
                if(position!=0){
                    if(position<10 && position>0){
                        board.setFigure(playerSecond.getSing(), position);
                        if( board.checkWinner(playerSecond.getSing())){
                            playerSecond.addWin();
                            playerFirst.addlost();
                            board.print();
                            break;
                        }
                    }


                }

            }

        }while(position!=0);
        if(position == 0){
            playerFirst.addlost();
            playerSecond.addlost();
            board.print();
        }
    }

    private Player setFirstTurn( int plays){
        if(plays % 2 ==0){
          return playerO;
        }
        return playerX;
    }


    private Player setSecondTurn( int plays){
        if(plays % 2 ==0){
            return playerX;
        }
        return playerO;
    }

    /**
     * Displays the menu.
     */
    private void menuDisplay() {
        System.out.println("MENU");
        System.out.println("1.- Start Game.");
        System.out.println("0.- End program.");
        System.out.print("Enter your option: ");
    }

}
