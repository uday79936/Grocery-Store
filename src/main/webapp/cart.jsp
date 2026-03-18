<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Your Cart</title>
    <style>
        body {
            font-family: Arial;
            margin: 20px;
        }
        .item {
            border-bottom: 1px solid #ccc;
            padding: 10px 0;
        }
        .total {
            font-weight: bold;
            margin-top: 20px;
        }
        .btn {
            display: inline-block;
            margin-top: 20px;
            background-color: blue;
            color: white;
            padding: 8px 12px;
            text-decoration: none;
        }
    </style>
</head>

<body>

<h2>🛍️ Your Cart</h2>

<c:set var="total" value="0" />

<c:if test="${not empty cart}">
    
    <c:forEach var="p" items="${cart}">
        <div class="item">
            ${p.name} - ₹${p.price}
        </div>
        
        <!-- Add to total -->
        <c:set var="total" value="${total + p.price}" />
    </c:forEach>

    <div class="total">
        Total: ₹${total}
    </div>

</c:if>

<c:if test="${empty cart}">
    <p>Your cart is empty.</p>
</c:if>

<a href="products" class="btn">🛒 Continue Shopping</a>

</body>
</html>
