<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ryabtsev
  Date: 5/5/19
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Addition Input Form</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css" />
</head>
<body>

<form:form action="calculateResult" modelAttribute="arguments">
    First: <form:input path="first" />
    <br>
    Second: <form:input path="second" />
    <br>
    <%--Country:--%>
    <%--<form:select path="country">--%>
        <%--<form:option value="Russia" label="Russia" />--%>
        <%--<form:option value="France" label="France" />--%>
    <%--</form:select>--%>
    <%--<br>--%>
    <%--Programming Languages:--%>
    <%--<br>--%>
    <%--Java <form:checkbox path="programmingLanguages" value="Java" />--%>
    <%--C++ <form:checkbox path="programmingLanguages" value="C++" />--%>
    <%--php <form:checkbox path="programmingLanguages" value="php" />--%>
    <%--<br>--%>
    <input type="submit" value="Submit" />
</form:form>


</body>
</html>
