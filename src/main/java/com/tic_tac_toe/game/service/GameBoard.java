package com.tic_tac_toe.game.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class GameBoard {
    private final static int BOARD_SIZE = 3;
    private final String[][] board;

    public GameBoard() {
        board = new String[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = "";
            }
        }
    }

    public boolean isMoveValid(int row, int column) {
        return row >= 0 && row < BOARD_SIZE && column >= 0 && column < BOARD_SIZE && board[row][column].isEmpty();
    }

    public void makeMove(int row, int column, String symbol) {
        board[row][column] = symbol;
    }

    public boolean hasWon(String symbol, int row, int column) {
        board[row][column] = symbol;
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0].equals(symbol) && board[i][1].equals(symbol) && board[i][2].equals(symbol)) {
                return true;
            }
            if (board[0][i].equals(symbol) && board[1][i].equals(symbol) && board[2][i].equals(symbol)) {
                return true;
            }
        }
        if (board[0][0].equals(symbol) && board[1][1].equals(symbol) && board[2][2].equals(symbol)) {
            return true;
        }
        if (board[0][2].equals(symbol) && board[1][1].equals(symbol) && board[2][0].equals(symbol)) {
            return true;
        }
        return false;
    }
}
