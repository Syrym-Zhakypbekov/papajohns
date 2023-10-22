package restaurant.pizza.repository;

import java.sql.*;
import restaurant.pizza.util.DBConfig;
import restaurant.pizza.util.RandomDataGenerator;

public class InsertRandomData {

    public static void insertRandomData() throws Exception {
        String url = DBConfig.getDbUrl();
        String user = DBConfig.getDbUsername();
        String password = DBConfig.getDbPassword();

        String query = "INSERT INTO Products (product_name, description, price, category_id, stock, image, created_at)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?);";

        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                for (int i = 0; i < 10; i++) {  // Insert 10 random rows
                    String productName = RandomDataGenerator.getRandomProductName();
                    String description = RandomDataGenerator.getRandomDescription(productName);
                    double price = RandomDataGenerator.getRandomPrice();
                    int categoryId = RandomDataGenerator.getRandomCategoryId();
                    int stock = RandomDataGenerator.getRandomStock();
                    byte[] image = RandomDataGenerator.getRandomImage();
                    Timestamp currentTime = RandomDataGenerator.getCurrentTimestamp();

                    pstmt.setString(1, productName);
                    pstmt.setString(2, description);
                    pstmt.setDouble(3, price);
                    pstmt.setInt(4, categoryId);
                    pstmt.setInt(5, stock);
                    pstmt.setBytes(6, image);
                    pstmt.setTimestamp(7, currentTime);

                    pstmt.addBatch();
                }
                pstmt.executeBatch();
                System.out.println("Random data inserted successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Data insertion failed");
        }
    }

    public static void main(String[] args) {

        try {
            insertRandomData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
