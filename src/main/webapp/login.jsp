<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
</body>
  <div class="form-container">
            <form action="Loginserverlet" method="POST">
              <p class ="p1" >User Login</p>
          <input name="uid"  type="text"  placeholder="Username" required>
          <input name="pass"  type="text" placeholder="Password" required>
          
          <input  type="submit" value="Login"/><br>
          
          <p class ="p2"> <a class="form__link" href="reg.jsp">Create your account</a></p>
       
            </form>
        </div>

</html>