package com.mindnest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    @Override
    public void start(Stage primaryStage) {
        try {
            URL fxmlLocation = getClass().getResource("/views/login.fxml");

            if (fxmlLocation == null) {
                LOGGER.severe("therapist.fxml not found in /views.");
                return;
            }

            Parent root = FXMLLoader.load(fxmlLocation);
            Scene scene = new Scene(root, 900, 600);

            primaryStage.setTitle("MindNest - Therapist Finder");
            primaryStage.setScene(scene);
            primaryStage.setWidth(1000);
            primaryStage.setHeight(600);
            primaryStage.setResizable(false); // Optional, for consistent layout
            primaryStage.centerOnScreen();
            primaryStage.show();

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error loading therapist.fxml", e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
