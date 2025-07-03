package com.mindnest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SignupController {

    private static final Logger logger = Logger.getLogger(SignupController.class.getName());

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private ComboBox<String> userTypeCombo;

    @FXML
    private Label statusLabel;

    @FXML
    private Button signupButton;

    @FXML
    private Button loginRedirectButton;

    @FXML
    public void initialize() {
        if (userTypeCombo.getItems().isEmpty()) {
            userTypeCombo.getItems().addAll("Student", "Therapist");
        }
    }

    @FXML
    private void handleSignup() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirm = confirmPasswordField.getText();
        String userType = userTypeCombo.getValue();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirm.isEmpty() || userType == null) {
            statusLabel.setText("Please fill all fields.");
            return;
        }

        if (!password.equals(confirm)) {
            statusLabel.setText("Passwords do not match.");
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
            stage.setWidth(1000);
            stage.setHeight(600);
            stage.setResizable(false);
            stage.centerOnScreen();

        } catch (Exception e) {
            statusLabel.setText("Error loading dashboard.");
            logger.log(Level.SEVERE, "Failed to load Dashboard.fxml", e);
        }
    }

    @FXML
    private void handleLoginRedirect() {
        try {
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
            Stage stage = (Stage) loginRedirectButton.getScene().getWindow();
            stage.setScene(new Scene(loginRoot));
            stage.setTitle("MindNest - Login");
        } catch (Exception e) {
            statusLabel.setText("Error opening Login page.");
            logger.log(Level.SEVERE, "Failed to load Login.fxml", e);
        }
    }
}
