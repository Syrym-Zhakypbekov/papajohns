package restaurant.pizza.testDB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import restaurant.pizza.util.DBConfig;

public class TestTableClass {

    public static void createTable() throws Exception {

        String url = DBConfig.getDbUrl();
        String user = DBConfig.getDbUsername();
        String password = DBConfig.getDbPassword();

        String query = "CREATE TABLE IF NOT EXISTS Products (" +
                "product_id SERIAL PRIMARY KEY," +
                "product_name VARCHAR(255)," +
                "description TEXT," +
                "price DECIMAL(10, 2)," +
                "category_id INT," +
                "stock INT," +
                "image BYTEA," +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(query);
                System.out.println("Table created successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Table creation failed");
        }

    }

    public static void main(String[] args) {
        try {
            createTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}