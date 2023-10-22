<%@ page import="restaurant.pizza.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<%
    List<Product> products = (List<Product>) request.getAttribute("products");
    for(Product product : products){
%>
Product Name: <%= product.getProductName() %><br>
Description: <%= product.getDescription() %><br>
Price: <%= product.getPrice() %><br><hr>
<%
    }
%>
</body>
</html>
