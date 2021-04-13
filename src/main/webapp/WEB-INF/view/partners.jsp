<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 13.04.2021
  Time: 2:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib
        prefix="c"
        uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Partners</title>
</head>
<body>
<h1>Colleagues of <c:out value="${param.name}"/></h1>
<hr>
    <ul>
        <c:if test="${empty requestScope.partners}">
            No one played with <c:out value="${param.name}"/> yet!<br>
        </c:if>
        <c:forEach var="partner" items="${requestScope.partners}">
            <li><c:out value="${partner.value}"/></li>
        </c:forEach>
    </ul>
</body>
</html>

