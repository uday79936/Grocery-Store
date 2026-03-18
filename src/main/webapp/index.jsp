<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Grocery Store</title>
    <style>
        body {
            font-family: Arial;
            margin: 20px;
        }
        .product {
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 5px;
        }
        .btn {
            background-color: green;
            color: white;
            padding: 5px 10px;
            border: none;
            cursor: pointer;
        }
        .btn:hover {
            background-color: darkgreen;
        }
    </style>
</head>

<body>

<%-- ✅ AUTO REDIRECT TO SERVLET IF NO DATA --%>
<c:if test="${empty products}">
    <c:redirect url="products"/>
</c:if>

<h2>🛒 Grocery Store</h2>

<c:forEach var="p" items="${products}">
    
    <div class="product">
        <b>${p.name}</b> - ₹${p.price}
        
        <form action="cart" method="post">
            <input type="hidden" name="id" value="${p.id}" />
            <input type="hidden" name="name" value="${p.name}" />
            <input type="hidden" name="price" value="${p.price}" />
            
            <button type="submit" class="btn">Add to Cart</button>
        </form>
    </div>

</c:forEach>

<br/>

<a href="cart">🧾 View Cart</a>

</body>
</html>
