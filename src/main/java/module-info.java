module com.example.javahomework {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javahomework to javafx.fxml;
    exports com.example.javahomework;
    exports com.example.javahomework.model;
    opens com.example.javahomework.model to javafx.fxml;
}