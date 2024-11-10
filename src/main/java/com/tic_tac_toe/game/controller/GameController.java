package com.tic_tac_toe.game.controller;

import com.tic_tac_toe.game.service.GameBoard;
import com.tic_tac_toe.game.service.GameService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

    @FXML
    private Button cell00;
    @FXML
    private Button cell01;
    @FXML
    private Button cell02;
    @FXML
    private Button cell10;
    @FXML
    private Button cell11;
    @FXML
    private Button cell12;
    @FXML
    private Button cell20;
    @FXML
    private Button cell21;
    @FXML
    private Button cell22;

    @Setter
    private GameBoard gameBoard = new GameBoard();
    @Setter
    private GameService gameService = new GameService();

    @FXML
    public void makeMove(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        System.out.println("ID кнопки: " + clickedButton.getId());
        String cellId = clickedButton.getId().replace("cell", "");
        int row = Character.getNumericValue(cellId.charAt(0));
        int column = Character.getNumericValue(cellId.charAt(1));

        if (gameService.isMakeMove(row, column)) {
            clickedButton.setText(gameService.getCurrentPlayer().symbol());

            if (gameBoard.hasWon(gameService.getCurrentPlayer().symbol(), row, column)) {
                System.out.println("Победа " + gameService.getCurrentPlayer().symbol());
            } else {
                gameService.switchPlayers();
            }
        }
    }

    @FXML
    private void resetGame() {
        gameService.resetGame();
        resetButtons();
    }

    private void resetButtons() {
        cell00.setText("");
        cell01.setText("");
        cell02.setText("");
        cell10.setText("");
        cell11.setText("");
        cell12.setText("");
        cell20.setText("");
        cell21.setText("");
        cell22.setText("");
    }
}