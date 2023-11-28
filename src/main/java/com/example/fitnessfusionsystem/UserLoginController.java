package com.example.fitnessfusionsystem;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class UserLoginController {
    @FXML
    private TextField userN, passW;
    @FXML
    private void switchToSecondary() throws IOException {
        FitnessFusion.setRoot("Registration.fxml");
    }


}
