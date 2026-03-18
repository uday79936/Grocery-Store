package com.store.servlet;

import com.store.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProductServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(ProductServlet.class.getName());

    @Override
    public void init() throws ServletException {
        logger.info("ProductServlet initialized...");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Set response type
            response.setContentType("text/html;charset=UTF-8");

            // Get product list
            List<Product> products = getProducts();

            // Set data to request
            request.setAttribute("products", products);

            logger.info("Products loaded successfully: " + products.size());

            // Forward to JSP
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } catch (Exception e) {
            logger.severe("Error in ProductServlet: " + e.getMessage());
            throw new ServletException("Unable to load products", e);
        }
    }

    private List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "Rice", 50));
        products.add(new Product(2, "Milk", 30));
        products.add(new Product(3, "Eggs", 60));
        products.add(new Product(4, "Apple", 100));

        return products;
    }

    @Override
    public void destroy() {
        logger.info("ProductServlet destroyed...");
    }
}
