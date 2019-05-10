import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Player playerX = new Player("Erik", "X");
        Player playerO = new Player("Beto", "O");
        BoardGame board = new BoardGame();
        Scanner input = new Scanner(System.in);
        board.PrintBoard();
        boolean winner = false;
        for (int turn = 1; turn <= 9; turn++) {
            if(turn%2==0){
                System.out.println("Play" +" "+ playerO.getName() +" "+ "with chip:" +" "+ playerO.getChip());
                System.out.println("Insert chip:");
                playerO.setChip(input.next());
                System.out.println("Insert row:");
                int row = input.nextInt();
                System.out.println("Insert column:");
                int column = input.nextInt();
                board.insert(playerO, row,column);
                winner = board.VerifyWinner(playerO);
            }else{
                System.out.println("Play" +" "+ playerX.getName() +" "+ "with chip:" +" "+ playerX.getChip());
                System.out.println("Insert chip:");
                playerX.setChip(input.next());
                System.out.println("Insert row:");
                int row = input.nextInt();
                System.out.println("Insert column:");
                int column = input.nextInt();
                board.insert(playerX, row,column);
                winner = board.VerifyWinner(playerX);
            }
            board.PrintBoard();
            if(winner){
                break;
            }
        }
        if(winner){
            System.out.println("YOU WIN!!!");
        }else{
            System.out.println("YOU LOOSE!!!");
        }
    }
}
