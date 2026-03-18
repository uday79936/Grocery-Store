package com.store.servlet;

import com.store.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CartServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(CartServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Validate inputs
            String idParam = request.getParameter("id");
            String name = request.getParameter("name");
            String priceParam = request.getParameter("price");

            if (idParam == null || name == null || priceParam == null ||
                idParam.isEmpty() || name.isEmpty() || priceParam.isEmpty()) {

                throw new ServletException("Invalid product data");
            }

            int id = Integer.parseInt(idParam);
            double price = Double.parseDouble(priceParam);

            Product product = new Product(id, name, price);

            // Get session
            HttpSession session = request.getSession();

            // Get or create cart
            List<Product> cart = (List<Product>) session.getAttribute("cart");

            if (cart == null) {
                cart = new ArrayList<>();
            }

            // Add product
            cart.add(product);

            // Save back to session
            session.setAttribute("cart", cart);

            logger.info("Product added to cart: " + product.getName());

            // Redirect back to products page
            response.sendRedirect("products");

        } catch (NumberFormatException e) {
            logger.severe("Invalid number format: " + e.getMessage());
            throw new ServletException("Invalid product ID or price", e);

        } catch (Exception e) {
            logger.severe("Error in CartServlet: " + e.getMessage());
            throw new ServletException("Unable to add product to cart", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null) {
            List<Product> cart = (List<Product>) session.getAttribute("cart");
            request.setAttribute("cart", cart);
        }

        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        logger.info("CartServlet initialized...");
    }

    @Override
    public void destroy() {
        logger.info("CartServlet destroyed...");
    }
}
