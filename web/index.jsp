<%--
  Created by IntelliJ IDEA.
  User: Hovo
  Date: 13.02.2022
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div style="font-family: 'Comic Sans MS';
color: cornflowerblue;
text-align: center"


>
<h1 > THIS IS MAIN PAGE PLEASE LOG IN</h1>
<br>
</div>
<%--<form method="post" action="/login">--%>
<%--    Email   .:<input type="text" name="email"/><br/>--%>
<%--    Password:<input type="text" name="password"/><br/>--%>
<%--    <input type="submit" value="login"/>--%>
<%--</form>--%>
<div style="text-align: center">
    ADD USER:
    <form action="/login" method="post">

        <label for="email">Email:</label><br>
        <input type="email" name="email" id="email"><br>
        <label for="password">Password:</label><br>
        <input type="password" name="password" id="password"><br>
        <br>
        <input type="submit" value="Login">
    </form>
</div>

</body>
</html>
