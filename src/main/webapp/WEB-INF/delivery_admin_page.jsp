<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24.11.2020
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<html>
<head>
    <title>Admin Delivery</title>
    <link rel="stylesheet" href="<c:url value = "/resources/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value = "/resources/css/company_list.css"/>"/>
</head>
<script>
    <%@include file="/WEB-INF/js/deleteDeliveryEmployee.js" %>
</script>
<body>

<nav class="navbar navbar-light navbar-expand-md navigation-clean" style="background-color: #8270c9;">
    <div class="container"><a class="navbar-brand" href="#" style="color: rgb(227,227,227);"></a>
        <button data-toggle="collapse" data-target="#navcol-1" class="navbar-toggler"><span class="sr-only">Toggle navigation</span><span
                class="navbar-toggler-icon"></span></button>
        <div
                class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav ml-auto">
                <li role="presentation" class="nav-item"><a class="nav-link active" href="/delivery_admin" style="color: #e3e3e3;">Список работников</a></li>
                <li role="presentation" class="nav-item"><a class="nav-link" href="/menu_options" style="color: #e3e3e3;">Позиции меню</a></li>
                <li role="presentation" class="nav-item"><a class="nav-link" href="/logout" style="color: #e3e3e3;">Выйти
                </a></li>
            </ul>
        </div>
    </div>
</nav>

<form action="/create_employee" method="get">
    <button class="table-button btn rounded-0 align-self-center" type="submit">Создать</button>
</form>
<div class="table-responsive">
<table id="list1" class="table">
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
                <a class="table-button btn rounded-0 align-self-center" href="/employee/edit/${employee.id}">Изменить</a>
            </td>
            <td>
                <button onclick="deleteDeliveryEmployee(${employee.id})" class="table-button btn rounded-0 align-self-center">
                    Удалить</button>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
