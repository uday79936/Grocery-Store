<%@ page import="java.util.*, com.store.model.Product" %>
<html>
<body>

<h2>🛒 Grocery Store</h2>

<%
    List<Product> products = (List<Product>) request.getAttribute("products");
    if (products != null) {
        for (Product p : products) {
%>

<form action="cart" method="post">
    <p>
        <b><%= p.getName() %></b> - ₹<%= p.getPrice() %>
        <input type="hidden" name="id" value="<%= p.getId() %>" />
        <input type="hidden" name="name" value="<%= p.getName() %>" />
        <input type="hidden" name="price" value="<%= p.getPrice() %>" />
        <button type="submit">Add to Cart</button>
    </p>
</form>

<%
        }
    }
%>

<a href="cart">View Cart</a>

</body>
</html>