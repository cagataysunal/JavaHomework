package com.example.javahomework;

public class Equipment {
    private String category;
    private String manufacturer;
    private String model;

    public Equipment(String category, String manufacturer, String model) {
        this.category = category;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

//  Terminal:
//      Toshiba:
//          toshibaTerminal1
//          toshibaTerminal2
//          toshibaTerminal3
//      Zebra:
//          zebraTerminal1
//          zebraTerminal2
//          zebraTerminal3
//      OEM:
//          oemTerminal1
//          oemTerminal2
//          oemTerminal3
//
//  ---
//
//  Printer:
//      Toshiba:
//          toshibaPrinter1
//          toshibaPrinter2
//          toshibaPrinter3
//      Zebra:
//          zebraPrinter1
//          zebraPrinter2
//          zebraPrinter3
//      OEM:
//          oemPrinter1
//          oemPrinter2
//          oemPrinter3
//
//  ---
//
//  PanelPC:
//      Toshiba:
//          toshibaPanel1
//          toshibaPanel2
//          toshibaPanel3
//      Zebra:
//          zebraPanel1
//          zebraPanel2
//          zebraPanel3
//      OEM:
//          oemPrinter1
//          oemPrinter3
//          oemPrinter2
//
//  ---
//
//  Spare Parts:
//      Toshiba:
//          toshibaSpare1
//          toshibaSpare3
//          toshibaSpare2
//      Zebra:
//          zebraSpare1
//          zebraSpare2
//          zebraSpare3
//      OEM:
//          oemSpare1
//          oemSpare2
//          oemSpare3

