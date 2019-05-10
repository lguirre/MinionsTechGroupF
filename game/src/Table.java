public class Table {
    private char[][] box = new char[][]{{'-','-','-'}, {'-','-','-'}, {'-','-','-'}};
    private Player currentPlayer;

    Table(){
        this.currentPlayer = null;
    }

    public void showTable(){
        for (int i=0; i < box.length; i++){
            for(int j=0; j < box[i].length; j++){
                System.out.print(" "+box[i][j]+" ");
            }
            System.out.println();
        }
    }

    public boolean getEmptyPosition(){
        for (int i=0; i < box.length; i++){
            for(int j=0; j < box[i].length; j++){
                if (box[i][j] == '-'){
                    return true;
                }
            }
        }
        return false;
    }

    public char[][] getBox() {
        return box;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setPieceInTable(int positionHorizontal, int positionVertical){
        if (positionHorizontal < box.length && positionVertical < box[0].length){
            if (box[positionHorizontal][positionVertical] == '-') {
                this.box[positionHorizontal][positionVertical] = currentPlayer.getPiece();
            } else {
                System.out.println("That position is already occupied by the other player");
            }
        } else {
            System.out.println("You can't put the tab in that position");
        }
    }

    public boolean comparePlay(){
        if(box[0][0] == currentPlayer.getPiece() && box[0][1] == currentPlayer.getPiece() && box[0][2] == currentPlayer.getPiece()){
            return true;
        }
        if(box[1][0] == currentPlayer.getPiece() && box[1][1] == currentPlayer.getPiece() && box[1][2] == currentPlayer.getPiece()){
            return true;
        }
        if(box[2][0] == currentPlayer.getPiece() && box[2][1] == currentPlayer.getPiece() && box[2][2] == currentPlayer.getPiece()){
            return true;
        }
        if(box[0][0] == currentPlayer.getPiece() && box[1][0] == currentPlayer.getPiece() && box[2][0] == currentPlayer.getPiece()){
            return true;
        }
        if(box[0][1] == currentPlayer.getPiece() && box[1][1] == currentPlayer.getPiece() && box[2][1] == currentPlayer.getPiece()){
            return true;
        }
        if(box[0][2] == currentPlayer.getPiece() && box[1][2] == currentPlayer.getPiece() && box[2][2] == currentPlayer.getPiece()){
            return true;
        }
        if(box[0][0] == currentPlayer.getPiece() && box[1][1] == currentPlayer.getPiece() && box[2][1] == currentPlayer.getPiece()){
            return true;
        }
        return box[0][2] == currentPlayer.getPiece() && box[1][1] == currentPlayer.getPiece() && box[2][0] == currentPlayer.getPiece();
    }
}
