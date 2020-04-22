<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: guest
  Date: 21.04.20
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

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
                <td><c:out value="${user.maxWeight}" /></td>
                <td>
                    <a href="/my_app_war/edit?id=<c:out value='${user.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/my_app_war/delete?id=<c:out value='${user.id}' />">Delete</a>
                </td>

            </tr>

        </c:forEach>
    </table>
</div>
</body>
</html>
