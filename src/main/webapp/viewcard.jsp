<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Dishe" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Cart</title>
</head>
<body>
    <h2>Your Cart</h2>
    <table cellpadding="10" align="center">
        <tr>
            <th>Dish Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Item Total</th>
        </tr>
        <%
        ArrayList<Dishe> cart = (ArrayList<Dishe>) session.getAttribute("cart");
        float grandTotal = 0;
        if (cart != null) {
            for (Dishe dish : cart) {
                float itemTotal = dish.getPrice() * dish.getQuantity();
                grandTotal += itemTotal;
        %>
        <tr>
            <td><%= dish.getName() %></td>
            <td><%= dish.getDesc() %></td>
            <td>rs<%= dish.getPrice() %></td>
            <td><%= dish.getQuantity() %></td>
            <td>rs<%= itemTotal %></td>
        </tr>
        <%
            }
        }
        %>
    </table>
    <p>Grand Total: rs<%= grandTotal %></p>
</body>
</html>
