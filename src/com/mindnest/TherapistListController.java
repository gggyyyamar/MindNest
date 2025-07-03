package com.mindnest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TherapistListController implements Initializable {

    @FXML
    private FlowPane therapistGrid;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTherapists("All");
    }

    private void loadTherapists(String category) {
        therapistGrid.getChildren().clear();

        for (int i = 1; i <= 6; i++) {
            VBox card = new VBox(10);
            card.setAlignment(Pos.CENTER);
            card.getStyleClass().add("therapist-card");

            Circle avatar = new Circle(30, Color.LIGHTGRAY);

            Label nameLabel = new Label("Therapist " + i);
            nameLabel.getStyleClass().add("therapist-name");

            Label categoryLabel = new Label(category.equals("All") ? "General Mental Health" : category);
            categoryLabel.getStyleClass().add("therapist-category");

            card.getChildren().addAll(avatar, nameLabel, categoryLabel);
            therapistGrid.getChildren().add(card);
        }

        System.out.println("Loaded category: " + category);
    }

    @FXML
    private void handleTrauma() {
        loadTherapists("Trauma Specialist");
    }

    @FXML
    private void handleDepression() {
        loadTherapists("Depression & Anxiety");
    }

    @FXML
    private void handleAddiction() {
        loadTherapists("Addiction & Recovery");
    }

    @FXML
    private void handleBackToDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Dashboard.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) therapistGrid.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("MindNest - Dashboard");
            stage.setWidth(1000);
            stage.setHeight(600);
            stage.setResizable(false);
            stage.centerOnScreen();
        } catch (IOException e) {
            System.out.println("Error loading dashboard: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
