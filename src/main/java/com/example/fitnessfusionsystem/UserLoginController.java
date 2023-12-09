package com.example.fitnessfusionsystem;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class UserLoginController {
    @FXML
    private TextField userN;
    @FXML
    private PasswordField passW;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    private TextArea outputField;
    private boolean key;
    private ObservableList<User> listOfUsers = FXCollections.observableArrayList();
    private User person;

    public ObservableList<User> getListOfUsers() {
        return listOfUsers;
    }

    @FXML
    private void handleLogin(ActionEvent event) throws ExecutionException {
        String username = userN.getText();
        String password = passW.getText();

        boolean isSuccessful = firebaseAuthentication(username, password);

        if (isSuccessful) {
            // Show a pop-up
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Login Successful!");
            alert.showAndWait();
            try {
                moveToExplanation();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            displayAlert("User not found. Click register to make an account.");
        }
    }

    private boolean firebaseAuthentication(String username, String password) throws ExecutionException {
        // This part retrieves the document based on the provided email
        Query query = FitnessFusion.fstore.collection("UserRecord").whereEqualTo("NewUsername", username);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        try {
            QuerySnapshot documents = querySnapshot.get();
            for (QueryDocumentSnapshot document : documents) {
                if (Objects.equals(document.getString("Password"), password)) {
                    return true; // User found with matching email and password
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return false; // No user found or password didn't match
    }

    @FXML
    private void moveToRegistration(ActionEvent event) throws IOException {
        FitnessFusion.setRoot("Registration");

    }

    @FXML
    private void moveToExplanation() throws IOException {
        FitnessFusion.setRoot("Explanation");
    }

    private void displayAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }
}