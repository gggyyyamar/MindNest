package com.mindnest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class DashboardController {

    private static final Logger LOGGER = Logger.getLogger(DashboardController.class.getName());

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button findButton;

    public void setStudentName(String name) {
        welcomeLabel.setText("Welcome, " + name + " to MindNest");
    }

    @FXML
    private void handleFindTherapist() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/therapist.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) findButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Find Therapist");
            stage.show();

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load therapist.fxml", e);
        }
    }

    @FXML
    private void handleBookSession() {
        System.out.println("Book Session clicked.");
    }

    @FXML
    private void handleLogout() {
        System.out.println("Logout clicked.");
    }
}
