import java.util.Random;
import java.util.Scanner;

public class Game {

    Player PlayerX = new Player();
    Player PlayerO = new Player();





    public void getPlayers(){

        boolean assignedX=false;
        boolean assignedO=false;
        while(assignedX == false){
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Introduce el nombre para el jugador con la ficha X");
            String inputname = keyboard.next();


            PlayerX.name = inputname;
            PlayerX.ficha = "X";

            assignedX=true;
        }
        while(assignedO == false){
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Introduce el nombre para el jugador con la ficha O");
            String inputname = keyboard.next();

            PlayerO.name = inputname;
            PlayerO.ficha = "O";
            assignedO=true;

        }
    }



    public String assignFT(){
        //El juego asigna aleatoriamente el primer turno
        String aturn = "";
        Random rand = new Random();
        int value = rand.nextInt(2);

        if(value==0){
            aturn = "X";
            String t1name = PlayerX.name;
            System.out.println("Primer turno para " + t1name + " con la ficha "+ aturn);
        }else if(value==1){
            aturn = "O";
            String t1name = PlayerO.name;
            System.out.println("Primer turno para "+ t1name + " con la ficha "+ aturn);
        }
        //Devolvemos al Board quien sera el primer turno
        return aturn;
    }

    public String TurnControl(String Turn){
        //Verificamos de quien fue el turno antes de enviarlo aqui desde el Board y devolvemos el turno al oponente
        if(Turn.equals("X")){
            Turn = "O";
            String tname = PlayerO.name;
            System.out.println("Ahora es turno de " +tname + " con la ficha "+Turn);
            return Turn;
        }else{
            Turn = "X";
            String tname = PlayerX.name;
            System.out.println("Ahora es turno de " +tname + " con la ficha "+Turn);
            return Turn;
        }


    }

    public static void CreateBoard(){
        //Construimos la primera Matriz del juego vacia y se la enviamos al Board para que la dibuje
        //Nota para cuestiones de dibujo estoy tomando una matriz de 5 x 5 para dibujar el tablero pero las rutinas del juego en adelante trabajaran con una matriz de 3x3
        String [][] gBoard = {{" ","|"," ","|"," "},
                {"-","-","-","-","-"},
                {" ","|"," ","|"," "},
                {"-","-","-","-","-"},
                {" ","|"," ","|"," "}};
        //Creamos nuestro tablero
        Board myBoard = new Board(gBoard);
        //mandamos a dibujar el tablero
        myBoard.drawBoard();
        //Arrancamos el juego
        myBoard.play();

    }



    public static void main(String [] args) {

        CreateBoard();



    }


}


