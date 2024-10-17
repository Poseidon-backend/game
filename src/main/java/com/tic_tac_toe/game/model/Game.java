package com.tic_tac_toe.game.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "games")
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
}