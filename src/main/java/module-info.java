module com.example.project_jfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.project_jfx to javafx.fxml;
    exports com.example.project_jfx;
    exports com.example.partie1;
    exports com.example.Partie2;
    exports com.example.Exercice1;
    exports com.example.Exercice2;
    exports com.example.Exercice4;
    exports com.example.Exercice6;
}