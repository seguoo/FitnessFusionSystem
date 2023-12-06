/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.fitnessfusionsystem;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

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
        // Handle confirm button click, process survey answers
        String workoutExperience = workoutExperienceComboBox.getValue();
        String caloricStatus = caloricStatusComboBox.getValue();
        boolean hasInjuries = injuriesCheckBox.isSelected();

        // Get selected injury areas
        List<String> affectedAreasList = new ArrayList<>();
        if (hasInjuries) {
            for (javafx.scene.Node node : injuriesAreasBox.getChildren()) {
                if (node instanceof CheckBox checkBox) {
                    if (checkBox.isSelected()) {
                        affectedAreasList.add(checkBox.getText());
                    }
                }
            }
        }

        // Generate workout plan
        WorkoutPlan workoutPlan = Logic.generateWorkoutPlan(workoutExperience, caloricStatus, hasInjuries, affectedAreasList);

        // Convert WorkoutPlan object into a Map<String, Object>
        Map<String, Object> workoutPlanData = new HashMap<>();
        workoutPlanData.put("Plan", workoutPlan.toString()); // Convert workout plan to string and save it

        // Store workout plan in Firestore
        DocumentReference docRef = FitnessFusion.fstore.collection("WorkoutPlans").document(UUID.randomUUID().toString());
        // Asynchronously write data
        ApiFuture<WriteResult> result = docRef.set(workoutPlanData);

        System.out.println("Successfully sent workout plan to database!");

        // Load the workout plan display screen
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WorkoutPlanDisplay.fxml"));

            // Provide the workout plan through the constructor
            loader.setController(new WorkoutPlanDisplayController(workoutPlan));

            Parent workoutPlanDisplayParent = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Workout Plan Display");
            stage.setScene(new Scene(workoutPlanDisplayParent));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}