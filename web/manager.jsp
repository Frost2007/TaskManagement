<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title> USER PAGE</title>
</head>
<body>
<%
    List<User> allUsers = (List<User>) request.getAttribute("allUsers");

%>

All Users:
<table border="1">

    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        <th>email</th>
        <th>user Type</th>
        <th>action</th>
    </tr>
   </thead>
    <%
        for (User user : allUsers) {%>
<tr>
    <td><%=user.getId()%></td>
    <td><%=user.getName()%></td>
    <td><%=user.getSurname()%></td>
    <td><%=user.getEmail()%></td>
    <td><%=user.getType().name()%></td>
    <td><a href="/deleteUser?id=<%=user.getId()%>" >Delete</a></td>
</tr>

    <% }

    %>

</table>
 <br>
ADD USER:<br>
<form action="/addUser" method="post" style="float: left">
    Name:      <input type="text" name="name"/> <br>
    Surname:   <input type="text" name="surname"/><br>
    email:     <input type="text" name="email"/><br>
    password:  <input type="text" name="password"/><br>
    user Type: <select name="userType">
    <option value="user">USER</option> <br>
    <option value="user">ADMIN</option> <br></select>
    <br>
    <input type="submit" value="ADD USER">
</form>

</body>
</html>
