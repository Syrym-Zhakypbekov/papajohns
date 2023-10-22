// ProductService.java
package restaurant.pizza.service;
import restaurant.pizza.model.Product;
import restaurant.pizza.repository.ProductRepository;
import java.util.List;

public class ProductService {
    private ProductRepository productRepository = new ProductRepository();

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
}