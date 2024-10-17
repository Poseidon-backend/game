package com.tic_tac_toe.game.controller;

import com.tic_tac_toe.game.service.GameService;
import com.tic_tac_toe.game.service.Player;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/start")
    public ResponseEntity<String> startGame(
            @RequestParam List<String> playersNames,
            @RequestParam List<String> playersSymbols
    ) {
        gameService.startGame(playersNames, playersSymbols);
        return ResponseEntity.ok("Game started");
    }

    @PostMapping("/move")
    public ResponseEntity<String> makeMove(@RequestParam int row, @RequestParam int col) {
        try {
            gameService.makeMove(row, col);
            return ResponseEntity.ok("Move made");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/status")
    public ResponseEntity<String> getGameStatus() {
        return ResponseEntity.ok(gameService.getStatus());
    }

    @GetMapping("/winner")
    public ResponseEntity<Player> getWinner() {
        return ResponseEntity.ok(gameService.getWinner());
    }

    @PostMapping("/reset")
    public ResponseEntity<String> resetGame() {
        gameService.resetGame();
        return ResponseEntity.ok("Game reset");
    }
}

