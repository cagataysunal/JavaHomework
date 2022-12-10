package com.example.javahomework.model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Datasource {
    private static final Datasource instance = new Datasource();

    private Datasource() {

    }

    public static Datasource getInstance() {
        return instance;
    }

    // Insert own username
    public static final String USER = "root";
    // Insert own password
    public static final String PASSWORD = "password1";

    public static final String DB_NAME = "tech_support";
    public static final String CONNECTION_STRING =
            "jdbc:mysql://localhost:3306" + "/" + DB_NAME + "?createDatabaseIfNotExist=true";

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
    public static final String COLUMN_PRODUCT_SERIAL_NUMBER = "serial_number";

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
    public static final String COLUMN_REPORT_CUSTOMER_TITLE = "customer_title";
    public static final String COLUMN_REPORT_CATEGORY = "product_category";
    public static final String COLUMN_REPORT_MANUFACTURER = "product_manufacturer";
    public static final String COLUMN_REPORT_MODEL = "product_model";
    public static final String COLUMN_REPORT_FAULT_DESCRIPTION = "fault_description";
    public static final String COLUMN_REPORT_SERIAL_NUMBER = "product_serial_number";

    // Create Tables
    public static final String CREATE_VIEW_REPORT =
            "CREATE OR REPLACE VIEW " +
                    VIEW_REPORT + " AS SELECT " +
                    TABLE_CUSTOMERS + "." + COLUMN_CUSTOMER_TITLE + " AS " + COLUMN_REPORT_CUSTOMER_TITLE + ", " +
                    TABLE_PRODUCTS + "." + COLUMN_PRODUCT_CATEGORY + " AS " + COLUMN_REPORT_CATEGORY + ", " +
                    TABLE_PRODUCTS + "." + COLUMN_PRODUCT_MANUFACTURER + " AS " + COLUMN_REPORT_MANUFACTURER + ", " +
                    TABLE_PRODUCTS + "." + COLUMN_PRODUCT_MODEL + " AS " + COLUMN_REPORT_MODEL + ", " +
                    TABLE_PRODUCTS + "." + COLUMN_PRODUCT_SERIAL_NUMBER + " AS " + COLUMN_REPORT_SERIAL_NUMBER + ", " +
                    TABLE_REPAIRS + "." + COLUMN_REPAIR_FAULT_DESCRIPTION + " AS " + COLUMN_REPORT_FAULT_DESCRIPTION + ", " +
                    TABLE_REPAIRS + "." + COLUMN_REPAIR_DATE + ", " +
                    TABLE_TECHNICIANS + "." + COLUMN_TECHNICIAN_NAME + " FROM " + TABLE_REPAIRS +
                    " INNER JOIN " + TABLE_CUSTOMERS + " ON " +
                    TABLE_REPAIRS + "." + COLUMN_REPAIR_CUSTOMER + " = " + TABLE_CUSTOMERS + "." + COLUMN_CUSTOMER_ID +
                    " INNER JOIN " + TABLE_PRODUCTS + " ON " +
                    TABLE_REPAIRS + "." + COLUMN_REPAIR_PRODUCT + " = " + TABLE_PRODUCTS + "." + COLUMN_PRODUCT_ID +
                    " INNER JOIN " + TABLE_TECHNICIANS + " ON " +
                    TABLE_REPAIRS + "." + COLUMN_REPAIR_TECHNICIAN + " = " + TABLE_TECHNICIANS + "." + COLUMN_TECHNICIAN_ID
                    + " WHERE 1=1";
    public static final String CREATE_ACCOUNTS =
            "CREATE TABLE IF NOT EXISTS " + TABLE_ACCOUNTS + " (" +
                    COLUMN_ACCOUNT_ID + " INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
                    COLUMN_ACCOUNT_NAME + " TEXT, " +
                    COLUMN_ACCOUNT_EMAIL + " TEXT, " +
                    COLUMN_ACCOUNT_PASSWORD + " TEXT)";
    public static final String CREATE_CUSTOMERS =
            "CREATE TABLE IF NOT EXISTS " + TABLE_CUSTOMERS + " (" +
                    COLUMN_CUSTOMER_ID + " INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
                    COLUMN_CUSTOMER_TITLE + " TEXT, " +
                    COLUMN_CUSTOMER_TAX_ADMINISTRATION + " TEXT, " +
                    COLUMN_CUSTOMER_TAX_NUMBER + " TEXT, " +
                    COLUMN_CUSTOMER_E_MAIL + " TEXT, " +
                    COLUMN_CUSTOMER_PHONE + " TEXT, " +
                    COLUMN_CUSTOMER_CITY + " TEXT, " +
                    COLUMN_CUSTOMER_DISTRICT + " TEXT, " +
                    COLUMN_CUSTOMER_ADDRESS + " TEXT)";
    public static final String CREATE_PRODUCTS =
            "CREATE TABLE IF NOT EXISTS " + TABLE_PRODUCTS + " (" +
                    COLUMN_PRODUCT_ID + " INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
                    COLUMN_PRODUCT_MANUFACTURER + " TEXT, " +
                    COLUMN_PRODUCT_CATEGORY + " TEXT, " +
                    COLUMN_PRODUCT_MODEL + " TEXT, " +
                    COLUMN_PRODUCT_SERIAL_NUMBER + " TEXT, " +
                    COLUMN_PRODUCT_DESCRIPTION + " TEXT)";
    public static final String CREATE_TECHNICIANS =
            "CREATE TABLE IF NOT EXISTS " + TABLE_TECHNICIANS + " (" +
                    COLUMN_TECHNICIAN_ID + " INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
                    COLUMN_TECHNICIAN_NAME + " TEXT)";
    public static final String CREATE_REPAIRS =
            "CREATE TABLE IF NOT EXISTS " + TABLE_REPAIRS + " (" +
                    COLUMN_REPAIR_ID + " INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
                    COLUMN_REPAIR_CUSTOMER + " INTEGER, " +
                    COLUMN_REPAIR_PRODUCT + " INTEGER, " +
                    COLUMN_REPAIR_FAULT_DESCRIPTION + " TEXT, " +
                    COLUMN_REPAIR_TECHNICIAN + " INTEGER, " +
                    COLUMN_REPAIR_DATE + " TEXT)";

    // Prepared Queries
    public static final String CHECK_ACCOUNT_SIGN_IN =
            "SELECT * FROM " + TABLE_ACCOUNTS + " WHERE " +
                    COLUMN_ACCOUNT_EMAIL + " = ? AND " + COLUMN_ACCOUNT_PASSWORD + " = ?";
    public static final String REGISTER_ACCOUNT =
            "INSERT INTO " + TABLE_ACCOUNTS + " (" + COLUMN_ACCOUNT_NAME + ", " +
                    COLUMN_ACCOUNT_EMAIL + ", " + COLUMN_ACCOUNT_PASSWORD + ") VALUES (?, ?, ?)";
    public static final String REGISTER_PRODUCT =
            "INSERT INTO " + TABLE_PRODUCTS + " (" + COLUMN_PRODUCT_MANUFACTURER + ", " +
                    COLUMN_PRODUCT_CATEGORY + ", " + COLUMN_PRODUCT_MODEL + ", " + COLUMN_PRODUCT_SERIAL_NUMBER + ", " +
                    COLUMN_PRODUCT_DESCRIPTION + ") VALUES (?, ?, ?, ?, ?)";
    public static final String REGISTER_REPAIR =
            "INSERT INTO " + TABLE_REPAIRS + " (" + COLUMN_REPAIR_CUSTOMER + ", " +
                    COLUMN_REPAIR_PRODUCT + ", " + COLUMN_REPAIR_FAULT_DESCRIPTION + ", " + COLUMN_REPAIR_TECHNICIAN + ", " +
                    COLUMN_REPAIR_DATE + ") VALUES (?, ?, ?, ?, ?)";
    public static final String REGISTER_CUSTOMER =
            "INSERT INTO " + TABLE_CUSTOMERS + " (" + COLUMN_CUSTOMER_TITLE + ", " +
                    COLUMN_CUSTOMER_TAX_ADMINISTRATION + ", " + COLUMN_CUSTOMER_TAX_NUMBER + ", " +
                    COLUMN_CUSTOMER_E_MAIL + ", " + COLUMN_CUSTOMER_PHONE + ", " + COLUMN_CUSTOMER_CITY + ", " +
                    COLUMN_CUSTOMER_DISTRICT + ", " + COLUMN_CUSTOMER_ADDRESS + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String REGISTER_TECHNICIAN =
            "INSERT INTO " + TABLE_TECHNICIANS + "(" + COLUMN_TECHNICIAN_NAME + ") VALUES (?)";

    // SELECT Queries
    public static final String GET_PRODUCT_MANUFACTURER_NAMES =
            "SELECT DISTINCT " + COLUMN_PRODUCT_MANUFACTURER + " FROM " + TABLE_PRODUCTS;
    public static final String GET_PRODUCT_CATEGORY_NAMES = "SELECT DISTINCT " + COLUMN_PRODUCT_CATEGORY + " FROM " +
            TABLE_PRODUCTS;
    public static final String GET_PRODUCTS_BY_MANUFACTURER_AND_CATEGORY =
            "SELECT DISTINCT " + COLUMN_PRODUCT_MODEL + " FROM " +
                    TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCT_MANUFACTURER + " = ? AND " + COLUMN_PRODUCT_CATEGORY + " = ?";
    public static final String GET_CUSTOMERS = "SELECT * FROM " + TABLE_CUSTOMERS;
    public static final String GET_CUSTOMER_BY_NAME =
            "SELECT DISTINCT * FROM " + TABLE_CUSTOMERS + " WHERE " + COLUMN_CUSTOMER_TITLE + " = ?";
    public static final String GET_TECHNICIANS = "SELECT * FROM " + TABLE_TECHNICIANS;
    public static final String GET_TECHNICIAN_BY_NAME =
            "SELECT DISTINCT * FROM " + TABLE_TECHNICIANS + " WHERE " + COLUMN_TECHNICIAN_NAME + " = ?";
    public static final String GET_REPORT =
            "SELECT DISTINCT * FROM " + VIEW_REPORT;
    public static final String CHECK_SERIAL_NUMBER = "SELECT DISTINCT * FROM " + TABLE_PRODUCTS +
            " WHERE " + COLUMN_PRODUCT_SERIAL_NUMBER + " = ?";

    // VIEW Filters
    public static final String FILTER_REPORT_BY_MODEL = " AND WHERE " + COLUMN_REPORT_MODEL + " = ? ";
    public static final String FILTER_REPORT_BY_CUSTOMER = " AND WHERE " + COLUMN_REPORT_CUSTOMER_TITLE + " = ? ";
    public static final String FILTER_REPORT_BY_SERIAL_NUMBER = " AND WHERE" + COLUMN_REPORT_SERIAL_NUMBER + " LIKE %?%";

    public boolean open() {

        try {
            con = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
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
            statement.execute(CREATE_VIEW_REPORT);
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
            System.out.println("SQL statement: " + preparedStatement);
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
            System.out.println("SQL statement: " + preparedStatement);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

    }

    public boolean registerProduct(Product product) {

        try (PreparedStatement preparedStatement = con.prepareStatement(REGISTER_PRODUCT)) {

            preparedStatement.setString(1, product.getCategory());
            preparedStatement.setString(2, product.getManufacturer());
            preparedStatement.setString(3, product.getModel());
            preparedStatement.setString(4, product.getSerialNumber());
            preparedStatement.setString(5, product.getDescription());
            System.out.println("SQL statement: " + preparedStatement);
            preparedStatement.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return false;
        }
    }

    public boolean registerRepair(Repair repair) {
        // INSERT INTO repair (customer,
        // product, description, technician,
        // date) VALUES (?, ?, ?, ?, ?)
        try (PreparedStatement preparedStatement = con.prepareStatement(REGISTER_REPAIR)) {
            preparedStatement.setInt(1, repair.getCustomer());
            preparedStatement.setInt(2, repair.getProduct());
            preparedStatement.setString(3, repair.getFaultDescription());
            preparedStatement.setInt(4, repair.getTechnician());
            preparedStatement.setString(5, repair.getDateTime());
            System.out.println("SQL statement: " + preparedStatement);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Can't register repair: " + e.getMessage());
            return false;
        }
    }

    public boolean registerCustomer(Customer customer) {
//        INSERT INTO customer (title,
//                tax_administration, tax_number,
//                email, phone, city,
//                district, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        try (PreparedStatement preparedStatement = con.prepareStatement(REGISTER_CUSTOMER)) {

            preparedStatement.setString(1, customer.getTitle());
            preparedStatement.setString(2, customer.getTaxAdministration());
            preparedStatement.setString(3, customer.getTaxNumber());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getCity());
            preparedStatement.setString(7, customer.getDistrict());
            preparedStatement.setString(8, customer.getAddress());
            System.out.println("SQL statement: " + preparedStatement);
            preparedStatement.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Can't register customer: " + e.getMessage());
            return false;
        }

    }

    public List<String> getProductManufacturerNames() {
        List<String> productManufacturerNames = new ArrayList<>();

        try (Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_PRODUCT_MANUFACTURER_NAMES)) {
            System.out.println("SQL statement: " + GET_PRODUCT_MANUFACTURER_NAMES);

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
            System.out.println("SQL statement: " + GET_PRODUCT_CATEGORY_NAMES);

            while (resultSet.next()) {
                productCategoryNames.add(resultSet.getString(1));
            }
            return productCategoryNames;
        } catch (SQLException e) {
            System.out.println("Can't get category names: " + e.getMessage());
            return null;
        }
    }

    public Product getProductBySerialNumber(String serialNumber) {
        Product product = new Product();


        try (PreparedStatement preparedStatement = con.prepareStatement(CHECK_SERIAL_NUMBER)) {
            preparedStatement.setString(1, serialNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                product.set_id(resultSet.getInt(1));
                product.setManufacturer(resultSet.getString(2));
                product.setCategory(resultSet.getString(3));
                product.setModel(resultSet.getString(4));
                product.setSerialNumber(resultSet.getString(5));
                product.setDescription(resultSet.getString(6));
                return product;
            } else {
                System.out.println("resultSet is empty.");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Can't get product: " + e.getMessage());
            return null;
        }
    }

    public List<String> getProductModels(String manufacturer, String category) {
        List<String> products = new ArrayList<>();

        try (PreparedStatement preparedStatement = con.prepareStatement(GET_PRODUCTS_BY_MANUFACTURER_AND_CATEGORY)) {
            preparedStatement.setString(1, manufacturer);
            preparedStatement.setString(2, category);
            System.out.println("SQL statement: " + preparedStatement);
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

    public Customer getCustomerByName(String name) {
        Customer customer = new Customer();
        try (PreparedStatement preparedStatement = con.prepareStatement(GET_CUSTOMER_BY_NAME)) {

            preparedStatement.setString(1, name);
            System.out.println("SQL statement: " + preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customer.set_id(resultSet.getInt(1));
                customer.setTitle(resultSet.getString(2));
                customer.setTaxAdministration(resultSet.getString(3));
                customer.setTaxNumber(resultSet.getString(4));
                customer.setEmail(resultSet.getString(5));
                customer.setPhone(resultSet.getString(6));
                customer.setCity(resultSet.getString(7));
                customer.setDistrict(resultSet.getString(8));
                customer.setAddress(resultSet.getString(9));
                return customer;
            } else {
                System.out.println("resultSet is empty.");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Can't get customer: " + e.getMessage());
            return null;
        }
    }

    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();

        try (Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_CUSTOMERS)) {
            System.out.println("SQL statement: " + GET_CUSTOMERS);

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

    public Technician getTechnicianByName(String name) {
        Technician technician = new Technician();

        try (PreparedStatement preparedStatement = con.prepareStatement(GET_TECHNICIAN_BY_NAME)) {
            preparedStatement.setString(1, name);
            System.out.println("SQL statement: " + preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                technician.set_id(resultSet.getInt(1));
                technician.setName(resultSet.getString(2));
                return technician;
            } else {
                System.out.println("resultSet is empty.");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Can't get technician: " + e.getMessage());
            return null;
        }
    }

    public List<Technician> getTechnicians() {
        List<Technician> technicians = new ArrayList<>();

        try (Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_TECHNICIANS)) {
            System.out.println("SQL statement: " + GET_TECHNICIANS);

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

    public boolean registerTechnician(String name) {

        try (PreparedStatement preparedStatement = con.prepareStatement(REGISTER_TECHNICIAN)) {
            preparedStatement.setString(1, name);
            System.out.println("SQL statement: " + preparedStatement);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Can't add technician: " + e.getMessage());
            return false;
        }

    }

    public List<Report> getReport(String customerName, String model, String serialNumber) {
        List<Report> reports = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(GET_REPORT);
        AtomicInteger index = new AtomicInteger();
        if (!customerName.isEmpty()) {
            sql.append(FILTER_REPORT_BY_CUSTOMER);
            index.getAndIncrement();
        }
        if (!model.isEmpty()) {
            sql.append(FILTER_REPORT_BY_MODEL);
            index.getAndIncrement();
        }
        if (!serialNumber.isEmpty()) {
            sql.append(FILTER_REPORT_BY_SERIAL_NUMBER);
            index.getAndIncrement();
        }
        try (PreparedStatement preparedStatement = con.prepareStatement(sql.toString())) {
            if (!serialNumber.isEmpty()) {
                preparedStatement.setString(index.getAndDecrement(), serialNumber);
            }
            if (!model.isEmpty()) {
                preparedStatement.setString(index.getAndDecrement(), model);
            }
            if (!customerName.isEmpty()) {
                preparedStatement.setString(index.getAndDecrement(), customerName);
            }
            System.out.println("SQL Statement: " + preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Report report = new Report();
                report.setCustomerTitle(resultSet.getString(1));
                report.setProductCategory(resultSet.getString(2));
                report.setProductManufacturer(resultSet.getString(3));
                report.setProductModel(resultSet.getString(4));
                report.setSerialNumber(resultSet.getString(5));
                report.setFaultDescription(resultSet.getString(6));
                report.setRepairDate(resultSet.getString(7));
                report.setTechnicianName(resultSet.getString(8));
                reports.add(report);
            }
            return reports;
        } catch (SQLException e) {
            System.out.println("Can't get report: " + e.getMessage());
            return null;
        }
    }

    public boolean checkSerialNumber(String serialNumber) {
        try (PreparedStatement preparedStatement = con.prepareStatement(CHECK_SERIAL_NUMBER)) {
            preparedStatement.setString(1, serialNumber);
            System.out.println("SQL statement: " + preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("Can't get report " + e.getMessage());
            return false;
        }
    }
}