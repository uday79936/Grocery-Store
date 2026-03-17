<%@ page import="java.util.*, com.store.model.Product" %>
<html>
<body>

<h2>🛍️ Your Cart</h2>

<%
    List<Product> cart = (List<Product>) session.getAttribute("cart");
    double total = 0;

    if (cart != null) {
        for (Product p : cart) {
            total += p.getPrice();
%>

<p><%= p.getName() %> - ₹<%= p.getPrice() %></p>

<%
        }
    }
%>

<h3>Total: ₹<%= total %></h3>

<a href="products">Continue Shopping</a>

</body>
</html>