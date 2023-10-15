package restaurant.pizza.testDB;

import java.io.*;
import java.sql.*;
import java.util.*;



public class TestConnection {


    public void testConnection() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "admin";

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
        System.out.println("Testing connection");
    }

}
