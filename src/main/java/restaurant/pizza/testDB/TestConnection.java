package restaurant.pizza.testDB;


import java.sql.*;

import restaurant.pizza.util.DBConfig;


public class TestConnection {


    public void testConnection() throws Exception {
        String url = DBConfig.getDbUrl();
        String user = DBConfig.getDbUsername();
        String password = DBConfig.getDbPassword();

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            if (conn!= null &&!conn.isClosed()) {
                System.out.println("Database connection initialized successfully");
            } else {
                System.out.println("Database connection initialization failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Consider better error handling
            System.out.println("Database connection initialization failed");
        }

    }


    public static void main(String[] args) {

        TestConnection testConnection = new TestConnection();


        try {
            testConnection.testConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
