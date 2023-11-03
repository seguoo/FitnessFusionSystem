/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.fitnessfusionsystem;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import java.util.Collections;

public class SurveyController {
    @FXML
    private ComboBox<String> workoutExperienceComboBox;
    @FXML
    private ComboBox<String> caloricStatusComboBox;
    @FXML
    private CheckBox injuriesCheckBox;
    @FXML
    private VBox injuriesAreasBox;
    @FXML
    private Button confirmButton;

    private final Logic logic = new Logic();


    @FXML
    protected void initialize() {
        // Initialize ComboBox items
        workoutExperienceComboBox.setItems(FXCollections.observableArrayList("Less than 6 months", "6 months to 1 year", "1 to 3 years", "More than 3 years"));
        caloricStatusComboBox.setItems(FXCollections.observableArrayList("Caloric surplus", "Caloric deficit", "Maintenance calories"));
    }

    @FXML
    protected void confirmButtonClicked(ActionEvent event) {
        // Handle the button click event, process survey answers
        String workoutExperience = workoutExperienceComboBox.getValue();
        String caloricStatus = caloricStatusComboBox.getValue();
        boolean hasInjuries = injuriesCheckBox.isSelected();

        // Get selected injury areas
        StringBuilder selectedAreas = new StringBuilder();
        if (hasInjuries) {
            for (javafx.scene.Node node : injuriesAreasBox.getChildren()) {
                if (node instanceof CheckBox checkBox) {
                    if (checkBox.isSelected()) {
                        selectedAreas.append(checkBox.getText()).append(", ");
                    }
                }
            }
        }
        // Remove the trailing comma and space
        String affectedAreas = selectedAreas.toString().replaceAll(", $", "");

        // Call the generateWorkoutPlan method from the Logic class
        WorkoutPlan workoutPlan = Logic.generateWorkoutPlan(workoutExperience, caloricStatus, hasInjuries, Collections.singletonList(affectedAreas));

        // Print the generated workout plan
        System.out.println("Generated Workout Plan:");
        System.out.println(workoutPlan);
    }

}




