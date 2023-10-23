package restaurant.pizza.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import restaurant.pizza.model.Product;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/manual-json")
public class ManualJsonController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Sample data
        List<Product> products = Arrays.asList(
                new Product("Apple", 1.2),
                new Product("Banana", 0.8),
                new Product("Cherry", 2.0)
        );

        StringBuilder json = new StringBuilder("[");
        for (Product product : products) {
            json.append("{")
                    .append("\"name\":\"").append(product.getProductName()).append("\",")
                    .append("\"price\":").append(product.getPrice())
                    .append("},");
        }
        if (json.length() > 1) {
            json.deleteCharAt(json.length() - 1);
        }
        json.append("]");

        resp.setContentType("application/json");
        resp.getWriter().write(json.toString());
    }
}

