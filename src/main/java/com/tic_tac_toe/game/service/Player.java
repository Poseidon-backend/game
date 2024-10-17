package com.tic_tac_toe.game.service;

import lombok.Getter;

@Getter
public class Player {
    private final String name;
    private int score;
    private final String symbol;
    public Player(String name, String symbol){
        this.name = name;
        this.score = 0;
        this.symbol = symbol;
    }
     public void resetScore(){
        this.score = 0;
     }
     public void incrementScore(){
        this.score++;
     }
}
