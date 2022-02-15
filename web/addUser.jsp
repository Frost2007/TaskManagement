<%--
  Created by IntelliJ IDEA.
  User: Hovo
  Date: 14.02.2022
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> ADD USER </title>

<body>
<div style="text-align: center">
    ADD USER:
    <form action="/addUser" method="post">
        <label for="name">Name:</label><br>
        <input type="text" name="name" id="name"><br>
        <label for="surname">Surname:</label><br>
        <input type="text" name="surname" id="surname"><br>
        <label for="email">Email:</label><br>
        <input type="email" name="email" id="email"><br>
        <label for="password">Password:</label><br>
        <input type="password" name="password" id="password"><br>
        <select name="userType" >
            <option value="USER">USER</option>
            <option value="MANAGER">MANAGER</option>
        </select><br>
        <input type="submit" value="ADD USER">
    </form>
</div>
</head>
</body>
</html>
