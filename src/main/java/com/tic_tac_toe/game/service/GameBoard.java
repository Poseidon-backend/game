package com.tic_tac_toe.game.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class GameBoard {
    private final static int BOARD_SIZE = 3;
    private final String[][] board;
    @Getter
    private int moveCount;

    public GameBoard() {
        board = new String[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
    }

    protected void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = "";
            }
        }
        moveCount = 0;
    }

    private boolean isMoveValid(int row, int column) {
        return row >= 0 && row < BOARD_SIZE && column >= 0 && column < BOARD_SIZE && board[row][column].equals("");
    }

    public boolean isMoveLegal(int row, int column) {
        return isMoveValid(row, column);
    }

    public void makeMove(int row, int column, String symbol) {
        board[row][column] = symbol;
        moveCount++;
    }

    public boolean hasWon(String symbol) {
        //rows
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0].equals(symbol) && board[i][1].equals(symbol) && board[i][2].equals(symbol)) {
                return true;
            }
        }
        //columns
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[0][i].equals(symbol) && board[1][i].equals(symbol) && board[2][i].equals(symbol)) {
                return true;
            }
        }
        //diagonals
        if (board[0][0].equals(symbol) && board[1][1].equals(symbol) && board[2][2].equals(symbol)) {
            return true;
        }
        if (board[0][2].equals(symbol) && board[1][1].equals(symbol) && board[2][0].equals(symbol)) {
            return true;
        }
            return false;
    }
    public boolean isBoardFull (){
        return moveCount == BOARD_SIZE*BOARD_SIZE;
    }
    public boolean isGameOver(){
        return hasWon("O") || hasWon("X") || isBoardFull();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                sb.append(" ").append(board[i][j]).append(" ");
                if (j < BOARD_SIZE - 1) {
                    sb.append("|");
                }
            }
            sb.append("\n");
            if (i < BOARD_SIZE - 1) {
                sb.append("---+---+---\n");
            }
        }
        return sb.toString();
    }

}
