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
    <link rel="stylesheet" href="<c:url value = "/resources/css/company_list.css"/>"/>
</head>
<script>
    <%@include file="/WEB-INF/js/deleteCompany.js" %>
</script>
<body>


<nav class="navbar navbar-light navbar-expand-md navigation-clean" style="background-color: #8270c9;">
    <div class="container"><a class="navbar-brand" href="#" style="color: rgb(227,227,227);"></a>
        <button data-toggle="collapse" data-target="#navcol-1" class="navbar-toggler"><span class="sr-only">Toggle navigation</span><span
                class="navbar-toggler-icon"></span></button>
        <div
                class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav ml-auto">
                <li role="presentation" class="nav-item"><a class="nav-link active" href="/create_company" style="color: #e3e3e3;">Создать                    </a></li>
                <li role="presentation" class="nav-item"><a class="nav-link" href="/customer_company_list" style="color: #e3e3e3;">Список клиентов
                    </a></li>
                <li role="presentation" class="nav-item"><a class="nav-link" href="/delivery_company_list" style="color: #e3e3e3;">Компании доставки
                    </a></li>
                <li role="presentation" class="nav-item"><a class="nav-link" href="/logout" style="color: #e3e3e3;">Выйти
                </a></li>
            </ul>
        </div>
    </div>
</nav>


<h2>Компании-клиенты</h2>
<div class="table-responsive">
<table id="list1" class="table">
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
                <a class="table-button btn rounded-0 align-self-center " href="/editCompany/CUSTOMER/${company.id}">Редактировать</a>
            </td>
            <td>
                <button  onclick="deleteCompany(${company.id},'CUSTOMER')"  class="table-button btn btn-link rounded-0  d-flex align-self-center ">Удалить</button>
            </td>
        </tr>
    </c:forEach>
</table>
</div>


</body>
</html>
