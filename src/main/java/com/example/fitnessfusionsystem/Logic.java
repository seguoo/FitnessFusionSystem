package com.example.fitnessfusionsystem;

import java.util.List;

public class Logic {
    private static String affectedDay;

    public static WorkoutPlan generateWorkoutPlan(String workoutExperience, String caloricStatus, boolean hasInjuries, List<String> affectedAreas) {
        WorkoutPlan workoutPlan = new WorkoutPlan();

        // Call determineWorkoutIntensity function
        WorkoutIntensity intensity = determineWorkoutIntensity(workoutExperience, caloricStatus, hasInjuries);

        // Add exercises to workout plan based on intensity
        switch (intensity) {
            case HIGH_INTENSITY -> addHighIntensityExercises(workoutPlan);
            case LOW_INTENSITY -> addLowIntensityExercises(workoutPlan);
            default -> addModerateIntensityExercises(workoutPlan);
        }

        // Add rehab days based on affected areas if the user has injuries
        if (hasInjuries) {
            for (String affectedArea : affectedAreas) {
                determineAffectedDay(affectedArea);
                addInjurySpecificExercises(workoutPlan, affectedArea, affectedDay);
            }
        }

        return workoutPlan;
    }

    private static void determineAffectedDay(String affectedArea) {
        // Determine the affected day based on the affected area
        switch (affectedArea) {
            case "Back" -> affectedDay = "Day 2";
            case "Head/Neck", "Hands/Wrists" -> affectedDay = "Day 5";
            case "Arms" -> affectedDay = "Day 4";
            case "Hips", "Feet/Ankles" -> affectedDay = "Day 3";
            case "Legs" -> affectedDay = "Day 6";
            default -> affectedDay = "Day 1";
        }
    }

    private static WorkoutIntensity determineWorkoutIntensity(String workoutExperience, String caloricStatus, boolean hasInjuries) {
        // Intensity is determined based on workout experience, caloric status, and injuries
        if (workoutExperience.equals("Less than 6 months")  ||
                workoutExperience.equals("6 months to 1 year")  ||
                workoutExperience.equals("1 to 3 years") && caloricStatus.equals("Caloric surplus")  ||
                workoutExperience.equals("1 to 3 years") && caloricStatus.equals("Maintenance calories")  ||
                workoutExperience.equals("More than 3 years") && caloricStatus.equals("Caloric surplus") ) {
            return WorkoutIntensity.HIGH_INTENSITY;
        } else if (workoutExperience.equals("More than 3 years") && caloricStatus.equals("Maintenance calories")  ||
                caloricStatus.equals("Caloric deficit") ) {
            return WorkoutIntensity.MODERATE_INTENSITY;
        } else {
            return WorkoutIntensity.LOW_INTENSITY;
        }
    }

    private static void addHighIntensityExercises(WorkoutPlan workoutPlan) {
        // Push Day (Day 1)
        workoutPlan.addExercise("Day 1", new WorkoutPlan.Exercise("Bench Press", 4, 6));
        workoutPlan.addExercise("Day 1", new WorkoutPlan.Exercise("Overhead Press", 4, 6));
        workoutPlan.addExercise("Day 1", new WorkoutPlan.Exercise("Incline Dumbbell Press", 4, 6));
        workoutPlan.addExercise("Day 1", new WorkoutPlan.Exercise("Dips", 4, 6));

        // Pull Day (Day 2)
        workoutPlan.addExercise("Day 2", new WorkoutPlan.Exercise("Deadlifts", 4, 6));
        workoutPlan.addExercise("Day 2", new WorkoutPlan.Exercise("Pull-ups", 4, 6));
        workoutPlan.addExercise("Day 2", new WorkoutPlan.Exercise("Barbell Rows", 4, 6));
        workoutPlan.addExercise("Day 2", new WorkoutPlan.Exercise("Face Pulls", 4, 6));

        // Leg Day (Day 3)
        workoutPlan.addExercise("Day 3", new WorkoutPlan.Exercise("Squats", 4, 6));
        workoutPlan.addExercise("Day 3", new WorkoutPlan.Exercise("Leg Press", 4, 6));
        workoutPlan.addExercise("Day 3", new WorkoutPlan.Exercise("Lunges", 4, 6));
        workoutPlan.addExercise("Day 3", new WorkoutPlan.Exercise("Leg Curls", 4, 6));

        // Push Day (Day 4)
        workoutPlan.addExercise("Day 4", new WorkoutPlan.Exercise("Incline Bench Press", 4, 6));
        workoutPlan.addExercise("Day 4", new WorkoutPlan.Exercise("Shoulder Press", 4, 6));
        workoutPlan.addExercise("Day 4", new WorkoutPlan.Exercise("Dumbbell Flyes", 4, 6));
        workoutPlan.addExercise("Day 4", new WorkoutPlan.Exercise("Tricep Dips", 4, 6));

        // Pull Day (Day 5)
        workoutPlan.addExercise("Day 5", new WorkoutPlan.Exercise("Chin-ups", 4, 6));
        workoutPlan.addExercise("Day 5", new WorkoutPlan.Exercise("Dumbbell Rows", 4, 6));
        workoutPlan.addExercise("Day 5", new WorkoutPlan.Exercise("Face Pulls", 4, 6));
        workoutPlan.addExercise("Day 5", new WorkoutPlan.Exercise("Barbell Curls", 4, 6));

        // Leg Day (Day 6)
        workoutPlan.addExercise("Day 6", new WorkoutPlan.Exercise("Leg Extensions", 4, 6));
        workoutPlan.addExercise("Day 6", new WorkoutPlan.Exercise("Calf Raises", 4, 6));
        workoutPlan.addExercise("Day 6", new WorkoutPlan.Exercise("Hamstring Curls", 4, 6));
        workoutPlan.addExercise("Day 6", new WorkoutPlan.Exercise("Plank", 4, 30));
    }

