module com.example.fitnessfusionsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.fitnessfusionsystem to javafx.fxml;
    exports com.example.fitnessfusionsystem;
}