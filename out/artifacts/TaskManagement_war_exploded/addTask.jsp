<%@ page import="java.util.List" %>
<%@ page import="model.Task" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.User" %>
<%@ page import="manager.UserManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
    <title>Add task</title>
</head>
<body>

<% List<User> users = new UserManager().getAllUsers();%>

<div style="text-align: center">
    ADD TASK:
    <form action="/addTask" method="post">
        <label for="task_name">Task name:</label><br>
        <input type="text" name="taskName" id="task_name"><br>
        <label for="description">Description:</label><br>
        <input type="text" name="description" id="description"><br>
        <label for="Deadline">Deadline:</label><br>
        <input type="date" name="Deadline" id="Deadline"><br>
        <select name="userEmail">
            <%for (User user : users) {%>
            <option value="<%=user.getEmail()%>"><%=user.getName() + " " + user.getSurname()%> </option>
            <%}%>
        </select>

        <br>
        <input type="submit" value="ADD TASK">
    </form>
</div>
<%--All TASKS:--%>
<%--<%--%>
<%--    List<Task> allTask = new ArrayList<>();--%>
<%--%>--%>
<%--<table>--%>

<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th>task_name</th>--%>
<%--        <th>description</th>--%>
<%--        <th>deadline</th>--%>
<%--        <th>status</th>--%>
<%--        <th>user id</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <%--%>
<%--        for (Task task: allTask) {%>--%>
<%--    <tr>--%>
<%--        <td><%=task.getTaskName()%></td>--%>
<%--        <td><%=task.getDescription()%></td>--%>
<%--        <td><%=task.getDeadline()%></td>--%>
<%--        <td><%=task.getStatus().name()%></td>--%>
<%--        <td><a href="/deleteTask?id=<%=task.getId()%>" >Delete</a></td>--%>
<%--    </tr>--%>

<%--    <% }--%>

<%--    %>--%>

<%--</table>--%>
</body>
</html>
