public class Board {
    private String[][] cells;
    private Player winner;
    private final int MAX_ROW = 2;
    private final int MAX_COLUMN = 2;
    private int remainingCells;
    private boolean cellsComplete;
    private boolean isThereWinner;
    private boolean cellMarked;

    Board(){
        this.cells = new String[3][3];
        this.remainingCells = 9;
        this.cellsComplete = false;
        this.isThereWinner = false;
        this.cellMarked = false;
        this.winner = null;
        for (int i = 0; i<= MAX_COLUMN; i++){
            for (int j = 0; j <= MAX_ROW; j++){
                this.cells[j][i] = "";
            }
        }
    }

    public void mark(int row, int column, String symbol){
        evaluateMarkedCell(row,column);
        if(!cellMarked){
            this.cells[row][column] = symbol;
            this.remainingCells --;
            evaluateWinner(row, column);
            evaluateBoardFull();
        }
    }
    public void setWinner(Player winner){
        this.winner = winner;
    }
    public void evaluateMarkedCell(int row, int column){
        if(!cells[row][column].equals(""))
            this.cellMarked = true;
        else
            this.cellMarked = false;
    }
    public void evaluateWinner(int row, int column){
        if ((cells[row][0].equals(cells[row][1])) && (cells[row][1].equals(cells[row][2]))){
            this.isThereWinner = true;
        }
        else if((cells[0][column].equals(cells[1][column])) && (cells[1][column].equals(cells[2][column]))){
            this.isThereWinner = true;
        }
        else if( !cells[0][0].equals("") && (cells[0][0].equals(cells[1][1])) && (cells[1][1].equals(cells[2][2]))){
            this.isThereWinner = true;
        }
        else if( !cells[0][2].equals("") && (cells[0][2].equals(cells[1][1])) && (cells[1][1].equals(cells[2][0]))){
            this.isThereWinner = true;
        }
        else{
            this.isThereWinner = false;
        }
    }
    public void evaluateBoardFull(){
        if(remainingCells == 0)
            this.cellsComplete = true;
    }

    public boolean isBoardFull(){
        return cellsComplete;
    }
    public boolean isMarkWinner(){
        return isThereWinner;
    }
    public boolean isCellMarked(){
        return cellMarked;
    }
    public Player getWinner(){
        return winner;

    }
}
