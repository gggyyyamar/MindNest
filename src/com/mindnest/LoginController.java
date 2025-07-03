package com.mindnest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Map;

import java.util.ArrayList;
import java.util.List;

public class LoginController {

    private Map<String, String> registeredUsers = new HashMap<>();


    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusLabel;

    @FXML
    private Button loginButton;

    @FXML
    private Button signupRedirectButton;

    // Dummy list of registered emails (simulate a database)
    private List<String> registeredEmails = new ArrayList<>();

    @FXML
    public void initialize() {
        // Pretend these are registered users
        registeredEmails.add("student1@uni.com");
        registeredEmails.add("student2@uni.com");

        // Example hardcoded users — replace with DB or file later
        registeredUsers.put("grace@example.com", "password123");
        registeredUsers.put("john@mindnest.com", "securePass");

        // Hide signup redirect button initially
        signupRedirectButton.setVisible(false);
    }

    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty()) {
            statusLabel.setText("Please enter your email.");
            return;
        }
        if (password.isEmpty()) {
            statusLabel.setText("Please enter your password.");
            return;
        }

        if (registeredEmails.contains(email)) {
            String storedPassword = registeredUsers.get(email);
            if (storedPassword != null && storedPassword.equals(password)) {
                goToDashboard(email);
            } else {
                statusLabel.setText("Incorrect password. Please try again.");
            }
        }
        else {
            statusLabel.setText("Email not found. Would you like to sign up?");
            signupRedirectButton.setVisible(true);
        }
    }

    @FXML
    private void handleSignupRedirect() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/Signup.fxml"));
            Stage stage = (Stage) signupRedirectButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("MindNest - Sign Up");
            stage.setWidth(1000);
            stage.setHeight(600);
            stage.setResizable(false);
            stage.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
            statusLabel.setText("Could not open Sign Up page.");
        }
    }

    private void goToDashboard(String email) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Dashboard.fxml"));
            Parent root = loader.load();

            DashboardController controller = loader.getController();
            controller.setStudentName(email); // Or pass a name if you stored it

            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("MindNest - Dashboard");
        } catch (Exception e) {
            e.printStackTrace();
            statusLabel.setText("Failed to load dashboard.");
        }
    }
}