package com.example.fitnessfusionsystem;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class FitnessFusion extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("path/to/serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://fitness-fusion-9ef62-default-rtdb.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
        scene = new Scene(loadFXML("explanation"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FitnessFusion.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
