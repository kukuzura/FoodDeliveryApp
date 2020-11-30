<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 29.11.2020
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Create Order</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
    <script>
        <%@include file="/WEB-INF/js/jquery.min.js" %>
    </script>
    <script>
        <%@include file="/WEB-INF/js/send_order.js" %>
    </script>
</head>
<body>
<form:form method="post" id="order_form" modelAttribute="orderDTO">
    <form:input path="orderDate" type="date"/>
    <c:forEach items="${orderDTO.menuOptions}" var="menu_option" varStatus="j">
        <c:if test="${orderDTO.menuOptions[j.index].companyName != orderDTO.menuOptions[j.index-1].companyName}">
            <h2>${menu_option.companyName}</h2>
        </c:if>
        <table>
            <tr id="${menu_option.id}">
                <td><form:input type="hidden" value="${menu_option.id}"
                                path="menuOptions[${j.index}].id"/></td>
                <td><form:input type="text" value="${menu_option.name}"
                                path="menuOptions[${j.index}].name"/></td>
                <td><form:input type="text" value="${menu_option.description}"
                                path="menuOptions[${j.index}].description"/></td>
                <td><form:input type="text" value="${menu_option.cost}"
                                path="menuOptions[${j.index}].cost"/></td>
                <td><form:input type="number" value="${menu_option.amount}"
                                path="menuOptions[${j.index}].amount"/></td>
                <td><form:input type="hidden" value="${menu_option.id}"
                                path="menuOptions[${j.index}].companyName"/></td>
            </tr>
        </table>
    </c:forEach>
    <input type="submit" value="Заказать">
</form:form>
</body>
</html>
