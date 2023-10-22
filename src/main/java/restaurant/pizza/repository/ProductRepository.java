package restaurant.pizza.repository;
import restaurant.pizza.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;
public class ProductRepository {
    private EntityManager entityManager = Persistence
            .createEntityManagerFactory("MyPU")
            .createEntityManager();

    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }
}
