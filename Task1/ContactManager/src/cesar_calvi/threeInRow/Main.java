package cesar_calvi.threeInRow;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Select character [0] or [x] ");
        System.out.println("-------------------: ");
        System.out.print("Enter player 1 [character]: ");
        String nameOne = keyboard.next();
        keyboard = new Scanner(System.in);
        System.out.print("Enter player 2 [character]: ");
        String nameTwo = keyboard.next();
        System.out.print("Enter number of rounds: ");
        String cant1 = keyboard.next();
        if(isNumber(cant1)){

            Game conn = new Game();
            System.out.println("");
            System.out.println("START OF GAME");
            System.out.println("");
            Player j1 = new Player(nameOne,"X");
            Player j2 = new Player(nameTwo,"O");
            int cant = Integer.valueOf(cant1);
            conn.iniciar(j1, j2, cant);

        }
    }

    private static boolean isNumber(String str){
        try{
            double x = Double.valueOf(str);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}
