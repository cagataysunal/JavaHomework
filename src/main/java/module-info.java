module com.example.javahomework {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javahomework to javafx.fxml;
    exports com.example.javahomework;
}