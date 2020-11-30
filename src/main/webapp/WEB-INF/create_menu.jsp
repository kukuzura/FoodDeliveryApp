<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 28.11.2020
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create menu</title>
</head>
<body>
<form>
    <div class="table-responsive">
        <table id="list1" class="table">
            <tr>
                <th>№</th>
                <th>Название</th>
                <th>Описание</th>
                <th>Цена</th>
                <th>Выбран</th>
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
                        <input type="checkbox" value="${option.isChoose}"/>
                    </td>
<%--                    <td>--%>
<%--                        <button  onclick="deleteCompany(${company.id},'CUSTOMER')"  class="table-button btn btn-link rounded-0  d-flex align-self-center ">Удалить</button>--%>
<%--                    </td>--%>
                </tr>
            </c:forEach>
        </table>
    </div>
    <input type="submit" value="Сохранить">
</form>
</body>
</html>
