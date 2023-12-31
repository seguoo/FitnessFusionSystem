package com.example.fitnessfusionsystem;


import java.util.*;

public class WorkoutPlan {
    private final Map<String, List<Exercise>> workoutDays;

    public WorkoutPlan() {
        this.workoutDays = new HashMap<>();
        // Initialize workout days
        workoutDays.put("Day 1", new ArrayList<>());
        workoutDays.put("Day 2", new ArrayList<>());
        workoutDays.put("Day 3", new ArrayList<>());
        workoutDays.put("Day 4", new ArrayList<>());
        workoutDays.put("Day 5", new ArrayList<>());
        workoutDays.put("Day 6", new ArrayList<>());
    }

    public void addExercise(String day, Exercise exercise) {
        List<Exercise> exercises = workoutDays.get(day);
        if (exercises != null) {
            exercises.add(exercise);
        }
    }

    public void removeExercises(String day) {
        List<Exercise> exercises = workoutDays.get(day);
        if (exercises != null) {
            exercises.clear();
        }
    }

    public Map<String, List<Exercise>> getWorkoutDays() {
        return workoutDays;
    }

    public record Exercise(String name, int sets, int repetitions) {
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, List<Exercise>> entry : workoutDays.entrySet()) {
            String day = entry.getKey();
            List<Exercise> exercises = entry.getValue();
            String dayType;

            if (day.contains("Day 1") || day.contains("Day 4")) {
                dayType = "Push";
            } else if (day.contains("Day 2") || day.contains("Day 5")) {
                dayType = "Pull";
            } else if (day.contains("Day 3") || day.contains("Day 6")) {
                dayType = "Legs";
            } else {
                dayType = "Rest";
            }

            stringBuilder.append(day).append(" ").append(dayType).append("\n");
            for (Exercise exercise : exercises) {
                stringBuilder.append("Exercise: ").append(exercise.name())
                        .append(", Sets: ").append(exercise.sets())
                        .append(", Repetitions: ").append(exercise.repetitions())
                        .append("\n");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }


}


