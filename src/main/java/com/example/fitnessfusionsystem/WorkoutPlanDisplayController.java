package com.example.fitnessfusionsystem;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class WorkoutPlanDisplayController {
    @FXML
    private TextArea workoutPlanTextArea; // Assuming TextArea to display the workout plan

    private final WorkoutPlan workoutPlan;

    // Constructor to receive the workout plan
    public WorkoutPlanDisplayController(WorkoutPlan workoutPlan) {
        this.workoutPlan = workoutPlan;
    }

    public void initialize() {
        // Display the workout plan in the TextArea or any other UI element
        workoutPlanTextArea.setText(workoutPlan.toString());
    }
}


