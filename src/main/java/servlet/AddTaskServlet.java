package servlet;

import manager.TaskManager;
import manager.UserManager;
import model.Task;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(urlPatterns = "/addTask")
public class AddTaskServlet extends HttpServlet {

    private final TaskManager taskManager = new TaskManager();
    private final UserManager userManager = new UserManager();

    String date = "yyyy-MM-DD";
    SimpleDateFormat sdf = new SimpleDateFormat(date);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskName = req.getParameter("taskName");
        String description = req.getParameter("description");
        Date deadline = null;
        try {
            deadline = sdf.parse(req.getParameter("Deadline"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user = userManager.getUserByEmail(req.getParameter("userEmail"));


        Task task = new Task();
        task.setTaskName(taskName);
        task.setDescription(description);
        task.setDeadline(deadline);
        task.setUser(user);

        if (taskManager.addTask(task)) {
            resp.sendRedirect("manager.jsp");
        }

    }
}
