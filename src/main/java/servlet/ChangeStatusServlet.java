package servlet;

import manager.TaskManager;
import manager.UserManager;
import model.TaskStatus;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = ("/change"))
public class ChangeStatusServlet extends HttpServlet {

    TaskManager taskManager = new TaskManager();
    UserManager userManager = new UserManager();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        int id =  Integer.parseInt(idStr);
        taskManager.changeTaskStatusById(id, TaskStatus.FINISHED);
        User user = userManager.getUserByEmail(taskManager.getById(id).getUser().getEmail());

        req.setAttribute("name",user.getName());
        req.setAttribute("surname",user.getSurname());
        req.setAttribute("tasks",taskManager.getTaskByUserId(user));
        req.getRequestDispatcher("user.jsp").forward(req,resp);

    }
}
