<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24.11.2020
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employee</title>
    <link rel="stylesheet" href="<c:url value = "/resources/css/creation_form.css"/>"/>
    <link rel="stylesheet" href="<c:url value = "/resources/css/company_list.css"/>"/>
    <link rel="stylesheet" href="<c:url value = "/resources/css/bootstrap.min.css"/>"/>
</head>
<body>
<nav class="navbar navbar-light navbar-expand-md navigation-clean" style="background-color: #8270c9;">
    <div class="container"><a class="navbar-brand" href="#" style="color: rgb(227,227,227);">${company_name}</a>
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
<div class="form-style-6">
    <form method="post">
        <div>
            <input type="hidden" name="id" />
        </div>
        <div>
            <input type="text" name="surname" value="surname" placeholder="Surname"/>
        </div>
        <div>
            <input type="text" name="name" value="name" placeholder="Name"/>
        </div>
        <div>
            <input type="text" name="patronymic" value="patronymic" placeholder="Patronymic"/>
        </div>
        <div>
            <input type="text" name="username" value="username" placeholder="Username"/>
        </div>
        <div>
            <input type="password" name="password" placeholder="Password"/>
        </div>
        <div>
            <input type="submit" value="Создать"></div>
    </form>
</div>
</body>
</html>
