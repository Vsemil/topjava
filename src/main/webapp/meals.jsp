<%@ page import="java.util.List" %>
<%@ page import="ru.javawebinar.topjava.model.MealWithExceed" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<%
    List<MealWithExceed> meals =(List<MealWithExceed>)request.getAttribute("meals");
    SimpleDateFormat localDateTimeFormat =(SimpleDateFormat)request.getAttribute("localDateTimeFormat");
%>
<h3><a href="index.html">Home</a></h3>
<h3>Meals</h3>
<table border="1">
    <thead>
    <tr>
        <th>Время</th>
        <th>Описание</th>
        <th>Коллории</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="meal" items="${meals}">
            <tr>
                <td>${localDateTimeFormat.parse(meal.dateTime)}</td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
