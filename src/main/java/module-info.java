module com.example.javahomework {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javahomework to javafx.fxml;
    exports com.example.javahomework;
    exports com.example.javahomework.model.equipment;
    opens com.example.javahomework.model.equipment to javafx.fxml;
    exports com.example.javahomework.controller;
    opens com.example.javahomework.controller to javafx.fxml;
}