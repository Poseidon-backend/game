package com.tic_tac_toe.game;

import com.tic_tac_toe.game.controller.UI_Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
public class GameApplication extends Application {

	public static void main(String[] args) {
		SpringApplication.run(GameApplication.class, args);
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/Scene.fxml"));
			StackPane root = loader.load();
			UI_Controller controller = loader.getController();
		Scene scene = new Scene(root, 600, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Tic Tac Toe");
		primaryStage.show();
	}
}


