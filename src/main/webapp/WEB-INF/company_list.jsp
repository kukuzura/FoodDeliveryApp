<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 04.11.2020
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список клиентов</title>
</head>
<script>
    <%@include file="/WEB-INF/js/deleteCompany.js" %>
</script>
<body>
<form action="/create_company" method="get">
    <button type="submit">Создать</button>
</form>
<h2>Customer companies</h2>
<table id="list1">
    <tr>
        <th>№</th>
        <th>Название</th>
        <th>Администратор</th>
        <th>Тип</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${customerCompanies}" var="company">
        <tr id="${company.id}">
            <td>${company.id}</td>
            <td>${company.name}</td>
            <td>${company.admin.username}</td>
            <td>
                <button class="table-button" href="/edit/${c.id}">Изменить</button>
            </td>
            <td>
                    <button  onclick="deleteCompany(${company.id},'CUSTOMER')"  class="table-button">Удалить</button>
            </td>
        </tr>
    </c:forEach>
</table>
<h2>Delivery companies</h2>
<table id="list2">
    <tr>
        <th>№</th>
        <th>Название</th>
        <th>Администратор</th>
        <th>Тип</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${foodCompanies}" var="company">
        <tr id=${company.id}>
            <td>${company.id}</td>
            <td>${company.name}</td>
            <td>${company.admin.username}</td>
            <td>
                <button class="table-button" href="/edit/${c.id}">Изменить</button>
            </td>
            <td>
                    <button onclick="deleteCompany(${company.id},'FOOD')" class="table-button">Удалить</button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
