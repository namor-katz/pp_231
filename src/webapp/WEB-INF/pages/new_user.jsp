<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add New User</title>
</head>
<body>
<div align="center">

    <h2>New User</h2>
    <form method="post" ACCEPT-CHARSET="UTF-8">
        Name: <br>
        <input type="text", name="name" placeholder="input name"><br>
        Password: <br>
        <input type="password" name="password"><br>
        Email: <br>
        <input type="text", name="email"><br>
        MaxWeigth: <br>
        <input type="text", name="maxweight"><br>
        <br>
        <p><select name="roles">
            <option>user</option>
            <option>admin</option>
        </select></p>
        <br>
        <input type="submit" value="Create!">

    </form>


    <jsp:include page="logout.jsp" />
</div>
</body>
</html>