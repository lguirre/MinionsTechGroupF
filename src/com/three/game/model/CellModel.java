package com.three.game.model;

public class CellModel {

    public CellState.Status status;

    private int maxRows, maxColumns;

    public CellModel(int rows, int columns){
        this.maxColumns = columns;
        this.maxRows = rows;
        cleanCell();
    }

    public void cleanCell(){
        status = CellState.Status.EMPTY;
    }

    public void paint (){
        switch (status){
            case LX: System.out.print(" X "); break;
            case LO: System.out.print(" O "); break;
            case EMPTY: System.out.print("  "); break;
        }
    }
}
