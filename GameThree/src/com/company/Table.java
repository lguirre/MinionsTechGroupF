package com.company;

public class Table {
    private String[][] threeRowTablero;

    public Table() {
        threeRowTablero = new String[3][3];
        clean();
    }

    public String[][] getThreeRowTablero() {
        return threeRowTablero;
    }


    public void clean(){
        for (int row = 0; row < threeRowTablero.length; row++) {
            for (int column = 0; column < threeRowTablero[0].length; column++) {
                threeRowTablero[row][column] = "  __";
            }
        }
    }

    public void drawThreeRow(){
        System.out.println("Selection of row and column");
        for (int row = 0; row < threeRowTablero.length; row++) {
            for (int column = 0; column < threeRowTablero[0].length; column++) {
                System.out.print(threeRowTablero[row][column]);
            }
            System.out.println("");
        }
    }

    public boolean checkWinner(Player player){
        boolean value = false;
        String token1 = player.getToken();
        String token3 = token1+token1+token1;
        String row = threeRowTablero[0][0]+ threeRowTablero[0][1]+ threeRowTablero[0][2];
        if( token3.equals(row)){
            value  = true;
        }
        row = threeRowTablero[1][0]+ threeRowTablero[1][1]+ threeRowTablero[1][2];
        if( token3.equals(row)){
            value  = true;
        }
        row = threeRowTablero[2][0]+ threeRowTablero[2][1]+ threeRowTablero[2][2];
        if( token3.equals(row)){
            value  = true;
        }
        String column = threeRowTablero[0][0]+ threeRowTablero[1][0]+ threeRowTablero[2][0];
        if( token3.equals(column)){
            value  = true;
        }
        column = threeRowTablero[0][1]+ threeRowTablero[1][1]+ threeRowTablero[2][1];
        if( token3.equals(column)){
            value  = true;
        }
        column = threeRowTablero[0][2]+ threeRowTablero[1][2]+ threeRowTablero[2][2];
        if( token3.equals(column)){
            value  = true;
        }
        String diagonal = threeRowTablero[0][0]+ threeRowTablero[1][1]+ threeRowTablero[2][2];
        if( token3.equals(diagonal)){
            value  = true;
        }
        diagonal = threeRowTablero[2][0]+ threeRowTablero[1][1]+ threeRowTablero[0][2];
        if( token3.equals(diagonal)){
            value  = true;
        }
        return value;
    }

}
