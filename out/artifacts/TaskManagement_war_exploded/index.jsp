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

<h1 style="color: cornflowerblue;
font-family: Calibri;
align-self: center">MAIN PAGE
    <br>
    PLEASE LOG IN</h1>
<br>
<form method="post" action="login">
    Email   .:<input type="text" name="email"/><br/>
    Password:<input type="text" name="pass"/><br/>
    <input type="submit" value="login" formaction="/welcome.jsp"/>
</form>


</body>
</html>
