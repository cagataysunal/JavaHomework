package com.example.javahomework.model;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Datasource {
    private static final Datasource instance = new Datasource();

    private Datasource() {

    }

    public static Datasource getInstance() {
        return instance;
    }

    public static final String DB_NAME = "tech_support.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + System.getProperty("user.dir") + "/" + DB_NAME;

    private Connection con;

    // Define Tables
    public static final String TABLE_CUSTOMERS = "customer";
    public static final String COLUMN_CUSTOMER_ID = "_id";
    public static final String COLUMN_CUSTOMER_TITLE = "title";
    public static final String COLUMN_CUSTOMER_TAX_ADMINISTRATION = "tax_administration";
    public static final String COLUMN_CUSTOMER_TAX_NUMBER = "tax_number";
    public static final String COLUMN_CUSTOMER_E_MAIL = "email";
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

    public static final String TABLE_REPAIRS = "repair";
    public static final String COLUMN_REPAIR_ID = "_id";
    public static final String COLUMN_REPAIR_PRODUCT = "product";
    public static final String COLUMN_REPAIR_CUSTOMER = "customer";
    public static final String COLUMN_REPAIR_FAULT_DESCRIPTION = "description";
    public static final String COLUMN_REPAIR_TECHNICIAN = "technician";
    public static final String COLUMN_REPAIR_DATE = "date";

    public static final String TABLE_TECHNICIANS = "technician";
    public static final String COLUMN_TECHNICIAN_ID = "_id";
    public static final String COLUMN_TECHNICIAN_NAME = "name";

    public static final String TABLE_ACCOUNTS = "account";
    public static final String COLUMN_ACCOUNT_ID = "_id";
    public static final String COLUMN_ACCOUNT_NAME = "name";
    public static final String COLUMN_ACCOUNT_EMAIL = "email";
    public static final String COLUMN_ACCOUNT_PASSWORD = "password";

    public static final String VIEW_REPORT = "report_view";

    // Create Tables
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
            COLUMN_PRODUCT_MANUFACTURER + " TEXT, " +
            COLUMN_PRODUCT_CATEGORY + " TEXT, " +
            COLUMN_PRODUCT_MODEL + " TEXT, " +
            COLUMN_PRODUCT_DESCRIPTION + " TEXT)";

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

    // Prepared Queries
    public static final String CHECK_ACCOUNT_SIGN_IN = "SELECT * FROM " + TABLE_ACCOUNTS + " WHERE " +
            COLUMN_ACCOUNT_EMAIL + " = ? AND " + COLUMN_ACCOUNT_PASSWORD + " = ?";

    public static final String REGISTER_ACCOUNT = "INSERT INTO " + TABLE_ACCOUNTS + " (" + COLUMN_ACCOUNT_NAME + ", " +
            COLUMN_ACCOUNT_EMAIL + ", " + COLUMN_ACCOUNT_PASSWORD + ") VALUES (?, ?, ?)";

    public static final String REGISTER_PRODUCT = "INSERT INTO " + TABLE_PRODUCTS + " (" + COLUMN_PRODUCT_MANUFACTURER + ", " +
            COLUMN_PRODUCT_CATEGORY + ", " + COLUMN_PRODUCT_MODEL + ", " + COLUMN_PRODUCT_DESCRIPTION + ") " +
            "VALUES (?, ?, ?, ?)";

    public static final String GET_PRODUCT_MANUFACTURER_NAMES = "SELECT DISTINCT " + COLUMN_PRODUCT_MANUFACTURER + " FROM " +
            TABLE_PRODUCTS;
    public static final String GET_PRODUCT_CATEGORY_NAMES = "SELECT DISTINCT " + COLUMN_PRODUCT_CATEGORY + " FROM " +
            TABLE_PRODUCTS;
    public static final String GET_PRODUCTS_BY_MANUFACTURER_AND_CATEGORY =
            "SELECT DISTINCT " + COLUMN_PRODUCT_MODEL + " FROM " +
                    TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCT_MANUFACTURER + " = ? AND " + COLUMN_PRODUCT_CATEGORY + " = ?";

    public static final String GET_CUSTOMERS = "SELECT * FROM " + TABLE_CUSTOMERS;
    public static final String GET_PRODUCTS = "SELECT * FROM " + TABLE_PRODUCTS;
    public static final String GET_TECHNICIANS = "SELECT * FROM " + TABLE_TECHNICIANS;

    public boolean open() {

        try {
            con = DriverManager.getConnection(CONNECTION_STRING);
            createTablesIfNotExists();
            return true;
        } catch (SQLException e) {
            System.out.println("Something went wrong while opening database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    private void createTablesIfNotExists() {
        try (Statement statement = con.createStatement()) {
            con.setAutoCommit(false);
            statement.execute(CREATE_ACCOUNTS);
            statement.execute(CREATE_CUSTOMERS);
            statement.execute(CREATE_PRODUCTS);
            statement.execute(CREATE_REPAIRS);
            statement.execute(CREATE_TECHNICIANS);
            con.commit();
            con.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Couldn't create tables: " + e.getMessage());
        }
    }

    public boolean checkSignIn(String email, String password) {

        try (PreparedStatement preparedStatement = con.prepareStatement(CHECK_ACCOUNT_SIGN_IN)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return false;
        }
    }

    public void registerAccount(String name, String email, String password) {
        try (PreparedStatement preparedStatement = con.prepareStatement(REGISTER_ACCOUNT)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

    }

    public boolean registerProduct(Product product) {

        try (PreparedStatement preparedStatement = con.prepareStatement(REGISTER_PRODUCT)) {

            preparedStatement.setString(1, product.getManufacturer());
            preparedStatement.setString(2, product.getCategory());
            preparedStatement.setString(3, product.getModel());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return false;
        }

    }

    public List<String> getProductManufacturerNames() {
        List<String> productManufacturerNames = new ArrayList<>();

        try (Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_PRODUCT_MANUFACTURER_NAMES)) {
            while (resultSet.next()) {
                productManufacturerNames.add(resultSet.getString(1));
            }
            return productManufacturerNames;
        } catch (SQLException e) {
            System.out.println("Can't get manufacturer names: " + e.getMessage());
            return null;
        }
    }

    public List<String> getProductCategoryNames() {
        List<String> productCategoryNames = new ArrayList<>();

        try (Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_PRODUCT_CATEGORY_NAMES)) {
            while (resultSet.next()) {
                productCategoryNames.add(resultSet.getString(1));
            }
            return productCategoryNames;
        } catch (SQLException e) {
            System.out.println("Can't get category names: " + e.getMessage());
            return null;
        }
    }

    public List<String> getProductModels(String manufacturer, String category) {
        List<String> products = new ArrayList<>();

        try (PreparedStatement preparedStatement = con.prepareStatement(GET_PRODUCTS_BY_MANUFACTURER_AND_CATEGORY)) {
            preparedStatement.setString(1, manufacturer);
            preparedStatement.setString(2, category);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(resultSet.getString(1));
            }
            return products;

        } catch (SQLException e) {
            System.out.println("Can't get products: " + e.getMessage());
            return null;
        }
    }

    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();

        try (Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_CUSTOMERS)) {

            while (resultSet.next()) {

                Customer customer = new Customer();

                customer.set_id(resultSet.getInt(1));
                customer.setTitle(resultSet.getString(2));
                customer.setTaxAdministration(resultSet.getString(3));
                customer.setTaxNumber(resultSet.getString(4));
                customer.setEmail(resultSet.getString(5));
                customer.setPhone(resultSet.getString(6));
                customer.setCity(resultSet.getString(7));
                customer.setDistrict(resultSet.getString(8));
                customer.setAddress(resultSet.getString(9));
                customers.add(customer);
            }
            return customers;

        } catch (SQLException e) {
            System.out.println("Can't get customers: " + e.getMessage());
            return null;
        }

    }

    public Map<String, Integer> mapCustomerNameToId(List<Customer> customers) {
        Map<String, Integer> nameToInt = new HashMap<>();
        for (Customer customer : customers) {
            nameToInt.putIfAbsent(customer.getTitle(), customer.get_id());
        }
        return nameToInt;
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        try (Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_PRODUCTS)) {
            while (resultSet.next()) {
                Product product = new Product();

                product.set_id(resultSet.getInt(1));
                product.setCategory(resultSet.getString(2));
                product.setManufacturer(resultSet.getString(3));
                product.setModel(resultSet.getString(4));
                product.setDescription(resultSet.getString(5));
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            System.out.println("Can't get products: " + e.getMessage());
            return null;
        }
    }

    public Map<String, Integer> mapProductNameToId(List<Product> products) {
        Map<String, Integer> nameToId = new HashMap<>();

        for (Product product : products) {
            nameToId.putIfAbsent(product.getModel(), product.get_id());
        }
        return nameToId;
    }

    public List<Technician> getTechnicians() {
        List<Technician> technicians = new ArrayList<>();

        try (Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_TECHNICIANS)) {
            while (resultSet.next()) {
                Technician technician = new Technician();
                technician.set_id(resultSet.getInt(1));
                technician.setName(resultSet.getString(2));
                technicians.add(technician);
            }
            return technicians;

        } catch (SQLException e) {
            System.out.println("Can't get technicians: " + e.getMessage());
            return null;
        }
    }

    public Map<String,Integer> mapTechnicianToId(List<Technician> technicians) {
        Map<String, Integer> nameToId = new HashMap<>();
        for (Technician technician : technicians) {
            nameToId.putIfAbsent(technician.getName(), technician.get_id());
        }
        return nameToId;
    }
}