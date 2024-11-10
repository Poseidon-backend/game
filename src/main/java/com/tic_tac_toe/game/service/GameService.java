package com.tic_tac_toe.game.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final GameBoard gameBoard;
    @Getter
    private Player currentPlayer;
    private Player player1;
    private Player player2;

    public GameService() {
        this.gameBoard = new GameBoard();
    }

    public void setPlayers(Player player1, Player player2, Player currentPlayer) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = currentPlayer;
        System.out.println("Игрок 1: " + player1.name() + ", символ: " + player1.symbol());
        System.out.println("Игрок 2: " + player2.name() + ", символ: " + player2.symbol());
        System.out.println("Сравнение символа игрока 1: " + player1.symbol().equals("X"));
        System.out.println("Текущий игрок: " + currentPlayer.name() + ", символ: " + currentPlayer.symbol());
    }

    public boolean isMakeMove(int row, int column) {
        if (gameBoard.isMoveValid(row, column)) {
            gameBoard.makeMove(row, column, currentPlayer.symbol());
            System.out.println("Ход выполнен");
            return true;
        }
        System.out.println("Ход не выполнен - ячейка занята или вне границ.");
        System.out.println(currentPlayer);
        return false;
    }

    public void switchPlayers() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else if (currentPlayer == player2) {
            currentPlayer = player1;
        }
    }

    public void resetGame() {
        gameBoard.initializeBoard();
        setPlayers(player1, player2, currentPlayer);
    }
}