    private static void addModerateIntensityExercises(WorkoutPlan workoutPlan) {
        // Push Day (Day 1)
        workoutPlan.addExercise("Day 1", new WorkoutPlan.Exercise("Front Squats", 4, 8));
        workoutPlan.addExercise("Day 1", new WorkoutPlan.Exercise("Overhead Press", 4, 8));
        workoutPlan.addExercise("Day 1", new WorkoutPlan.Exercise("Dumbbell Bench Press", 4, 8));
        workoutPlan.addExercise("Day 1", new WorkoutPlan.Exercise("Tricep Extensions", 4, 8));

        // Pull Day (Day 2)
        workoutPlan.addExercise("Day 2", new WorkoutPlan.Exercise("Sumo Deadlifts", 4, 8));
        workoutPlan.addExercise("Day 2", new WorkoutPlan.Exercise("Chin-ups", 4, 8));
        workoutPlan.addExercise("Day 2", new WorkoutPlan.Exercise("Dumbbell Rows", 4, 8));
        workoutPlan.addExercise("Day 2", new WorkoutPlan.Exercise("Face Pulls", 4, 8));

        // Leg Day (Day 3)
        workoutPlan.addExercise("Day 3", new WorkoutPlan.Exercise("Hack Squats", 4, 8));
        workoutPlan.addExercise("Day 3", new WorkoutPlan.Exercise("Lunges", 4, 8));
        workoutPlan.addExercise("Day 3", new WorkoutPlan.Exercise("Leg Curls", 4, 8));
        workoutPlan.addExercise("Day 3", new WorkoutPlan.Exercise("Calf Raises", 4, 15));

        // Push Day (Day 4)
        workoutPlan.addExercise("Day 4", new WorkoutPlan.Exercise("Incline Bench Press", 4, 8));
        workoutPlan.addExercise("Day 4", new WorkoutPlan.Exercise("Military Press", 4, 8));
        workoutPlan.addExercise("Day 4", new WorkoutPlan.Exercise("Dumbbell Flyes", 4, 8));
        workoutPlan.addExercise("Day 4", new WorkoutPlan.Exercise("Tricep Dips", 4, 8));

        // Pull Day (Day 5)
        workoutPlan.addExercise("Day 5", new WorkoutPlan.Exercise("Pull-ups", 4, 8));
        workoutPlan.addExercise("Day 5", new WorkoutPlan.Exercise("Barbell Rows", 4, 8));
        workoutPlan.addExercise("Day 5", new WorkoutPlan.Exercise("Face Pulls", 4, 8));
        workoutPlan.addExercise("Day 5", new WorkoutPlan.Exercise("Hammer Curls", 4, 8));

        // Leg Day (Day 6)
        workoutPlan.addExercise("Day 6", new WorkoutPlan.Exercise("Leg Extensions", 4, 8));
        workoutPlan.addExercise("Day 6", new WorkoutPlan.Exercise("Hamstring Curls", 4, 8));
        workoutPlan.addExercise("Day 6", new WorkoutPlan.Exercise("Calf Raises", 4, 15));
        workoutPlan.addExercise("Day 6", new WorkoutPlan.Exercise("Plank", 4, 30));
    }

