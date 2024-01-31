<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Delivery" %>
<%@page import="database.Deliveryimpl" %>
<%@page import="impl.Deliveryinterface" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delivery List</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Delivery person</a></li>
			</ul>
		</nav>
	</header>
	<br>
    <h1>Delivery List</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Actions</th>
        </tr>
        <% Deliveryinterface dimpl=new Deliveryimpl();
        ArrayList<Delivery> listUser = dimpl.getdetails(); %>
        <% for (Delivery del : listUser) { %>
            <tr>
                <td><%= del.getID() %></td>
                <td><%= del.getName() %></td>
                <td><%= del.getEmail() %></td>
                <td><%= del.getPhone() %></td>
                <td><%= del.getAddress() %></td>
                <td>
                   <a href="edit?id=<%= del.getID() %>">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;
               <a href="delete?id=<%= del.getID() %>">Delete</a>
                </td>
            </tr>
        <% } %>
    </table>
    <a href="<%= request.getContextPath() %>/new">Add New Delivery</a>
</body>
</html>
