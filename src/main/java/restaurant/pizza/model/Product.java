package restaurant.pizza.model;
import jakarta.persistence.*;

import java.sql.Timestamp;
@Entity
@Table(name = "products", schema = "public")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "stock")
    private int stock;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "modified")
    private Timestamp modified;

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getStock() {
        return stock;
    }

    public byte[] getImage() {
        return image;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getModified() {
        return modified;
    }

    // Setters
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }
}
