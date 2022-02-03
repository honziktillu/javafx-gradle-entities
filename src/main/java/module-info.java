module com.example.javafxgradle {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.javafxgradle to javafx.fxml;
    exports com.example.javafxgradle;
}