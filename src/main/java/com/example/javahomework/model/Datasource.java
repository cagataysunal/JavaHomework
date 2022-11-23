package com.example.javahomework.model;


import java.sql.*;

public class Datasource {
    public static final String DB_NAME = "tech_support.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + System.getProperty("user.dir") + "/" + DB_NAME;

    private Connection conn;

    public static final String TABLE_CUSTOMERS = "customer";
    public static final String COLUMN_CUSTOMER_ID = "_id";
    public static final String COLUMN_CUSTOMER_TITLE = "title";
    public static final String COLUMN_CUSTOMER_TAX_ADMINISTRATION = "tax_administration";
    public static final String COLUMN_CUSTOMER_TAX_NUMBER = "tax_number";
    public static final String COLUMN_CUSTOMER_E_MAIL = "e_mail";
    public static final String COLUMN_CUSTOMER_PHONE = "phone";
    public static final String COLUMN_CUSTOMER_CITY = "city";
    public static final String COLUMN_CUSTOMER_DISTRICT = "district";
    public static final String COLUMN_CUSTOMER_ADDRESS = "address";

    public static final String TABLE_PRODUCTS = "product";
    public static final String COLUMN_PRODUCT_ID = "_id";
    public static final String COLUMN_PRODUCT_DESCRIPTION = "description";
    public static final String COLUMN_PRODUCT_CATEGORY = "category";
    public static final String COLUMN_PRODUCT_MANUFACTURER = "manufacturer";
    public static final String COLUMN_PRODUCT_MODEL = "model";
    public static final String COLUMN_PRODUCT_TAX = "tax";

    public static final String TABLE_REPAIRS = "repair";
    public static final String COLUMN_REPAIR_ID = "_id";
    public static final String COLUMN_REPAIR_PRODUCT = "product_id";
    public static final String COLUMN_REPAIR_CUSTOMER = "customer_id";
    public static final String COLUMN_REPAIR_FAULT_DESCRIPTION = "fault_description";
    public static final String COLUMN_REPAIR_TECHNICIAN = "technician";
    public static final String COLUMN_REPAIR_DATE = "date";

    public static final String TABLE_TECHNICIANS = "technician";
    public static final String COLUMN_TECHNICIAN_ID = "_id";
    public static final String COLUMN_TECHNICIAN_NAME = "name";

    public static final String TABLE_ACCOUNTS = "account";
    public static final String COLUMN_ACCOUNT_ID = "_id";
    public static final String COLUMN_ACCOUNT_NAME = "full_name";
    public static final String COLUMN_ACCOUNT_EMAIL = "e_mail";
    public static final String COLUMN_ACCOUNT_PASSWORD = "password";

    public static final String VIEW_REPORT = "report_view";

    public static final String CREATE_VIEW_REPORT = "CREATE VIEW IF NOT EXISTS " +
            VIEW_REPORT + " AS SELECT " + TABLE_CUSTOMERS + "." + COLUMN_CUSTOMER_TITLE + ", " +
            TABLE_PRODUCTS + "." + COLUMN_PRODUCT_CATEGORY + ", " +
            TABLE_PRODUCTS + "." + COLUMN_PRODUCT_MANUFACTURER + ", " +
            TABLE_PRODUCTS + "." + COLUMN_PRODUCT_MODEL + ", " +
            TABLE_REPAIRS + "." + COLUMN_REPAIR_DATE + ", " +
            TABLE_TECHNICIANS + "." + COLUMN_TECHNICIAN_NAME + " FROM " + TABLE_REPAIRS +
            " INNER JOIN " + TABLE_PRODUCTS + " ON " +
            TABLE_REPAIRS + "." + COLUMN_REPAIR_CUSTOMER + " = " + TABLE_CUSTOMERS + "." + COLUMN_CUSTOMER_ID +
            " INNER JOIN " + TABLE_TECHNICIANS + " ON " +
            TABLE_REPAIRS + "." + COLUMN_REPAIR_TECHNICIAN + " = " + TABLE_TECHNICIANS + "." + COLUMN_TECHNICIAN_ID;

    public static final String CREATE_ACCOUNTS = "CREATE TABLE IF NOT EXISTS " + TABLE_ACCOUNTS + " (" +
            COLUMN_ACCOUNT_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_ACCOUNT_NAME + " TEXT, " +
            COLUMN_ACCOUNT_EMAIL + " TEXT, " +
            COLUMN_ACCOUNT_PASSWORD + " TEXT)";

    public static final String CREATE_CUSTOMERS = "CREATE TABLE IF NOT EXISTS " + TABLE_CUSTOMERS + " (" +
            COLUMN_CUSTOMER_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_CUSTOMER_TITLE + " TEXT, " +
            COLUMN_CUSTOMER_TAX_ADMINISTRATION + " TEXT, " +
            COLUMN_CUSTOMER_TAX_NUMBER + " TEXT, " +
            COLUMN_CUSTOMER_E_MAIL + " TEXT, " +
            COLUMN_CUSTOMER_PHONE + " TEXT, " +
            COLUMN_CUSTOMER_CITY + " TEXT, " +
            COLUMN_CUSTOMER_DISTRICT + " TEXT, " +
            COLUMN_CUSTOMER_ADDRESS + " TEXT)";

    public static final String CREATE_PRODUCTS = "CREATE TABLE IF NOT EXISTS " + TABLE_PRODUCTS + " (" +
            COLUMN_PRODUCT_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_PRODUCT_DESCRIPTION + " TEXT, " +
            COLUMN_PRODUCT_CATEGORY + " TEXT, " +
            COLUMN_PRODUCT_MANUFACTURER + " TEXT, " +
            COLUMN_PRODUCT_MODEL + " TEXT, " +
            COLUMN_PRODUCT_TAX + " DOUBLE)";

    public static final String CREATE_TECHNICIANS = "CREATE TABLE IF NOT EXISTS " + TABLE_TECHNICIANS + " (" +
            COLUMN_TECHNICIAN_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_TECHNICIAN_NAME + " TEXT)";

    public static final String CREATE_REPAIRS = "CREATE TABLE IF NOT EXISTS " + TABLE_REPAIRS + " (" +
            COLUMN_REPAIR_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_REPAIR_CUSTOMER + " INTEGER, " +
            COLUMN_REPAIR_PRODUCT + " INTEGER, " +
            COLUMN_REPAIR_FAULT_DESCRIPTION + " TEXT, " +
            COLUMN_REPAIR_TECHNICIAN + " INTEGER, " +
            COLUMN_REPAIR_DATE + " TEXT)";

    public boolean open() {

        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            System.out.println("Something went wrong while opening database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    public void createTablesIfNotExists() {
        try (Statement statement = conn.createStatement()) {
            statement.execute(CREATE_ACCOUNTS);
            statement.execute(CREATE_CUSTOMERS);
            statement.execute(CREATE_PRODUCTS);
            statement.execute(CREATE_REPAIRS);
            statement.execute(CREATE_TECHNICIANS);
        } catch (SQLException e) {
            System.out.println("Couldn't create tables: " + e.getMessage());
        }
    }


}