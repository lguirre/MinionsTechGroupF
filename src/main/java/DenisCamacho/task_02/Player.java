package main.java.DenisCamacho.task_02;

public class Player {
    private String chip;
    private String name;
    private int flagWinner;

    Player(String chip, String name) {
        this.chip = chip;
        this.name = name;
        this.flagWinner = 0;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updateFlagWinner() {
        flagWinner++;
    }

    public int getFlagWinner() {
        return flagWinner;
    }
}
