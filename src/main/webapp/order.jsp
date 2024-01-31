<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="impl.Dishinterface" %>
<%@ page import="model.Dishe" %>
<%@ page import="database.Dishimpl" %>
<%@ page import="java.util.Base64" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
</head>
<body>
    <form action="Getdishcal" method="post">
        <table cellpadding="10" align="center">
            <tr>
                <th>Dish Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Photo</th>
                <th>Quantity</th>
                <th>Add to Cart</th>
            </tr>
            <%
            Dishinterface de = new Dishimpl();
            ArrayList<Dishe> dishes = de.getdishes();
            for (Dishe dish : dishes) {
            %>
            <tr>
                <td><%= dish.getName() %></td>
                <td><%= dish.getDesc() %></td>
                <td><%= dish.getPrice() %></td>
                <td>
                    <img src="data:image/jpeg;base64, <%= Base64.getEncoder().encodeToString(dish.getPhoto()) %>" width="100" height="100" />
                </td>
                <td>
                    <input type="number" id="quantity_<%= dish.getDishid() %>" name="quantity_<%= dish.getDishid() %>" />
                </td>
                <td>
                    <input type="hidden" name="id" value="<%= dish.getDishid() %>" />
                    <input type="hidden" name="name" value="<%= dish.getName() %>" />
                    <input type="hidden" name="price" value="<%= dish.getPrice() %>" />
                    <input type="hidden" name="description" value="<%= dish.getDesc() %>" />
                    <input type="hidden" name="photo" value="<%= Base64.getEncoder().encodeToString(dish.getPhoto()) %>" />
                    <input type="submit" value="Add to Cart" />
                </td>
            </tr>
            <%
            }
            %>
        </table>
    </form>
</body>
</html>
