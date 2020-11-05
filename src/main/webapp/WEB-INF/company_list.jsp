<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 04.11.2020
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список клиентов</title>
</head>
<body>
<form action="/create_company" method="get">
    <button type="submit">Создать</button>
</form>
<table id="list">
    <tr>
        <th>№</th>
        <th>Название</th>
        <th>Администратор</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${companies}" var="company">
        <tr>
            <td>${company.id}</td>
            <td>${company.name}</td>
            <td>${company.admin.username}</td>
            <td>
                <button class="table-button" href="/edit/${c.id}">Изменить</button>
            </td>
            <td>
                <button class="table-button" href="/delete/${c.id}">Удалить</button>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
