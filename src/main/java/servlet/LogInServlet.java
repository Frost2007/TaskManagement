package servlet;

import manager.TaskManager;
import manager.UserManager;
import model.Task;
import model.User;
import model.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LogInServlet extends HttpServlet {
    private final UserManager userManager = new UserManager();
    private final TaskManager taskManager = new TaskManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = userManager.getUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            if (user.getType().equals(UserType.MANAGER)) {
                req.setAttribute("name", user.getName());
                req.setAttribute("surname", user.getSurname());
                req.getRequestDispatcher("manager.jsp").forward(req, resp);
            }
            if (user.getType().equals(UserType.USER)) {
                List<Task> tasks = taskManager.getTaskByUserId(user);
                req.setAttribute("tasks",tasks);
                req.setAttribute("name", user.getName());
                req.setAttribute("surname", user.getSurname());

                req.getRequestDispatcher("user.jsp").forward(req, resp);
            }
        }
    }
}
