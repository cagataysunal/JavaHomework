package com.example.javahomework.equipment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

public class PrinterHelper {

    private final Map<String, ObservableList<String>> printerMap;
    private static PrinterHelper printerHelper = null;

    private PrinterHelper() {
        printerMap = new HashMap<>();
        printerMap.put("Toshiba", FXCollections.observableArrayList(
                "toshibaPrinter1", "toshibaPrinter2", "toshibaPrinter3"
        ));
        printerMap.put("Zebra", FXCollections.observableArrayList(
                "zebraPrinter1", "zebraPrinter2", "zebraPrinter3"
        ));
        printerMap.put("OEM", FXCollections.observableArrayList(
                "oemPrinter1", "oemPrinter2", "oemPrinter3"
        ));
    }

    public static PrinterHelper getInstance() {
        if (printerHelper == null)
            printerHelper = new PrinterHelper();
        return printerHelper;
    }

    public Map<String, ObservableList<String>> getPrinterMap() {
        return printerMap;
    }
}


