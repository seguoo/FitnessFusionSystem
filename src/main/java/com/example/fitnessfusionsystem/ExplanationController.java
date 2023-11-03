/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.fitnessfusionsystem;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ExplanationController {
    @FXML
    private Button startSurveyButton;

    @FXML
    protected void startSurveyButtonClicked(ActionEvent event) throws IOException {
        FitnessFusion.setRoot("survey"); // Navigate to the survey screen when the button is clicked
        
    }
}
