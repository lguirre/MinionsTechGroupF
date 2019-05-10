public class Player {
    private String name;
    private String chip;

    public Player(String name, String chip) {
        this.name = name;
        this.chip = chip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }
}
