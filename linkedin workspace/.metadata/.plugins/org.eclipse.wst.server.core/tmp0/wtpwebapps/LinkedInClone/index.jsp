<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Login Page</title>
</head>
<h1>Login Form</h1>
<p>Please enter a username and password to continue.</p>

<!-- The action attribute of an Authentication form must be 
"j_security_check"-->
<form action="AdministratorServlet" method="post">
    <label>email</label>
    
    <input type="text" name="email"><br>
    <label>Password</label>
    
    <input type="password" name="password"><br>
    <label>&nbsp;</label>
    <input type="submit" value="Login">
</form>
</body>
</html>
