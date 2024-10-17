package com.tic_tac_toe.game.service;

import com.tic_tac_toe.game.model.Game;
import com.tic_tac_toe.game.repository.GameRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class GameService {
    private GameRepository gameRepository;

    @Setter
    private GameBoard gameBoard;

    private final List<String> playersNames;
    private final List<String> playersSymbols;
    private GameStatus status;
    private int currentPlayerIndex;

    public GameService(GameBoard gameBoard) {
        this.gameBoard = new GameBoard();
        this.playersNames = new ArrayList<>();
        this.playersSymbols = new ArrayList<>();
        this.status = GameStatus.IN_PROGRESS;
        this.currentPlayerIndex = 0;
    }

    public void addPlayer(String name, String symbol) {
        playersNames.add(name);
        playersSymbols.add(symbol);
    }

    public void makeMove(int row, int column) {
        if (gameBoard.isMoveLegal(row, column)) {
            gameBoard.makeMove(row, column, playersSymbols.get(currentPlayerIndex));
            switchPlayer();
        } else {
            throw new IllegalArgumentException("Invalid move");
        }
    }

    public void startGame(List<String> playersNames, List<String> playersSymbols) {
        // Проверяем, что в игре участвуют как минимум 2 игрока
        if (playersNames.size() < 2 || playersSymbols.size() < 2) {
            throw new IllegalArgumentException("At least 2 players are required to start the game.");
        }
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < playersNames.size(); i++) {
            Player player = new Player(playersNames.get(i), playersSymbols.get(i));
            players.add(player);
        }
        gameBoard.initializeBoard();
        status = GameStatus.IN_PROGRESS;
        currentPlayerIndex = 0;

        Game game = new Game();
        game.setPlayer1(playersNames.get(0));
        game.setPlayer2(playersNames.get(1));
        game.setBoard(gameBoard.toString());
        game.setMoveCount(gameBoard.getMoveCount());
        game.setCreatedAt(LocalDateTime.now());
        game.setUpdatedAt(LocalDateTime.now());
        gameRepository.save(game);

    }

    public void resetGame() {
        gameBoard.initializeBoard();
        currentPlayerIndex = 0;
        status = GameStatus.IN_PROGRESS;
    }

    private void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % playersNames.size();
    }

    public Player getWinner() {
        if (gameBoard.hasWon(playersSymbols.get(currentPlayerIndex))) {
            status = GameStatus.WIN;
            return new Player(playersNames.get(currentPlayerIndex), playersSymbols.get(currentPlayerIndex));
        } else if (gameBoard.isBoardFull()) {
            status = GameStatus.DRAW;
            return null;
        } else {
            return null;
        }
    }

    public String getStatus() {
        if (status == GameStatus.WIN) {
            return "Player " + playersNames.get(currentPlayerIndex) + " wins!";
        } else if (status == GameStatus.DRAW) {
            return "It's a draw!";
        } else {
            return "Current player: " + playersNames.get(currentPlayerIndex);
        }
    }

    public Game getGame(Long id) {
        return gameRepository.findById(id).orElse(null);
    }

    public Game updateGame(Game game) {
        game.setUpdatedAt(LocalDateTime.now());
        game.setBoard(gameBoard.toString());
        game.setMoveCount(gameBoard.getMoveCount());
        return gameRepository.save(game);
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }

}