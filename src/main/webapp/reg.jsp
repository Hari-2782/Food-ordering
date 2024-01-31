<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action=" Registerserverlet" method="POST">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone"><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="username">Username:</label>
        <input type="text" id="username" name="uname" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
    
        <input type="submit" value="Submit">
    </form>

</body>
</html>