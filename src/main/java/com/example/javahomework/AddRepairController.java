package com.example.javahomework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AddRepairController {

    @FXML
    private ComboBox<String> categoryBox;
    @FXML
    private ComboBox<String> manufacturerBox;
    @FXML
    private ComboBox<String> modelBox;
    @FXML
    private ComboBox<String> technicianBox;

//    Map<String, ObservableList<String>> panelPCMap = PanelPCHelper.getInstance().getPanelMap();
//    Map<String, ObservableList<String>> printerMap = PrinterHelper.getInstance().getPrinterMap();
//    Map<String, ObservableList<String>> sparePartMap = SparePartHelper.getInstance().getTerminalMap();
//    Map<String, ObservableList<String>> terminalMap = TerminalHelper.getInstance().getTerminalMap();
//    String selectedCategory;
//    String selectedManufacturer;
//    ObservableList<String> technicianList = FXCollections.observableArrayList("Alex Black", "Tony", "Alex Banks",
//            "Amy", "Kurt", "John", "Jack", "Olivia", "Owen");

    public void initialize() {
//        ObservableList<String> categoryList = FXCollections.observableArrayList("Terminal", "Printer", "Panel PC",
//                "Spare Part");
//        ObservableList<String> manufacturerList = FXCollections.observableArrayList("Zebra", "Toshiba", "OEM");
//
//        categoryBox.getItems().setAll(categoryList);
//        manufacturerBox.getItems().setAll(manufacturerList);
//        technicianBox.getItems().setAll(technicianList);
    }

//    public void onBoxSelect() {
//
//        if (!categoryBox.getSelectionModel().isEmpty() && !manufacturerBox.getSelectionModel().isEmpty()) {
//            selectedCategory = categoryBox.getValue();
//            selectedManufacturer = manufacturerBox.getValue();
//            if (Objects.equals(selectedCategory, "Terminal"))
//                modelBox.getItems().setAll(terminalMap.get(selectedManufacturer));
//            else if (Objects.equals(selectedCategory, "Printer"))
//                modelBox.getItems().setAll(printerMap.get(selectedManufacturer));
//            else if (Objects.equals(selectedCategory, "Panel PC"))
//                modelBox.getItems().setAll(panelPCMap.get(selectedManufacturer));
//            else if (Objects.equals(selectedCategory, "Spare Part"))
//                modelBox.getItems().setAll(sparePartMap.get(selectedManufacturer));
//            else System.out.println("No model found");
//        }
//    }

    public void switchToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root, 800, 500));
        stage.setTitle("Menu");
        stage.show();
    }
}
