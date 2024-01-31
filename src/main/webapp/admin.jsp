<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="database.Dishimpl" %>
  <%@ page import="database.Deliveryimpl" %>
    <%@ page import="database.Usermethod" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <% int dishCount1 = Dishimpl.printcount();%>
    <% int dishCount2 =Deliveryimpl.printcount();%>
    <% int dishCount3 =Usermethod.printcount();%>
    <p>Number of dishes in the database: <%= dishCount1 %></p>
    <p>Number of delivery person in the database: <%= dishCount2 %></p>
    <p>Number of customer in the database: <%= dishCount3 %></p>
</body>
</html>