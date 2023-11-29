package com.example.fitnessfusionsystem;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.auth.FirebaseAuth;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

public class FitnessFusion extends Application {
    @FXML
    public ImageView regScreen, logScreen;

    private static Scene scene;
    public static Firestore fstore;
    public static FirebaseAuth fauth;
    public final FirestoreContext contextFirebase = new FirestoreContext();
    /*
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("explanation"));
        stage.setScene(scene);
        stage.show();
    }
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        fstore = contextFirebase.firebase();
        fauth = FirebaseAuth.getInstance();


        scene = new Scene(loadFXML("Login.fxml"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FitnessFusion.class.getResource(fxml ));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
