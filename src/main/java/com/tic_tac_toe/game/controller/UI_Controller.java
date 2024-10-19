package com.tic_tac_toe.game.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UI_Controller {

        @FXML
        public Label welcomeText;

        @FXML
        protected void onHelloButtonClick() {
            welcomeText.setText("Welcome to JavaFX Application!");
        }
    }
