<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 13.04.2021
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib
        prefix="c"
        uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Actors</title>
</head>
<body>
<h1>All actors</h1>
<hr>
<c:forEach var="actor" items="${requestScope.actors}">
    <h4><c:out value="${actor.name}"/></h4>
    <ul>
        <c:if test="${empty actor.movies}">
            This actor does not have any movies yet!<br>
        </c:if>
        <c:forEach var="movie" items="${actor.movies}">
            <li><c:out value="${movie.title}"/></li>
        </c:forEach>
    </ul>
</c:forEach>
</body>
</html>
