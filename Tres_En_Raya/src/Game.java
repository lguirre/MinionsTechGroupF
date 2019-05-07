import java.util.Random;

public class Game {
    public String assignFT(){
        //El juego asigna aleatoriamente el primer turno
        String aturn = "";
        Random rand = new Random();
        int value = rand.nextInt(2);

            if(value==0){
                aturn = "X";
                System.out.println("First turn for X");
            }else if(value==1){
                aturn = "O";
                System.out.println("First turn for O");
            }
        //Devolvemos al Board quien sera el primer turno
        return aturn;
    }

    public String TurnControl(String Turn){
        //Verificamos de quien fue el turno antes de enviarlo aqui desde el Board y devolvemos el turno al oponente
        if(Turn.equals("X")){
            Turn = "O";
            return Turn;
        }else{
            Turn = "X";
            return Turn;
        }


    }


    public static void main(String [] args) {

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


}


