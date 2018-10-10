<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
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
            <tr style="background-color: ${meal.exceed ? 'Red' : 'Green'}">
                <javatime:format value="${meal.dateTime}" pattern="yyyy-MM-dd hh:mm" var="parsedDate" />
                <td>${parsedDate}</td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td><a href="meals?mealId=${meal.id}">Edit Meal</a></td>
                <td><a href="meals?mealId=${meal.id}">Edit Meal</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
