<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div>
    <form:form method="POST" modelAttribute="userForm">

        Name: <br>
        <form:input type="text" path="name" placeholder="name" autofocus="true"></form:input>
        <form:errors path="username"></form:errors>
        ${usernameError}
        <br>
        Password: <br>
        <form:input type="password" path="password"></form:input>
    <br>
        Email: <br>
        <form:input type="text" path="email"></form:input><br>
        MaxWeigth: <br>
        <form:input type="text" path="maxweight" placeholder="maxweigth"></form:input>
    <br>
        Set role Admin?<br>
        <form:checkbox path="roles" value="admin"></form:checkbox>
<%--        <p><select name="roles">--%>
<%--            <option>user</option>--%>
<%--            <option>admin</option>--%>
<%--        </select></p>--%>
        <br>
        <button type="submit">Create!</button>

    </form:form>
</div>

    <jsp:include page="logout.jsp" />
</div>
</body>
</html>