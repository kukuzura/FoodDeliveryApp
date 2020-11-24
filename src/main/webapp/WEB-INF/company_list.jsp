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
    <link rel="stylesheet" href="<c:url value = "/resources/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value = "/resources/css/Login-Form-Clean.css"/>"/>
</head>
<script>
    <%@include file="/WEB-INF/js/deleteCompany.js" %>
</script>
<body>


<nav class="navbar navbar-light navbar-expand-md navigation-clean" style="background-color: #8270c9;">
    <div class="container"><a class="navbar-brand" href="#" style="color: rgb(227,227,227);">Company Name</a>
        <button data-toggle="collapse" data-target="#navcol-1" class="navbar-toggler"><span class="sr-only">Toggle navigation</span><span
                class="navbar-toggler-icon"></span></button>
        <div
                class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav ml-auto">
                <li role="presentation" class="nav-item"><a class="nav-link active" href="#" style="color: #e3e3e3;">First
                    Item</a></li>
                <li role="presentation" class="nav-item"><a class="nav-link" href="#" style="color: #e3e3e3;">Second
                    Item</a></li>
                <li role="presentation" class="nav-item"><a class="nav-link" href="#" style="color: #e3e3e3;">Third
                    Item</a></li>
                <li class="nav-item dropdown"><a data-toggle="dropdown" aria-expanded="false"
                                                 class="dropdown-toggle nav-link" href="#" style="color: #e3e3e3;">Dropdown </a>
                    <div role="menu" class="dropdown-menu"><a role="presentation" class="dropdown-item" href="#">First
                        Item</a><a role="presentation" class="dropdown-item" href="#">Second Item</a><a
                            role="presentation" class="dropdown-item" href="#">Third Item</a></div>
                </li>
            </ul>
        </div>
    </div>
</nav>


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
