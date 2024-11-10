package com.tic_tac_toe.game.model;

import com.tic_tac_toe.game.service.Player;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "players", schema = "public")
@Getter
@Setter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String player1;
    private String player2;
    private String currentPlayer;
    private String winner;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String board;
    private int moveCount;
    public Game() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.moveCount = 0;
        this.board = "";
    }
}