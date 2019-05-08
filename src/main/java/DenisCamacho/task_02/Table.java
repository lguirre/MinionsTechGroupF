package main.java.DenisCamacho.task_02;

public class Table {
    private String[][] table;

    public Table() {
        table = new String[3][3];
        cleaning();
    }

    public void insert(Player player, int row, int column) {
        table[row][column] = String.format("%s", player.getChip());
    }

    public void cleaning() {
        System.out.println("Cleaning the table #################################################");
        for (int row = 0; row < table.length; row++) {
            for (int column = 0; column < table[row].length; column++) {
                table[row][column] = "___";
            }
        }
    }

    public void printer() {
        System.out.println(" ___  ___  ___");
        for (String[] row : table) {
            for (String column : row) {
                if (column.equals("___")){
                    System.out.print(String.format("|%s|", column));
                }
                else {
                    System.out.print(String.format("| %s |", column));
                }

            }
            System.out.print("\n");
        }
    }

    public boolean verifyField(int f, int c) {
        return table[f][c].equals("___");
    }

    public boolean fullTable() {
        for (String[] row : table) {
            for (String column : row) {
                if (column.equals("___"))
                    return false;
            }
            System.out.print("\n");
        }
        return true;
    }

    public boolean verifyWinner(Player player) {
        boolean valor = false;
        String chip1 = player.getChip();
        String chip2 = chip1 + chip1 + chip1;

        String row = table[0][0] + table[0][1] + table[0][2];
        if (chip2.equals(row)) {
            return true;
        }
        row = table[1][0] + table[1][1] + table[1][2];
        if (chip2.equals(row)) {
            return true;
        }
        row = table[2][0] + table[2][1] + table[2][2];
        if (chip2.equals(row)) {
            return true;
        }
        String column = table[0][0] + table[1][0] + table[2][0];
        if (chip2.equals(column)) {
            return true;
        }
        column = table[0][1] + table[1][1] + table[2][1];
        if (chip2.equals(column)) {
            return true;
        }
        column = table[0][2] + table[1][2] + table[2][2];
        if (chip2.equals(column)) {
            return true;
        }
        String diagonal = table[0][0] + table[1][1] + table[2][2];
        if (chip2.equals(diagonal)) {
            return true;
        }
        diagonal = table[2][0] + table[1][1] + table[0][2];
        if (chip2.equals(diagonal)) {
            return true;
        }
        return valor;
    }
}