    private static void addLowIntensityExercises(WorkoutPlan workoutPlan) {
        // Push Day (Day 1)
        workoutPlan.addExercise("Day 1", new WorkoutPlan.Exercise("Dumbbell Lateral Raises", 3, 12));
        workoutPlan.addExercise("Day 1", new WorkoutPlan.Exercise("Tricep Kickbacks", 3, 12));
        workoutPlan.addExercise("Day 1", new WorkoutPlan.Exercise("Leg Raises", 3, 15));
        workoutPlan.addExercise("Day 1", new WorkoutPlan.Exercise("Push-ups", 3, 12));

        // Pull Day (Day 2)
        workoutPlan.addExercise("Day 2", new WorkoutPlan.Exercise("Dumbbell Bicep Curls", 3, 12));
        workoutPlan.addExercise("Day 2", new WorkoutPlan.Exercise("Face Pulls", 3, 12));
        workoutPlan.addExercise("Day 2", new WorkoutPlan.Exercise("Dumbbell Rows", 3, 15));
        workoutPlan.addExercise("Day 2", new WorkoutPlan.Exercise("Plank", 3, 30));

        // Leg Day (Day 3)
        workoutPlan.addExercise("Day 3", new WorkoutPlan.Exercise("Leg Extensions", 3, 12));
        workoutPlan.addExercise("Day 3", new WorkoutPlan.Exercise("Hamstring Curls", 3, 12));
        workoutPlan.addExercise("Day 3", new WorkoutPlan.Exercise("Calf Raises", 3, 15));
        workoutPlan.addExercise("Day 3", new WorkoutPlan.Exercise("Static Lunges", 3, 12));

        // Push Day (Day 4)
        workoutPlan.addExercise("Day 4", new WorkoutPlan.Exercise("Dumbbell Flyes", 3, 12));
        workoutPlan.addExercise("Day 4", new WorkoutPlan.Exercise("Dips", 3, 12));
        workoutPlan.addExercise("Day 4", new WorkoutPlan.Exercise("Lateral Raises", 3, 12));
        workoutPlan.addExercise("Day 4", new WorkoutPlan.Exercise("Push-ups", 3, 12));

        // Pull Day (Day 5)
        workoutPlan.addExercise("Day 5", new WorkoutPlan.Exercise("Face Pulls", 3, 12));
        workoutPlan.addExercise("Day 5", new WorkoutPlan.Exercise("Hammer Curls", 3, 12));
        workoutPlan.addExercise("Day 5", new WorkoutPlan.Exercise("Dumbbell Rows", 3, 15));
        workoutPlan.addExercise("Day 5", new WorkoutPlan.Exercise("Plank", 3, 30));

        // Leg Day (Day 6)
        workoutPlan.addExercise("Day 6", new WorkoutPlan.Exercise("Leg Curls", 3, 12));
        workoutPlan.addExercise("Day 6", new WorkoutPlan.Exercise("Calf Raises", 3, 15));
        workoutPlan.addExercise("Day 6", new WorkoutPlan.Exercise("Static Lunges", 3, 12));
        workoutPlan.addExercise("Day 6", new WorkoutPlan.Exercise("Plank", 3, 30));
    }


    private static void addInjurySpecificExercises(WorkoutPlan workoutPlan, String affectedAreas, String affectedDay) {
        // Overwrite exercises on the affected day based on the affected areas
        workoutPlan.removeExercises(affectedDay);

        if (affectedAreas.contains("Shoulders")) {
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Rotator Cuff Exercises", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Shoulder Mobility Drills", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Lateral Raises", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Shoulder Press", 3, 15));
        }
        if (affectedAreas.contains("Back")) {
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Lower Back Stretches", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Core Stability Exercises", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Lat Pulldowns", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Face Pulls", 3, 15));
        }
        if (affectedAreas.contains("Head/Neck")) {
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Neck Stretches", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Neck Isometric Exercises", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Head Tilts", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Neck Rotations", 3, 15));
        }
        if (affectedAreas.contains("Arms")) {
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Bicep Curls", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Tricep Extensions", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Wrist Curls", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Reverse Wrist Curls", 3, 15));
        }
        if (affectedAreas.contains("Hands/Wrists")) {
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Hand Grips", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Finger Extensions", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Wrist Flexor Stretch", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Wrist Extensor Stretch", 3, 15));
        }
        if (affectedAreas.contains("Hips")) {
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Hip Flexor Stretch", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Glute Bridges", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Hip Abduction Exercises", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Piriformis Stretch", 3, 15));
        }
        if (affectedAreas.contains("Legs")) {
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Leg Extensions", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Leg Curls", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Calf Raises", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Static Lunges", 3, 15));
        }
        if (affectedAreas.contains("Feet/Ankles")) {
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Ankle Circles", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Toe Taps", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Calf Raises", 3, 15));
            workoutPlan.addExercise(affectedDay, new WorkoutPlan.Exercise("Achilles Stretch", 3, 15));
        }
    }


    // Enum to represent workout intensity levels
    private enum WorkoutIntensity {
        HIGH_INTENSITY,
        MODERATE_INTENSITY,
        LOW_INTENSITY
    }
}

