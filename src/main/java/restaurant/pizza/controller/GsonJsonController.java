package restaurant.pizza.controller;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import restaurant.pizza.model.Product;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/gson-json")
public class GsonJsonController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Sample data
        List<Product> products = Arrays.asList(
                new Product("Apple", 1.2),
                new Product("Banana", 0.8),
                new Product("Cherry", 2.0)
        );

        Gson gson = new Gson();
        String json = gson.toJson(products);

        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }
}

