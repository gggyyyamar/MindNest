package com.mindnest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DashboardController {

    private static final Logger LOGGER = Logger.getLogger(DashboardController.class.getName());

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button findButton;

    @FXML
    private Button bookButton;

    @FXML
    private Button logoutButton;

    // Called by Signup/Login to personalize dashboard
    public void setStudentName(String name) {
        welcomeLabel.setText("Welcome, " + name + " to MindNest");
    }

    @FXML
    private void handleFindTherapist() {
        switchScene("/views/therapist.fxml", "Find Therapist");
    }

    @FXML
    private void handleBookSession() {
        switchScene("/views/book.fxml", "Book a Session");
    }

    @FXML
    private void handleLogout() {
        switchScene("/views/Login.fxml", "MindNest - Login");
    }

    private void switchScene(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = (Stage) logoutButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.setWidth(1000);
            stage.setHeight(600);
            stage.setResizable(false);
            stage.centerOnScreen();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load " + fxmlPath, e);
        }
    }
}
