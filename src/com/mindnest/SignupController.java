package com.mindnest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.logging.Logger;
import java.util.logging.Level;

public class SignupController {

    private static final Logger logger = Logger.getLogger(SignupController.class.getName());

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusLabel;

    @FXML
    private Button signupButton;

    @FXML
    private void handleSignup() {
        String name = fullNameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Please fill all fields.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Dashboard.fxml"));
            Parent dashboardRoot = loader.load();

            DashboardController controller = loader.getController();
            controller.setStudentName(name);

            Stage stage = (Stage) signupButton.getScene().getWindow();
            stage.setScene(new Scene(dashboardRoot));
            stage.setTitle("MindNest - Dashboard");

        } catch (Exception e) {
            statusLabel.setText("Error loading dashboard.");
            logger.log(Level.SEVERE, "Failed to load Dashboard.fxml", e);
        }
    }
}
