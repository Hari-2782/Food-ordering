<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Dish</title>
</head>
<body>
    <h1>Edit Dish</h1>
    
    <form method="POST" action="Adddish" enctype="multipart/form-data">
        <!-- Dish ID (Read-only) -->
     
        <!-- Dish Name -->
        <label for="name">Dish Name:</label>
        <input type="text" id="name" name="name">
        <br><br>
        
        <!-- Price -->
        <label for="price">Price:</label>
        <input type="text" id="price" name="price">
        <br><br>
        
        <!-- Photo URL -->
        <label for="pic" class="form-label"> Photo</label>
   <input type="file"  id="pic" placeholder="pic" name="pic">
        
        <!-- Description -->
        <label for="description">Description:</label>
        <textarea id="description" name="des" rows="4"></textarea>
        <br><br>
        
        <!-- Submit Button -->
        <input type="submit" value="Save Changes">
    </form>
</body>
</html>
