<%--
  Created by IntelliJ IDEA.
  amodel.User: kfrak
  Date: 15.12.2018
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>your name is: ${username}</h3>


<form name="logout_form" method="post" action="logout">
    <p>
        Log out:
        <button type="submit" name="logout_button">wyloguj</button>
    </p>
</form>
</body>
</html>
