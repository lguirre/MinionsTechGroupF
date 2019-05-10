public class BoardGame {
    private String[][] board;

    public BoardGame() {
        this.board = new String[3][3];
        CleanBoard();
    }

    public void CleanBoard(){
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                board[row][column] = " __ ";
            }
        }
    }

    public void PrintBoard() {
        System.out.println("----------------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("----------------------");
        }
    }


    public boolean insert(Player player, int row, int column) {
        if ((row >= 0) && (row < 3)) {
            if ((column >= 0) && (column < 3)) {
                if (board[row][column] == " __ " || board[row][column] != "X") {
                    board[row][column] = player.getChip();
                    return true;
                }else {
                    System.out.println("CHOOSE OTHER FIELD");
                }
            }
        }
        return false;
    }

    public boolean VerifyWinner(Player player){
        boolean value = false;
        String chip1 = player.getChip();
        String chip2 = chip1+chip1+chip1;
        String row = board[0][0]+board[0][1]+board[0][2];
        System.out.println(row);
        if( chip2.equals(row)){
            value  = true;
        }
        row = board[1][0]+board[1][1]+board[1][2];
        if( chip2.equals(row)){
            value  = true;
        }
        row = board[2][0]+board[2][1]+board[2][2];
        if( chip2.equals(row)){
            value  = true;
        }
        String columna = board[0][0]+board[1][0]+board[2][0];
        if( chip2.equals(columna)){
            value  = true;
        }
        columna = board[0][1]+board[1][1]+board[2][1];
        if( chip2.equals(columna)){
            value  = true;
        }
        columna = board[0][2]+board[1][2]+board[2][2];
        if( chip2.equals(columna)){
            value  = true;
        }
        String diagonal = board[0][0]+board[1][1]+board[2][2];
        if( chip2.equals(diagonal)){
            value  = true;
        }
        diagonal = board[2][0]+board[1][1]+board[0][2];
        if( chip2.equals(diagonal)){
            value  = true;
        }
        return value;
    }
}
