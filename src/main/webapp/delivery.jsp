 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.Delivery" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <form action="<%= (request.getAttribute("d") != null) ? "update" : "insert" %>" method="post">

                <caption>
                    <h2>
                        <%= (request.getAttribute("d") != null) ? "Edit deliveryperson" : "Add New deliveryperson" %>
                    </h2>
                </caption>

                <% if (request.getAttribute("d") != null) { %>
                    <input type="hidden" name="id" value="<%= ((Delivery)request.getAttribute("d")).getID() %>" />
                <% } %>

                <fieldset class="form-group">
                    <label>deliveryperson Name</label>
                    <input type="text" class="form-control" name="name" required="required"
                        value="<%= (request.getAttribute("d") != null) ? ((Delivery)request.getAttribute("d")).getName() : "" %>" />
                </fieldset>
                <fieldset class="form-group">
                    <label>deliveryperson Email</label>
                    <input type="text" class="form-control" name="email"
                        value="<%= (request.getAttribute("d") != null) ? ((Delivery)request.getAttribute("d")).getEmail() : "" %>" />
                </fieldset>
                <fieldset class="form-group">
                    <label>deliveryperson phone</label>
                    <input type="text" class="form-control" name="phone"
                        value="<%= (request.getAttribute("d") != null) ? ((Delivery)request.getAttribute("d")).getPhone() : "" %>" />
                </fieldset>
                <fieldset class="form-group">
                    <label>deliveryperson address</label>
                    <input type="text" class="form-control" name="address"
                        value="<%= (request.getAttribute("d") != null) ? ((Delivery)request.getAttribute("d")).getAddress() : "" %>" />
                </fieldset>

                <button type="submit" class="btn btn-success">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
