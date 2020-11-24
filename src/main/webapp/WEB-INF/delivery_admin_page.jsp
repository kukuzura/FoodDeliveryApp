<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24.11.2020
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Delivery</title>
</head>
<body>
<form action="/create_employee" method="get">
    <button type="submit">Создать</button>
</form>
<table id="list1">
    <tr>
        <th>№</th>
        <th>Логин</th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Отчество</th>
        <th>Должность</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr id="${employee.id}">
            <td>${employee.id}</td>
            <td>${employee.user.username}</td>
            <td>${employee.surname}</td>
            <td>${employee.name}</td>
            <td>${employee.patronymic}</td>
            <td>${employee.post}</td>
            <td>
                <button class="table-button" href="/employee/edit/${employee.id}">Изменить</button>
            </td>
            <td>
                <button  href="/employee/delete/${employee.id}" class="table-button">Удалить</button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
