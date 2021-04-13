<%@ taglib
        prefix="c"
        uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Main page</title>
</head>
<body>
    <br/>
    <h2><a href="actors">All actors</a></h2>
    <h2><a href="unemployed">Unemployed actors</a></h2>
    <h2><a href="bestmovie">Movie with max actors cast</a></h2>

    <form action="partners" method="post">
        <h2>Search for actors who played with: <input type="text" name="name"/>
        <input type="submit" value="Find"/></h2>
    </form>
</body>
</html>