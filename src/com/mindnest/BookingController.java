package com.mindnest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookingController {

    private static final Logger LOGGER = Logger.getLogger(BookingController.class.getName());
    @FXML private Label therapistName;
    @FXML private Label therapistSpecialty;
    @FXML private Label therapistRating;
    @FXML private TextArea therapistBio;
    @FXML private DatePicker datePicker;
    @FXML private ComboBox<String> timeComboBox;
    @FXML private Button bookButton;
    @FXML private Button backButton;
    @FXML private ImageView therapistImage;
    private String name;
    private String specialty;
    private String bio;

    public void setTherapistData(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;

        this.bio = name + " has over 10 years of experience in " + specialty + ". Specializing in mindfulness, trauma recovery, and academic balance.";
    }

    @FXML
    public void initialize() {
        therapistName.setText(name != null ? name : "Unknown");
        therapistSpecialty.setText("Specialty: " + (specialty != null ? specialty : "N/A"));
        therapistBio.setText(bio != null ? bio : "No bio available.");

        bookButton.setOnAction(e -> bookAppointment());
        backButton.setOnAction(e -> goBack());
    }

    private void bookAppointment() {
        String date = datePicker.getValue() != null ? datePicker.getValue().toString() : "";
        String time = timeComboBox.getValue();

        if (date.isEmpty() || time == null) {
            showAlert("Please select both date and time.");
            return;
        }

        showAlert("✅ Appointment booked with " + name + " on " + date + " at " + time);
    }

    private void goBack() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/therapist.fxml"));
            Stage stage = (Stage) backButton.getScene().getWindow(); // Get current window
            stage.setScene(new Scene(root));
            stage.setTitle("Find Therapist");
            stage.setWidth(1000);
            stage.setHeight(600);
            stage.setResizable(false);
            stage.centerOnScreen();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load Find Therapist page", e);
        }
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Booking Info");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
