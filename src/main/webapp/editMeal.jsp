<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<html>
<head>
    <title>Edit Meal</title>
</head>
<body>
<h1>Edit Meal</h1>
<form method="post" action="meals">
    <input name="id" type="hidden" value="${meal.id}">
    <label for="description">Description</label>
    <input name="description" id="description" type="text" value="${meal.description}">
    <br>
    <label for="date">Date</label>
    <javatime:format value="${meal.dateTime}" pattern="yyyy-MM-dd" var="mealDate" />
    <input name="date" id="date" type="date" value="${mealDate}">
    <br>
    <label for="time">Time</label>
    <javatime:format value="${meal.dateTime}" pattern="hh:mm" var="mealTime" />
    <input name="time" id="time" type="time" value="${mealTime}">
    <br>
    <label for="calories">Calories</label>
    <input name="calories" id="calories" type="number" value="${meal.calories}">
    <br>
    <button type="submit">Save</button>
    <a type="button" href="meals">Back</a>
</form>

</body>
</html>
