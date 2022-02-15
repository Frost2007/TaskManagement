<%@ page import="model.Task" %>
<%@ page import="java.util.List" %>
<%@ page import="manager.TaskManager" %>
<%@ page import="java.text.SimpleDateFormat" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TASK</title>
</head>
<style>
    table th, td{
        border: 1px solid black;
        border-collapse: collapse;
        padding: 10px;
    }
</style>
<body>
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
        <td><a href="/changeTaskStatus?id=<%=task.getId()%>" >Change</a></td>
    </tr>

    <% }

    %>

</table>
</body>
</html>
