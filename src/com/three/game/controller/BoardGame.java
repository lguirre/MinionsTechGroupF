package com.three.game.controller;

import com.three.game.model.CellModel;
import com.three.game.model.CellState;

public class BoardGame
{

    public static final int ROWS = 3;
    public static final int COLS = 3;

    CellModel[][] cells;
    int currentRow, currentCol;

    public BoardGame() {
        cells = new CellModel[ROWS][COLS];
        for (int row = 0; row < ROWS; ++row)
        {
            for (int col = 0; col < COLS; ++col)
            {
                cells[row][col] = new CellModel(row, col);
            }
        }
    }

    public void init()
    {
        for (int row = 0; row < ROWS; ++row)
        {
            for (int col = 0; col < COLS; ++col)
            {
                cells[row][col].cleanCell();
            }
        }
    }

    public boolean isPaint()
    {
        for (int row = 0; row < ROWS; ++row)
        {
            for (int col = 0; col < COLS; ++col)
            {
                if (cells[row][col].status == CellState.Status.EMPTY)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWon(CellState.Status status)
    {
        return (cells[currentRow][0].status == status
                && cells[currentRow][1].status == status
                && cells[currentRow][2].status == status
                || cells[0][currentCol].status == status
                && cells[1][currentCol].status == status
                && cells[2][currentCol].status == status
                || currentRow == currentCol
                && cells[0][0].status == status
                && cells[1][1].status == status
                && cells[2][2].status == status
                || currentRow + currentCol == 2
                && cells[0][2].status == status
                && cells[1][1].status == status
                && cells[2][0].status == status);
    }

    public void paintBoard()
    {
        for (int row = 0; row < ROWS; ++row)
        {
            for (int col = 0; col < COLS; ++col)
            {
                cells[row][col].paint();
                if (col < COLS - 1) System.out.print("|");
            }
            System.out.println();
            if (row < ROWS - 1)
            {
                System.out.println("---------");
            }
        }
    }
}
