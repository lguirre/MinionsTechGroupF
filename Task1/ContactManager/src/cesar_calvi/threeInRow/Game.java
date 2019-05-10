package cesar_calvi.threeInRow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Board> boards;
    private Board boardInGame;
    private Player player1;
    private Player player2;


    public Game() {
        boardInGame = new Board();
        boards = new ArrayList<>();
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }

    public Player getJugador1() {
        return player1;
    }

    public void setJugador1(Player player1) {
        this.player1 = player1;
    }

    public Player getJugador2() {
        return player2;
    }

    public void setJugador2(Player player2) {
        this.player2 = player2;
    }

    public Board getBoardInGame() {
        return boardInGame;
    }

    public void setBoardInGame(Board boardInGame) {
        this.boardInGame = boardInGame;
    }


    public void ObtenerPuntaje(){
        int j1 = 0;
        int j2 = 0;

        for(Board i : boards){
            if(i.getWinner() != null && i.getWinner().getName() != null){
                if(i.getWinner().getRecords().equals("X")){
                    j1 = j1 + 1;
                } else {
                    j2 = j2 + 1;
                }
            }
        }

        System.out.println(" * " + player1.getName() + " ["+player1.getRecords()+"] ---------- " + j1);
        System.out.println(" * " + player2.getName() + " ["+player2.getRecords()+"] ---------- " + j2);
    }

    public void iniciar(Player player1, Player player2, int cant){
        this.player1 = player1;
        this.player2 = player2;
        while(boards.size() != cant){

            Scanner keyboard = new Scanner(System.in);
            String turno = AsignarTurno().getRecords();
            while(!seTermino()){
                Player playerTurn = turno.equals("X") ? player1 : player2;
                showTablero();
                System.out.println("SELECT A MOVE ["+playerTurn.getRecords()+"]: ");
                keyboard = new Scanner(System.in);
                String move = keyboard.next();
                int x = -1;
                int y = -1;
                if(move.equals("1")){
                    x = 0;
                    y = 0;
                }
                if(move.equals("2")){
                    x = 0;
                    y = 1;
                }
                if(move.equals("3")){
                    x = 0;
                    y = 2;
                }

                if(move.equals("4")){
                    x = 1;
                    y = 0;
                }
                if(move.equals("5")){
                    x = 1;
                    y = 1;
                }
                if(move.equals("6")){
                    x = 1;
                    y = 2;
                }

                if(move.equals("7")){
                    x = 2;
                    y = 0;
                }
                if(move.equals("8")){
                    x = 2;
                    y = 1;
                }
                if(move.equals("9")){
                    x = 2;
                    y = 2;
                }
                if(x != -1 && y != -1){
                    this.boardInGame.mark(x,y,playerTurn.getRecords());
                    if(!seTermino()) {
                        turno = turno.equals("X") ? "O" : "X";
                    }
                }else{
                    System.out.println("");
                    System.out.println("INVALID INPUT.");
                    System.out.println("");
                }

            }
            if(seTermino()){
                showTablero();
                if(!isATie()){
                    boardInGame.setWinner(turno.equals("X") ? player1 : player2);
                    System.out.println("WINNER : ["+ boardInGame.getWinner().getRecords() + "] " + boardInGame.getWinner().getName());
                }else{
                    boardInGame.setWinner(new Player());
                    System.out.println("TIE!!!!");
                }
                boards.add(new Board(boardInGame));
                boardInGame = new Board();
                ObtenerPuntaje();
                if(cant != boards.size()){
                    System.out.println("Press any key to continue;");
                    readKey();
                }

            }
        }
    }

    private void readKey(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            br.readLine();
        } catch (IOException e) {

        }
    }

    public Player AsignarTurno(){
        double nm = Math.random();
        if(nm % 2 == 0){
            return player1;
        }
        return player2;
    }

    public boolean seTermino(){
        String a1 = this.boardInGame.getCasillas()[0][0];
        String a2 = this.boardInGame.getCasillas()[0][1];
        String a3 = this.boardInGame.getCasillas()[0][2];

        String b1 = this.boardInGame.getCasillas()[1][0];
        String b2 = this.boardInGame.getCasillas()[1][1];
        String b3 = this.boardInGame.getCasillas()[1][2];

        String c1 = this.boardInGame.getCasillas()[2][0];
        String c2 = this.boardInGame.getCasillas()[2][1];
        String c3 = this.boardInGame.getCasillas()[2][2];
        if(a1.equals(a2) && a1.equals(a3)){
            return true;
        }
        if(b1.equals(b2) && b1.equals(b3)){
            return true;
        }
        if(c1.equals(c2) && c1.equals(c3)){
            return true;
        }

        if(a1.equals(b1) && a1.equals(c1)){
            return true;
        }
        if(a2.equals(b2) && a2.equals(c2)){
            return true;
        }
        if(a3.equals(b3) && a3.equals(c3)){
            return true;
        }

        if(a1.equals(b2) && a1.equals(c3)){
            return true;
        }
        if(a3.equals(b2) && a1.equals(c1)){
            return true;
        }

        if(!this.boardInGame.checkEmptySpaces()){
            return true;
        }

        return false;
    }

    public boolean isATie(){
        String a1 = this.boardInGame.getCasillas()[0][0];
        String a2 = this.boardInGame.getCasillas()[0][1];
        String a3 = this.boardInGame.getCasillas()[0][2];

        String b1 = this.boardInGame.getCasillas()[1][0];
        String b2 = this.boardInGame.getCasillas()[1][1];
        String b3 = this.boardInGame.getCasillas()[1][2];

        String c1 = this.boardInGame.getCasillas()[2][0];
        String c2 = this.boardInGame.getCasillas()[2][1];
        String c3 = this.boardInGame.getCasillas()[2][2];
        if(a1.equals(a2) && a1.equals(a3)){
            return false;
        }
        if(b1.equals(b2) && b1.equals(b3)){
            return false;
        }
        if(c1.equals(c2) && c1.equals(c3)){
            return false;
        }

        if(a1.equals(b1) && a1.equals(c1)){
            return false;
        }
        if(a2.equals(b2) && a2.equals(c2)){
            return false;
        }
        if(a3.equals(b3) && a3.equals(c3)){
            return false;
        }

        if(a1.equals(b2) && a1.equals(c3)){
            return false;
        }
        if(a3.equals(b2) && a1.equals(c1)){
            return false;
        }
        return true;
    }

    public void showTablero(){
        System.out.println("");
        System.out.print(" ");
        System.out.print(this.boardInGame.getCasillas()[0][0]);
        System.out.print(" ");
        System.out.print("|");
        System.out.print(" ");
        System.out.print(this.boardInGame.getCasillas()[0][1]);
        System.out.print(" ");
        System.out.print("|");
        System.out.print(" ");
        System.out.print(this.boardInGame.getCasillas()[0][2]);
        System.out.print(" ");
        System.out.println("");

        System.out.print("-");
        System.out.print("-");
        System.out.print("-");
        System.out.print("+");
        System.out.print("-");
        System.out.print("-");
        System.out.print("-");
        System.out.print("+");
        System.out.print("-");
        System.out.print("-");
        System.out.print("-");
        System.out.println("");

        System.out.print(" ");
        System.out.print(this.boardInGame.getCasillas()[1][0]);
        System.out.print(" ");
        System.out.print("|");
        System.out.print(" ");
        System.out.print(this.boardInGame.getCasillas()[1][1]);
        System.out.print(" ");
        System.out.print("|");
        System.out.print(" ");
        System.out.print(this.boardInGame.getCasillas()[1][2]);
        System.out.print(" ");
        System.out.println("");

        System.out.print("-");
        System.out.print("-");
        System.out.print("-");
        System.out.print("+");
        System.out.print("-");
        System.out.print("-");
        System.out.print("-");
        System.out.print("+");
        System.out.print("-");
        System.out.print("-");
        System.out.print("-");
        System.out.println("");

        System.out.print(" ");
        System.out.print(this.boardInGame.getCasillas()[2][0]);
        System.out.print(" ");
        System.out.print("|");
        System.out.print(" ");
        System.out.print(this.boardInGame.getCasillas()[2][1]);
        System.out.print(" ");
        System.out.print("|");
        System.out.print(" ");
        System.out.print(this.boardInGame.getCasillas()[2][2]);
        System.out.print(" ");
        System.out.println("");

        System.out.println("");
    }
}
