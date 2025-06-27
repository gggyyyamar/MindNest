package com.mindnest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("🟢 Launching MindNest Sign Up Page...");

        // Load the SignUp.fxml file
        URL fxmlLocation = getClass().getResource("/views/Signup.fxml");

        if (fxmlLocation == null) {
            System.out.println("❌ ERROR: Signup.fxml not found! Make sure it's in resources/views.");
            return;
        }

        Parent root = FXMLLoader.load(fxmlLocation);

        primaryStage.setTitle("MindNest - Sign Up");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        System.out.println("🚀 Sign Up page should now be visible.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
