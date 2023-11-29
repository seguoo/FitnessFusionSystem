package com.example.fitnessfusionsystem;

import com.google.cloud.firestore.WriteResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import com.google.cloud.firestore.DocumentReference;
import com.google.api.core.ApiFuture;
import java.util.Map;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class UserRegistrationController {
    @FXML
    private Label welcomeText, testFN, testLN, testEM, testPA, testNU, testA, testW;
    @FXML
    private TextField fName, lName, email, passW1, newU, gender, age, weight;
    @FXML
    private RadioButton rButtonMale, rButtonFemale;
    @FXML
    private void addRecord(ActionEvent event) {
        addData();
    }

    boolean flag = false;

    public void initialize() {
        fName.setOnKeyPressed(key -> {

            if (key.getCode() != KeyCode.TAB && flag) {
                fName.setStyle("-fx-border-color: lightgreen ; -fx-border-width: 4px ;");
                testFN.setText("");

                flag = false;
            }

        });
        fName.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("First name text is focused");
            } else {
                if (fName.getText().matches("[a-zA-Z]{2,25}")) {
                    fName.setEditable(false);
                    fName.setBorder(null);
                } else {

                    fName.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    fName.setVisible(true);
                    fName.requestFocus();
                    testFN.setText(fName.getText() + " is not valid first name");
                    flag = true;
                }

            }
        });
        lName.setOnKeyPressed(key -> {

            if (key.getCode() != KeyCode.TAB && flag) {
                lName.setStyle("-fx-border-color: lightgreen ; -fx-border-width: 4px ;");
                testLN.setText("");

                flag = false;
            }

        });
        lName.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Last name text is focused");
            } else {
                if (lName.getText().matches("[a-zA-Z]{2,25}")) {
                    lName.setEditable(false);
                    lName.setBorder(null);
                } else {

                    lName.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    lName.setVisible(true);
                    lName.requestFocus();
                    testLN.setText(lName.getText() + " is not valid last name");
                    flag = true;
                }

            }
        });
        email.setOnKeyPressed(key -> {

            if (key.getCode() != KeyCode.TAB && flag) {
                email.setStyle("-fx-border-color: lightgreen ; -fx-border-width: 4px ;");
                testEM.setText("");

                flag = false;
            }

        });
        email.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Email text is focused");
            } else {
                if (email.getText().matches("^(.+)@(.+)$*")) {
                    email.setEditable(false);
                    email.setBorder(null);
                } else {

                    email.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    email.setVisible(true);
                    email.requestFocus();
                    testEM.setText(email.getText() + " is not valid email");
                    flag = true;
                }

            }
        });
        passW1.setOnKeyPressed(key -> {

            if (key.getCode() != KeyCode.TAB && flag) {
                passW1.setStyle("-fx-border-color: lightgreen ; -fx-border-width: 4px ;");
                testPA.setText("");

                flag = false;
            }

        });
        passW1.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Password text is focused");
            } else {
                if (passW1.getText().matches("[a-zA-Z0-9]{8,25}")) {
                    passW1.setEditable(false);
                    passW1.setBorder(null);
                } else {

                    passW1.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    passW1.setVisible(true);
                    passW1.requestFocus();
                    testPA.setText(passW1.getText() + " invalid needs 8 inputs");
                    flag = true;
                }

            }
        });
        newU.setOnKeyPressed(key -> {

            if (key.getCode() != KeyCode.TAB && flag) {
                newU.setStyle("-fx-border-color: lightgreen ; -fx-border-width: 4px ;");
                testNU.setText("");

                flag = false;
            }

        });
        newU.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("New username text is focused");
            } else {
                if (newU.getText().matches("[a-zA-Z0-9]{2,25}")) {
                    newU.setEditable(false);
                    newU.setBorder(null);
                } else {

                    newU.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    newU.setVisible(true);
                    newU.requestFocus();
                    testNU.setText(newU.getText() + " invalid username");
                    flag = true;
                }

            }
        });
        age.setOnKeyPressed(key -> {

            if (key.getCode() != KeyCode.TAB && flag) {
                age.setStyle("-fx-border-color: lightgreen ; -fx-border-width: 4px ;");
                testA.setText("");

                flag = false;
            }

        });
        age.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Age text is focused");
            } else {
                if (age.getText().matches("[0-9]{2,3}")) {
                    age.setEditable(false);
                    age.setBorder(null);
                } else {

                    age.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    age.setVisible(true);
                    age.requestFocus();
                    testA.setText(age.getText() + " is an invalid age");
                    flag = true;
                }

            }
        });
        weight.setOnKeyPressed(key -> {

            if (key.getCode() != KeyCode.TAB && flag) {
                weight.setStyle("-fx-border-color: lightgreen ; -fx-border-width: 4px ;");
                testW.setText("");

                flag = false;
            }

        });
        weight.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Weight text is focused");
            } else {
                if (weight.getText().matches("[0-9]{2,3}")) {
                    weight.setEditable(false);
                    weight.setBorder(null);
                } else {

                    weight.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    weight.setVisible(true);
                    weight.requestFocus();
                    testW.setText(weight.getText() + " is an invalid weight");
                    flag = true;
                }

            }
        });


        }
    @FXML
    protected void onHelloButtonClick () {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void selectGender (ActionEvent event) {

        if(rButtonMale.isSelected()) {
            gender.setText(rButtonMale.getText());
        }

        else if (rButtonFemale.isSelected()) {
            gender.setText(rButtonFemale.getText());
        }
    }

    @FXML
    private void switchBackStage() throws IOException {
        FitnessFusion.setRoot("Login.fxml");
    }


    public void addData() {

        DocumentReference docRef = FitnessFusion.fstore.collection("UserRecord").document(UUID.randomUUID().toString());

        Map<String, Object> data = new HashMap<>();
        data.put("FirstName", fName.getText());
        data.put("LastName", lName.getText());
        data.put("Email", email.getText());
        data.put("Password", passW1.getText());
        data.put("NewUsername", newU.getText());
        data.put("Gender", gender.getText());
        data.put("Age", age.getText());
        data.put("Weight", Double.parseDouble(weight.getText()));


        ApiFuture<WriteResult> result = docRef.set(data);

        System.out.println("Successfully sent new user information to database!");
    }


}