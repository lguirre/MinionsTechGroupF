import java.util.Scanner;

public class DisplayTicTacToe {
    private Scanner scannerInput;
    private String player1Symbol;
    private String [][] cells;
    private final int COLUMNS = 2;
    private final int ROWS = 2;

    DisplayTicTacToe(){
        scannerInput = new Scanner(System.in);
        cells = new String[3][3];
        for (int i = 0; i<= COLUMNS; i++){
            for (int j = 0; j <= ROWS; j++){
                cells[j][i] = " ";
            }
        }
    }

    public void displayBoard(Player player1, Player player2){
        System.out.println( "       " + "|" + "       " + "|" + "       " + "\n" +
                            "   " + cells[0][0] + "   " + "|" + "   " + cells[0][1] + "   "  + "|" +"   " + cells[0][2] + "   " + "\n" +
                            "       " + "|" + "       " + "|" + "       " + "\n" +
                            "------------------------" + "\n" +
                            "       " + "|" + "       " + "|" + "       " + "\n" +
                            "   " + cells[1][0] + "   " + "|" + "   " + cells[1][1] + "   "  + "|" +"   " + cells[1][2] + "   " + "\n" +
                            "       " + "|" + "       " + "|" + "       " + "\n" +
                            "------------------------" + "\n" +
                            "       " + "|" + "       " + "|" + "       " + "\n" +
                            "   " + cells[2][0] + "   " + "|" + "   " + cells[2][1] + "   "  + "|" +"   " + cells[2][2] + "   " + "\n" +
                            "       " + "|" + "       " + "|" + "       " + "\n" +
                            player1.getName() + "( " + player1.getSymbol() + " )" + "\t" +player2.getName() + "( " + player2.getSymbol() + " )" + "\n");
    }
    public void displayStartGame(){
        System.out.println("Welcome to Tic Tac Toe game.\n" +
                "Next players data will be requested.");
    }
    public String getPlayer1(){
        System.out.println("Enter the PLAYER1 name: ");
        return scannerInput.nextLine();
    }
    public String getSymbolPlayer1(){
        do {
            System.out.println("Enter the PLAYER1 symbol (X or O): ");
            player1Symbol = scannerInput.nextLine();
            if(!player1Symbol.equals("X") && !player1Symbol.equals("O"))
                System.out.println("Wrong symbol, try again");
        } while(!player1Symbol.equals("X") && !player1Symbol.equals("O"));
        return player1Symbol;
    }
    public String getPlayer2(){
        System.out.println("Enter the PLAYER2 name: ");
        return scannerInput.nextLine();
    }
    public String getSymbolPlayer2(){
        String symbolPlayer2;
        if(player1Symbol.equals("X")){
            symbolPlayer2 = "O";
        }
        else{
            symbolPlayer2 = "X";
        }
        return symbolPlayer2;
    }
    public int getNumberOfGames(){
        do {
            System.out.println("Enter the number of games to play: ");
            if(!scannerInput.hasNextInt())
                System.out.println("Wrong number, enter an integer");
        } while(!scannerInput.hasNextInt());
        return scannerInput.nextInt();
    }
    public int[] requestMove(Player playeInTurn){
        int [] position = new int[2];

        System.out.println("Player " + playeInTurn.getName() + " play your turn.\n" +
                "Row (0-2): ");
        position[0] = scannerInput.nextInt();
        System.out.println("Column (0-2): ");
        position[1] = scannerInput.nextInt();
        return position;
    }
    public void displayResult(Player winner){
        if (winner != null){
            System.out.println("Round finished, winner is: " + winner.getName());
        }
        else {
            System.out.println("Round finished: Tie game");
        }

    }
    public void displayScore(int[] score, Player player1, Player player2){
        System.out.println("Score: \n" +
                player1.getName() + ": " + score[0] + "\n" +
                player2.getName() + ": " + score[1] + "\n" +
                "Ties: " + score[2] + "\n"
        );
    }
    public void displayEndOfGame(int[] score){
        System.out.println("Game finished.");
    }
    public void displayCellExist(){
        System.out.println("Cell already marked, try again.");
    }
    public void markInBoard(int row, int column, String symbol){
        cells[row][column] = symbol;
    }
    public void cleanBoard(){
        for (int i = 0; i<= COLUMNS; i++){
            for (int j = 0; j <= ROWS; j++){
                cells[j][i] = " ";
            }
        }
    }

}
