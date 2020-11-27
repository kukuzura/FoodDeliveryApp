<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24.11.2020
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu options</title>
    <link rel="stylesheet" href="<c:url value = "/resources/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value = "/resources/css/company_list.css"/>"/>
</head>
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
<form action="/" method="get">
    <button class="table-button btn rounded-0 align-self-center" type="submit">Создать</button>
</form>
<body>
<div class="table-responsive">
<table id="list1" class="table">
    <tr>
        <th>№</th>
        <th>Название</th>
        <th>Описание</th>
        <th>Цена</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${menu_options}" var="option">
        <tr id="${option.id}">
            <td>${option.id}</td>
            <td>${option.name}</td>
            <td>${option.description}</td>
            <td>${option.cost}</td>
            <td>
                <button  href="/employee/delete/${option.id}" class="table-button btn rounded-0  d-flex align-self-center">Удалить</button>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
