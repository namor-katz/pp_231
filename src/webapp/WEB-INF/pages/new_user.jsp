<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>New User</title>
</head>
<body>
<div align="center">

    <h2>New User</h2>
    <form method="post">
        Name: <br>
        <input type="text", name="name"><br>
        Password: <br>
        <input type="password" name="password"><br>
        Email: <br>
        <input type="text", name="email"><br>
        MaxWeigth: <br>
        <input type="text", name="maxweight"><br>
        <br>
        <input type="submit" value="Create!">

    </form>


</div>
</body>
</html>