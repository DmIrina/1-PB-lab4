<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 13.04.2021
  Time: 1:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib
        prefix="c"
        uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actors without movies</title>
</head>
<body>
<hr>
<c:if test="${!requestScope.isUnemployed}">
    Every actor played at least in one film!
</c:if>
<c:choose>
    <c:when test="${!requestScope.isUnemployed}">
        <h3>Every actor played at least in one film!</h3>
    </c:when>
    <c:otherwise>
        <h3>There is at least one actor who did not played in movies :(</h3>
        <hr>
        <ul>
            <c:forEach var="actor" items="${requestScope.unemployed}">
                <li><c:out value="${actor.name}"/></li>
            </c:forEach>
        </ul>
    </c:otherwise>
</c:choose>
</body>
</html>
