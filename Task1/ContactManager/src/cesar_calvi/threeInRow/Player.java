package cesar_calvi.threeInRow;

public class Player {
    private String name;
    private String records;

    public Player() {
    }

    public Player(String name, String record) {
        this.name = name;
        this.records = record;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }
}
