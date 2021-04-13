<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 13.04.2021
  Time: 2:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib
        prefix="c"
        uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Best movies</title>
</head>
<body>
<h1>Movie(s) with max actors cast</h1>
<hr>
<c:forEach var="movie" items="${requestScope.movies}">
    <h4><c:out value="${movie.title}"/></h4>
    <ul>
        <c:forEach var="actor" items="${movie.actors}">
            <li><c:out value="${actor.name}"/></li>
        </c:forEach>
    </ul>
</c:forEach>
</body>
</html>
