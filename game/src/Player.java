public class Player {
    private String name;
    private char piece;
    private boolean turn;

    Player(String name, char piece){
        this.name = name;
        this.piece = piece;
        this.turn = false;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getPiece() {
        return piece;
    }

    public void setPiece(char piece) {
        this.piece = piece;
    }
}
