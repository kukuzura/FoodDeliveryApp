<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value=""/>


<html>

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no"/>
    <title>курсач</title>
    <link rel="stylesheet" href="<c:url value = "/resources/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value = "/resources/css/Login-Form-Clean.css"/>"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>

<body>
<div class="login-clean">
    <form method="post">
        <h2 class="sr-only">Login Form</h2>
        <div class="illustration"><img src="<c:url value = "/resources/images/icon.PNG"/>"></div>
        <div class="form-group"><input class="form-control" type="text"  name="username" placeholder="Login"/></div>
        <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Password"/>
        </div>
        <div class="form-group">
            <button class="btn btn-dark btn-block" type="submit">Log in</button>
        </div>
        <a class="forgot" href="#">Forgot your email or password?</a></form>
</div>
</body>

</html>