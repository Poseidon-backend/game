package com.tic_tac_toe.game.controller;

import com.tic_tac_toe.game.model.Game;
import com.tic_tac_toe.game.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games")
public class DbController {

    @Autowired
    private DbService dbService;

    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        Game savedGame = dbService.saveUser(game);
        return ResponseEntity.ok(savedGame);
    }
}