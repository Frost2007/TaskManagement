<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title style="font-size: large"> USER PAGE</title>
</head>
<body>
<%
   List<User> allUsers = (List<User>) request.getAttribute("allUsers");

%>

All Users:
<table border="1">
<tr>
    <td>id</td>
    <td>name</td>
    <td>surname</td>
    <td>email</td>
    <td>user Type</td>
</tr>

</table>



</body>
</html>
