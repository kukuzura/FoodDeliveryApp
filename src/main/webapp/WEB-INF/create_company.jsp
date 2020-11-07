<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 05.11.2020
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Компании</title>
</head>
<body>
<div>
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
            <button class="btn btn-dark btn-block" type="submit">Log in</button>
        </div>
        <a class="forgot" href="#">Forgot your email or password?</a></form>
</div>
</body>
</html>
