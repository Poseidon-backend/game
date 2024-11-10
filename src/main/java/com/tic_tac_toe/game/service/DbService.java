package com.tic_tac_toe.game.service;

import com.tic_tac_toe.game.model.Game;
import com.tic_tac_toe.game.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {

    private final GameRepository gameRepository;

    @Autowired
    public DbService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game saveUser(Game game) {
        return gameRepository.save(game);
    }
}