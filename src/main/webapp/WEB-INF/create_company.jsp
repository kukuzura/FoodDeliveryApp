<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 05.11.2020
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Компании</title>
    <link rel="stylesheet" href="<c:url value = "/resources/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value = "/resources/css/company_list.css"/>"/>
    <link rel="stylesheet" href="<c:url value = "/resources/css/creation_form.css"/>"/>
</head>

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
<div class="form-style-6">
    <form method="post" >
        <div>
            <input type="hidden" name="id" />
        </div>
        <select name="type">
            <option value="FOOD">Delivery Company</option>
            <option value="CUSTOMER">Customer Company</option>
        </select>
        <div>
            <input type="text" name="name" value="name" placeholder="Name"/>
        </div>
        <div>
            <input type="text" name="adminLogin" value="adminLogin" placeholder="Login"/>
        </div>
        <div>
            <input type="password" name="password" placeholder="Password"/>
        </div>
        <div>
<%--            <button class="btn btn-dark btn-block" type="submit">Log in</button>--%>
            <input type="submit" value="Создать">
        </div>
</div>
</body>
</html>
