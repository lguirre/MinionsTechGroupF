package cesar_calvi.threeInRow;

public class Board {
    private String[][] boxes;
    private Player winner;

    public Board() {
        winner = new Player();
        boxes = new String[3][3];
        int cont = 1;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                boxes[i][j] = String.valueOf(cont);
                cont = cont + 1;
            }
        }
    }

    public Board(Board tab) {
        winner = new Player();
        winner.setRecords(tab.getWinner().getRecords());
        winner.setName(tab.getWinner().getName());
        boxes = new String[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                boxes[i][j] = tab.getCasillas()[i][j];
            }
        }
    }

    public String[][] getCasillas() {
        return boxes;
    }

    public void setBoxe(String[][] boxes) {
        this.boxes = boxes;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player ganador) {
        this.winner = ganador;
    }

    public void mark(int x, int y, String ficha){
        if(!boxes[x][y].equals("X") && !boxes[x][y].equals("O")){
            boxes[x][y] = ficha;
        } else {
            System.out.println("");
            System.out.println("INVALID OPTION.");
            System.out.println("");
        }
    }

    public boolean checkEmptySpaces(){
        boolean res = false;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(!boxes[i][j].equals("X") && !boxes[i][j].equals("O")){
                    res = true;
                }
            }
        }
        return res;
    }
}
