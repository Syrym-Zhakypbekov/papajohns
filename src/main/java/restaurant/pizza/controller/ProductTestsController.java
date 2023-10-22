package restaurant.pizza.controller;
import jakarta.servlet.annotation.WebServlet;
import restaurant.pizza.model.Product;
import restaurant.pizza.repository.ProductRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/productsTests")
public class ProductTestsController extends HttpServlet {

    private ProductRepository productRepository = new ProductRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Product> products = productRepository.findAll();
        req.setAttribute("products", products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("products.jsp");
        dispatcher.forward(req, resp);
    }


}

