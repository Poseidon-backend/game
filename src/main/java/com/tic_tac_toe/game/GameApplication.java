package com.tic_tac_toe.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApplication extends Application {

@Override
public void start(Stage stage) throws IOException {
	FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("hello-view.fxml"));
	Scene scene = new Scene(fxmlLoader.load(), 320, 240);
	stage.setTitle("Hello!");
	stage.setScene(scene);
	stage.show();
}

public static void main(String[] args) {
	launch();
}
}



