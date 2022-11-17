module com.example.javahomework {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javahomework to javafx.fxml;
    exports com.example.javahomework;
    exports com.example.javahomework.equipment;
    opens com.example.javahomework.equipment to javafx.fxml;
}