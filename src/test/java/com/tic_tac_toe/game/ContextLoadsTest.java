package com.tic_tac_toe.game;

import com.tic_tac_toe.game.controller.UI_Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = GameApplication.class)
class SpringBootJavaFXConfigurationTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        // Проверяем, что контекст приложения загружается без ошибок
        assertThat(context).isNotNull();
    }


    @Test
    void ensureJavaFXBeansLoaded() {
        // Проверяем, что бины JavaFX были загружены
        assertThat(context.containsBean("javafxApplication")).isTrue();
        assertThat(context.getBean("javafxApplication")).isNotNull();
    }

    @Test
    void ensureJavaFXConfigurationIsValid() {
        // Проверяем, что конфигурация JavaFX корректна
        assertThat(System.getProperty("javafx.version")).isNotNull();
        assertThat(System.getProperty("javafx.platform")).isNotNull();
    }

    @Test
    void ensureSpringBootVersionIsCompatible() {
        // Проверяем, что используется ожидаемая версия Spring Boot
        assertThat(SpringBootVersion.getVersion()).isEqualTo("3.2.10");
    }

    @Test
    void ensureJavaFXVersionIsCompatible() {
        // Проверяем, что используется ожидаемая версия JavaFX
        assertThat(System.getProperty("javafx.version")).isEqualTo("17.0.2");
    }
}