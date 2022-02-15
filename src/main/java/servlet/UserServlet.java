package servlet;

import manager.TaskManager;
import model.Task;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    User user = new User();
    TaskManager taskManager = new TaskManager();
    List<Task> tasks = new ArrayList();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Task task : tasks) {
            if (req.getAttribute("email").equals(task.getUser().getEmail())){
                taskManager.getTaskByUserEmail(user);

            }resp.sendRedirect("user.jsp");
        }
    }
}
