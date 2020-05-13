<%@ page import="java.util.*" %>
<%@ page import="web.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User Detail info</title>
</head>
<body>
<h2>This user detail</h2>
<p>I have id = <c:out value="${user.id}" /> </p>
<p> My name is  <c:out value="${user.name}" /> </p>
<p>My email is  <c:out value="${user.email}" /> </p>
<p>My weight ==  <c:out value="${user.maxweight}" />  </p>

<jsp:include page="logout.jsp" />
</body>
</html>
