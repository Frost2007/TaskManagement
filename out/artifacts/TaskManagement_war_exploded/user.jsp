<%@ page import="model.UserType" %>
<%@ page import="model.Task" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="manager.TaskManager" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Hovo
  Date: 14.02.2022
  Time: 0:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> USER PAGE</title>
</head>
USER PAGE <br>
<a href="index.jsp"> log out</a>
<body>
<h3>WELCOME user:  <%= request.getAttribute("name") + " " + request.getAttribute("surname")%>
</h3>
<br>
<br>
YOUR TASKS:
<%
    List<Task> allTask = new TaskManager().getAllTasks();
%>
<table>
    <style>
        table th, td{
            border: 1px solid black;
            border-collapse: collapse;
            padding: 10px;
        }
    </style>
    <thead>
    <tr style="border-collapse: collapse">
        <th>task_name</th>
        <th>description</th>
        <th>deadline</th>
        <th>status</th>
        <th>user name</th>
        <th> change status</th>
    </tr>
    </thead>
    <% SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        for (Task task: allTask) {%>


    <tr >
        <% if (task.getUser().getEmail().equals(request.getParameter("email")) ){ %>

        <td><%=task.getTaskName()%></td>
        <td><%=task.getDescription()%></td>
        <td><%=sdf.format(task.getDeadline())%></td>
        <td><%=task.getStatus().name()%></td>
        <td><%=task.getUser().getName() + " " + task.getUser().getSurname()%></td>
        <td><a href="/change?id=<%=task.getId()%>" >Change</a></td>

        <% } %>

    </tr>

    <% }%>

</table>
</body>
</html>
