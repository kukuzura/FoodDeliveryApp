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
</head>
<body>
<div>
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
            <button class="btn btn-dark btn-block" type="submit">Save</button>
        </div>

</div>
</body>
</html>
