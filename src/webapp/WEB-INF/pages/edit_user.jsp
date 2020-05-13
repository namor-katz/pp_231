<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<h2>This user from edit</h2>

<form method="post" accept-charset="UTF-8">
    <p>name</p>
    <p> <input type="text" name="name" value="<c:out value='${user.name}' />" />  </p>
    <p>email</p>
    <p><input type="text" name="email" value="<c:out value='${user.email}' />" /> </p>
    <p>maxWeight</p>
    <p><input type="text" name="maxweight" value="<c:out value='${user.maxweight}' />" > </p>
    <input type="hidden" name="id" value="<c:out value='${user.id}' /> " />
    <p><input type="submit" value="edit!"></p>
</form>

</body>
