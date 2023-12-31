package restaurant.pizza.controller;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import restaurant.pizza.model.Product;
import restaurant.pizza.service.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductController extends HttpServlet {

    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("json".equals(action)) {
            getAllProducts(resp);
        } else {
            List<Product> products = productService.findAllProducts();
            req.setAttribute("products", products);
            RequestDispatcher dispatcher = req.getRequestDispatcher("products.jsp");
            dispatcher.forward(req, resp);
        }
    }

    private void getAllProducts(HttpServletResponse response) throws IOException {
        List<Product> products = productService.findAllProducts();
        Gson gson = new Gson();
        String json = gson.toJson(products);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Do not set productId if it's autogenerated
        String name = req.getParameter("product_name");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        int categoryId = Integer.parseInt(req.getParameter("category_id"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        String image = req.getParameter("image");

        Product product = new Product();
        // Do not set productId if it's autogenerated
        product.setProductName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategoryId(categoryId);
        product.setStock(stock);
        // Assuming setImage accepts a String for image name. Change as needed.
        product.setImage(image.getBytes());

        productService.saveProduct(product);
        resp.sendRedirect("products");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        int categoryId = Integer.parseInt(req.getParameter("category_id"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        String image = req.getParameter("image");

        Product product = productService.findProduct(id);
        if (product != null) {
            // Note: Usually, we don't change the ID.
            // product.setProductId(id);
            product.setProductName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setCategoryId(categoryId);
            product.setStock(stock);
            // Assuming setImage accepts a String for image name. Change as needed.
            product.setImage(image.getBytes());

            productService.saveProduct(product);
        }
        resp.sendRedirect("products");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        productService.deleteProduct(id);
        resp.sendRedirect("products");
    }


}
