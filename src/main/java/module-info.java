module com.example.fitnessfusionsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires google.cloud.core;
    requires google.cloud.firestore;
    requires firebase.admin;
    requires com.google.auth.oauth2;
    requires com.google.auth;
    requires com.google.api.apicommon;

    opens com.example.fitnessfusionsystem to javafx.fxml;
    exports com.example.fitnessfusionsystem;
}