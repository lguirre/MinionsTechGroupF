package com.three.game.controller;

import com.three.game.model.CellState;
import com.three.game.model.StateGame;
import java.util.Scanner;

public class MoveManager
{

    private StateGame.State currentState;
    private CellState.Status currentPlayer;
    private BoardGame board;
    private static Scanner input = new Scanner(System.in);

    public MoveManager()
    {
        board = new BoardGame();

        startGame();

        do {
            try {
                playerMove(currentPlayer);
                board.paintBoard();
                updateGame(currentPlayer);

                if (currentState == StateGame.State.LX_WON) {
                    System.out.println("'X' won the game Bye!");
                } else if (currentState == StateGame.State.LO_WON) {
                    System.out.println("'O' won the game Bye!");
                }

                currentPlayer = (currentPlayer == CellState.Status.LX) ? CellState.Status.LO : CellState.Status.LX;
            }
            catch (ArrayIndexOutOfBoundsException error)
            {
                System.out.println("Trying again new move, thanks!");
            }
        } while (currentState ==  StateGame.State.PLAYING);
    }


    public void startGame()
    {
        board.init();
        currentState = StateGame.State.PLAYING;
        currentPlayer = CellState.Status.LX;
    }


    public void playerMove(CellState.Status status)
    {
        boolean validPosition = false;
        do {
                if (status == CellState.Status.LX)
                {
                    System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
                } else
                {
                    System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
                }

            try {
                int row, col = 0;
                row = Integer.parseInt(input.nextLine()) - 1;
                col = Integer.parseInt(input.nextLine()) - 1;

                if (board.cells[row][col].status == CellState.Status.EMPTY
                        && row >= 0 && row < BoardGame.ROWS
                        && col >= 0 && col < BoardGame.COLS)
                {
                    board.currentRow = row;
                    board.currentCol = col;
                    board.cells[row][col].status = status;
                    validPosition = true;
                } else
                {
                    System.out.println(" It moved at (" + (row + 1) + "," + (col + 1)
                            + ") is not valid position");
                }
            } catch (NumberFormatException e) {
                System.out.println("Trying again the number input is not valid!");
            }

        } while (!validPosition);
    }

    public void updateGame(CellState.Status status)
    {
        if (board.checkWon(status))
        {
            currentState = (status == CellState.Status.LX) ? StateGame.State.LX_WON : StateGame.State.LO_WON;
        } else if (board.isPaint())
        {
            currentState = StateGame.State.PAINT;
        }
    }
}
