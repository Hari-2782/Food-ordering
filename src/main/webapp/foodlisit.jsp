<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="impl.Dishinterface" %>
<%@ page import="model.Dishe" %>
<%@ page import ="database.Dishimpl"%>
<%@ page import="java.util.Base64" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Dishes</title>
</head>
<body>
    <h1>List of Dishes</h1>
    <table >
        <tr>
            <th>Dish ID</th>
            <th>Dish Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Photo</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        
        <% 
        Dishinterface de=new Dishimpl();
        ArrayList<Dishe> dishes = de.getdishes();
        
        %>

        <%for (Dishe dish : dishes) {%>
        <tr>
            <td><%= dish.getDishid() %></td>
            <td><%= dish.getName() %></td>
            <td><%= dish.getDesc()%></td>
           <td>rs<%= dish.getPrice() %></td>
           <td>
    <td>
    <img src="data:image/jpeg;base64, <%= Base64.getEncoder().encodeToString(dish.getPhoto()) %>" width="100" height="100" />
</td>
         <td>
        <form method="POST" action="Getdish">
        <input type="hidden" name="id" value="<%= dish.getDishid()%>" />
        <button type="submit" class="btn anim" name="btnInsert">edit</button>
    </form>
    </td>
              <td>
    <form method="POST" action="Deletefood">
        <input type="hidden" name="id" value="<%= dish.getDishid()%>" />
        <button type="submit" class="btn anim" name="btnInsert">delete</button>
    </form>
</td>     
        </tr>
        <% }
        System.out.println("work");
        %>
    </table>
    <a href="food.jsp">Add New food</a>
</body>
</html>
