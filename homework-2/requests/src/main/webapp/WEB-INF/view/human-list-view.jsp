<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ryabtsev
  Date: 5/5/19
  Time: 10:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Humans List View</title>
</head>
<body>
    <h1>Humans List View</h1>
    <ul>
        <c:forEach var="item" items="${humans}">
            <li>${item}</li>
        </c:forEach>
    </ul>
</body>
</html>
