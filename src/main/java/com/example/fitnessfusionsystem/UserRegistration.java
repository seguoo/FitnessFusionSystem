package com.example.fitnessfusionsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UserRegistration {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField fName, lName, email, passW1, newU;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}