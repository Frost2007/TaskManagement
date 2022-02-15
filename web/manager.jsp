<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="manager.UserManager" %>
<%@ page import="model.UserType" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="model.Task" %>
<%@ page import="manager.TaskManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title> USER PAGE</title>
</head>

<style>
    table th, td{
        border: 1px solid black;
        border-collapse: collapse;
        padding: 10px;
    }
</style>
<body>
<%
    List<User> allUsers = new UserManager().getAllUsers();

%>
<a href="/addUser.jsp"> ADD USER    </a> <br>
<a href="/addTask.jsp">  ADD TASK </a> <br>
<a href="index.jsp">  Log Out</a> <br>
<br>

All Users:
<table>

    <thead>
    <tr>
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
<br>
All TASKS:
<%
    List<Task> allTask = new TaskManager().getAllTasks();
%>
<table>

    <thead>
    <tr>
        <th>task_name</th>
        <th>description</th>
        <th>deadline</th>
        <th>status</th>
        <th>user id</th>
    </tr>
    </thead>
    <% SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        for (Task task: allTask) {%>
    <tr>
        <td><%=task.getTaskName()%></td>
        <td><%=task.getDescription()%></td>
        <td><%=sdf.format(task.getDeadline())%></td>
        <td><%=task.getStatus().name()%></td>
        <td><%=task.getUser().getName() + " " + task.getUser().getSurname()%></td>
<%--        <td><a href="/deleteTask?id=<%=task.getId()%>" >Delete</a></td>--%>
    </tr>

    <% }

    %>

</table>


</body>
</html>
