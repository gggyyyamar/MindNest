package com.mindnest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    private Label welcomeLabel;

    public void setStudentName(String name) {
        welcomeLabel.setText("Welcome, " + name + " to MindNest");
    }

    @FXML
    private void handleFindTherapist() {
        System.out.println("Find Therapist clicked.");
        // TODO: Load TherapistList.fxml
    }

    @FXML
    private void handleBookSession() {
        System.out.println("Book Session clicked.");
        // TODO: Load Booking.fxml
    }

    @FXML
    private void handleLogout() {
        System.out.println("Logout clicked.");
        // TODO: Navigate back to login/signup
    }
}
