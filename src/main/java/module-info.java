module com.example.project_jfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.project_jfx to javafx.fxml;
    exports com.example.project_jfx;
    exports com.example.partie1;
}