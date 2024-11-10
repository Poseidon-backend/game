package com.tic_tac_toe.game.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Objects;

@Controller
public class StartUiController {

        @FXML
        public Button playButton;

        @FXML
        public void handlePlayButton() {
        try {
            Parent gameView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/javafx/authorization.fxml")));
            Scene gameScene = new Scene(gameView, 800, 600);
            Stage window = (Stage) playButton.getScene().getWindow();
            window.setScene(gameScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
