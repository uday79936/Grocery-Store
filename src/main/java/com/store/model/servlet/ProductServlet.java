package com.store.servlet;

import com.store.model.Product;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.*;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "Rice", 50));
        products.add(new Product(2, "Milk", 30));
        products.add(new Product(3, "Eggs", 60));
        products.add(new Product(4, "Apple", 100));

        request.setAttribute("products", products);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}