<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>
<h2 align="center"><a href="/new">Add new user</a></h2>
<h3></h3>
<div align="center">
    <table border="1" cellpadding="5">
        <caption>sumo wrestlers</caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>MaxWeight</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${list}">
            <tr>
                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.name}" /></td>
                <td><c:out value="${user.email}" /></td>
                <td><c:out value="${user.maxweight}" /></td>
                <td>
                    <a href="/edit?id=<c:out value='${user.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=<c:out value='${user.id}' />">Delete</a>
                </td>

            </tr>

        </c:forEach>
    </table>
    <jsp:include page="logout.jsp" />
</div>
</body>
</html>
