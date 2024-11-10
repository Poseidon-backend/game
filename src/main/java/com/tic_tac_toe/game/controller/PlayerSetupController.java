package com.tic_tac_toe.game.controller;

import com.tic_tac_toe.game.model.Game;
import com.tic_tac_toe.game.service.DbService;
import com.tic_tac_toe.game.service.GameService;
import com.tic_tac_toe.game.service.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class PlayerSetupController {

    @FXML
    public Button startGameButton;

    @FXML
    private TextField player1NameField;
    @FXML
    private TextField player2NameField;
    @FXML
    private ChoiceBox<String> player1SymbolChoice;
    @FXML
    private ChoiceBox<String> player2SymbolChoice;


    @Setter
    private GameService gameService = new GameService();

    public PlayerSetupController() {
    }


    @FXML
    public void handleStartGameButton() {
        System.out.println("Кнопка нажата");
        if (handleCheck()) {
            openGameWindow();
        }
    }
    @FXML
    public boolean handleCheck() {
        String name1 = player1NameField.getText().trim();
        String symbol1 = player1SymbolChoice.getValue();
        String name2 = player2NameField.getText().trim();
        String symbol2 = player2SymbolChoice.getValue();

        if (name1.isEmpty() || name2.isEmpty()) {
            showAlert("Имя обоих игроков не может быть пустым.");
            return false;
        }

        if (symbol1 == null || symbol2 == null) {
            showAlert("Выберите символ для обоих игроков.");
            return false;
        }

        if (name1.equals(name2)) {
            showAlert("Игроки не могут иметь одинаковые имена.");
            return false;
        }

        if (symbol1.equals(symbol2)) {
            showAlert("Игроки не могут иметь одинаковые символы.");
            return false;
        }

        Player player1 = new Player(name1, symbol1);
        Player player2 = new Player(name2, symbol2);
        Player currentPlayer = symbol1.equals("X") ? player1 : player2;
        gameService.setPlayers(player1, player2, currentPlayer);


        Game game = new Game();
        game.setPlayer1(player1.name());
        game.setPlayer2(player2.name());


        System.out.println("Проверки пройдены, игроки установлены: " + player1 + ", " + player2 + ", " + currentPlayer);
        return true;
    }

    @FXML
    private void openGameWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafx/game.fxml"));
            GridPane root = loader.load();
            GameController gameController = loader.getController();
            gameController.setGameService(gameService);
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root, 800, 600));
            Stage window = (Stage) startGameButton.getScene().getWindow();
            newStage.setTitle("Крестики-Нолики");
            newStage.show();
            Stage currentStage = (Stage) startGameButton.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}