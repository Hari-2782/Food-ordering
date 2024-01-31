<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="impl.Dishinterface" %>
<%@ page import="model.Dishe" %>
<%@ page import ="database.Dishimpl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <form method="POST" action="Updatedish">
        <!-- Dish ID (Read-only) -->
        <label for="name">Dish Id:</label>
        <input type="text" name="id" value="<%= ((Dishe)request.getAttribute("d")).getDishid()%>" readonly/>
        <br><br>
        <!-- Dish Name -->
        <label for="name">Dish Name:</label>
        <input type="text" id="name" name="name" value=<%= ((Dishe)request.getAttribute("d")).getName() %>>
        <br><br>
        
        <!-- Price -->
        <label for="price">Price:</label>
        <input type="text" id="price" name="price" value=<%= ((Dishe)request.getAttribute("d")).getPrice() %>>
        <br><br>
        
    
        
        <!-- Description -->
        <label for="description">Description:</label>
       <input type="text" name="des" value="<%= ((Dishe)request.getAttribute("d")).getDesc()%>" />
        <br><br>
        
        <!-- Submit Button -->
        <input type="submit" value="Save Changes">
    </form>
</body>
</body>
</html>