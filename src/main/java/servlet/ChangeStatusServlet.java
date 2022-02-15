package servlet;

import manager.TaskManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;


@WebServlet(urlPatterns = ("/change"))
public class ChangeStatusServlet extends HttpServlet {

    TaskManager taskManager = new TaskManager();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        int id =  Integer.parseInt(idStr);
        taskManager.changeTaskStatusById(id);


        resp.sendRedirect("user.jsp");
    }
}
