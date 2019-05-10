public class Player {

    private String name;
    private String sing;
    private int win;
    private int lost;
    private int tie;


    public Player(String name, String sing) {
        this.name = name;
        this.sing = sing;
        win = 0;
        lost = 0;
        tie = 0;
    }

    public void addWin(){
        win++;
    }

    public void addlost(){
        lost++;
    }

    public void addTie(){
        tie++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSing() {
        return sing;
    }

    public void setSing(String sing) {
        this.sing = sing;
    }

    public void displayStatus(){
        System.out.println(String.format("Name: %s, WIN: %d - LOST: %d - TIE: %d ", name, win, lost, tie));
    }

}
