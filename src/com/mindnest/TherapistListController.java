package com.mindnest;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class TherapistListController implements Initializable {

    @FXML
    private FlowPane therapistGrid;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 1; i <= 6; i++) {
            therapistGrid.getChildren().add(createTherapistCard("Therapist " + i));
        }
    }

    private VBox createTherapistCard(String name) {
        VBox card = new VBox(10);
        card.setPrefSize(150, 120);
        card.setAlignment(Pos.CENTER);
        card.setStyle("-fx-background-color: #fffde6; -fx-border-color: lightgray; -fx-border-radius: 10; -fx-background-radius: 10; -fx-padding: 10;");

        Circle circle = new Circle(25, Color.LIGHTGRAY);

        Label nameLabel = new Label(name);
        nameLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        card.getChildren().addAll(circle, nameLabel);
        return card;
    }

    @FXML
    private void handleTrauma() {
        System.out.println("Trauma filter clicked.");
    }

    @FXML
    private void handleDepression() {
        System.out.println("Depression filter clicked.");
    }

    @FXML
    private void handleAddiction() {
        System.out.println("Addiction filter clicked.");
    }
}
