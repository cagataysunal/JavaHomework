package com.example.javahomework.model.equipment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

public class TerminalHelper {

    private final Map<String, ObservableList<String>> terminalMap;
    private static TerminalHelper terminalHelper = null;

    private TerminalHelper() {
        terminalMap = new HashMap<>();
        terminalMap.put("Toshiba", FXCollections.observableArrayList(
                "toshibaTerminal1", "toshibaTerminal2", "toshibaTerminal3"
        ));
        terminalMap.put("Zebra", FXCollections.observableArrayList(
                "zebraTerminal1", "zebraTerminal2", "zebraTerminal3"
        ));
        terminalMap.put("OEM", FXCollections.observableArrayList(
                "oemTerminal1", "oemTerminal2", "oemTerminal3"
        ));
    }

    public static TerminalHelper getInstance() {
        if (terminalHelper == null)
            terminalHelper = new TerminalHelper();
        return terminalHelper;
    }

    public Map<String, ObservableList<String>> getTerminalMap() {
        return terminalMap;
    }
}
