<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/resources/web.css">
</head>
<body>

<form method="POST" name="loginForm" class="form-signin" action="/login">
    <h2 class="form-heading">Log in</h2>

    <input name="username" type="text" class="form-control" placeholder="Username"/>
    <input name="password" type="password" class="form-control" placeholder="Password"/>

    <button name="submit">Log In</button>

</form>

</body>
</html>
