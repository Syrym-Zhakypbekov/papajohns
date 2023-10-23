package restaurant.pizza.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import restaurant.pizza.validation.Validation;

import java.io.IOException;

@WebServlet("/validate")
public class ValidateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String productName = req.getParameter("productName");
        String price = req.getParameter("price");

        boolean isProductNameValid = Validation.isValidProductName(productName);
        boolean isPriceValid = Validation.isValidPrice(price);

        if (!isProductNameValid || !isPriceValid) {
            req.setAttribute("validationMessage", "Invalid input. Please enter a valid product name and price.");
        } else {
            req.setAttribute("validationMessage", "Input is valid.");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("result.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("form.jsp");
        dispatcher.forward(req, resp);
    }

}
