<%--
  Created by IntelliJ IDEA.
  amodel.User: kfrak
  Date: 15.12.2018
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="form" method="post" modelAttribute="loginForm">
    <p>
        Log in:
    <p>${errors}</p>
    <input type="text" name="username" placeholder="username">
    <input type="text" name="password" placeholder="password">
    <button name="login_button">Zaloguj</button>
    </p>
</form>

</body>
</html>
