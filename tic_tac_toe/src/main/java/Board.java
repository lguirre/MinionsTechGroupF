import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Board {

    Map<Integer, Point> positions = new HashMap<>();
    private String[][] cells;


    public Board() {
        cells = new String[3][3];
        setPositions();
        clear();

    }

    private void setPositions() {
        positions.put(1, new Point(0, 0));
        positions.put(2, new Point(1, 0));
        positions.put(3, new Point(2, 0));
        positions.put(4, new Point(0, 1));
        positions.put(5, new Point(1, 1));
        positions.put(6, new Point(2, 1));
        positions.put(7, new Point(0, 2));
        positions.put(8, new Point(1, 2));
        positions.put(9, new Point(2, 2));
    }

    public boolean setFigure(String figure, int position) {
        boolean markedCell = false;
        if (positions.containsKey(position)) {
            Point point = positions.get(position);
            if (cells[point.x][point.y] == " ___ ") {
                cells[point.x][point.y] = String.format(" _%s_ ", figure);
                markedCell = true;
            }
        }
        return markedCell;
    }

    public void clear() {
        for (int f = 0; f < cells.length; f++) {
            for (int c = 0; c < cells[0].length; c++) {
                cells[f][c] = " ___ ";
            }
        }
    }

    public void print() {
        System.out.println("/n/n/n");

        for (int f = 0; f < cells.length; f++) {
            for (int c = 0; c < cells[0].length; c++) {
                System.out.print(cells[f][c]);
            }
            System.out.println("");
        }
    }

    public boolean checkWinner(String figure) {
        boolean value = false;
        String sing1 = " _" + figure + "_ ";
        String sing3 = sing1 + sing1 + sing1;
        String row = cells[0][0] + cells[0][1] + cells[0][2];
        if (sing3.equals(row)) {
            value = true;
        }
        row = cells[1][0] + cells[1][1] + cells[1][2];
        if (sing3.equals(row)) {
            value = true;
        }
        row = cells[2][0] + cells[2][1] + cells[2][2];
        if (sing3.equals(row)) {
            value = true;
        }
        String column = cells[0][0] + cells[1][0] + cells[2][0];
        if (sing3.equals(column)) {
            value = true;
        }
        column = cells[0][1] + cells[1][1] + cells[2][1];
        if (sing3.equals(column)) {
            value = true;
        }
        column = cells[0][2] + cells[1][2] + cells[2][2];
        if (sing3.equals(column)) {
            value = true;
        }
        String diagonal = cells[0][0] + cells[1][1] + cells[2][2];
        if (sing3.equals(diagonal)) {
            value = true;
        }
        diagonal = cells[2][0] + cells[1][1] + cells[0][2];
        if (sing3.equals(diagonal)) {
            value = true;
        }
        return value;
    }
}
