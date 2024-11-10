module com.tic_tac_toe.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.web;
    requires spring.context;
    requires spring.data.jpa;
    requires static lombok;
    requires spring.beans;
    requires spring.boot.autoconfigure;
    requires org.apache.tomcat.embed.core;
    requires jakarta.persistence;

    opens com.tic_tac_toe.game.controller to javafx.fxml;
    opens com.tic_tac_toe.game to javafx.fxml;
    exports com.tic_tac_toe.game;
}