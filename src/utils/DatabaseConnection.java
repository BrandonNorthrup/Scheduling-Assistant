/*
Brandon Northrup
Student ID #001177877
Software II - Java - C195
*/

package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    // Database information that is used to connect
    private static final String PROTOCOL = "jdbc";
    private static final String VENDOR = ":mysql:";
    private static final String IPADDRESS = "//3.227.166.251/U06ulb";
    private static final String URL = PROTOCOL + VENDOR + IPADDRESS;
    private static final String USERNAME = "U06ulb";
    private static final String PASSWORD = "53688875085";
    private static final String JDBCDRIVER = "com.mysql.jdbc.Driver"; 
    private static Connection connection = null;
    
    public DatabaseConnection() {}
    
    // Connect to the database - use exceptions for when something goes wrong
    public static void startConnection() {
        try {
            Class.forName(JDBCDRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Successfully connected to MySQL database!");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
        catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage()); 
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
    
    // Close the connection
    public static void endConnection() {
        try {
            connection.close();
            System.out.println("Disconnected from MySQL database!");
        }
        catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
    
    // Return the database connection
    public static Connection getConnection() {
        return connection;
    }
}