package servlet;

import manager.UserManager;
import model.User;
import model.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addUser")
public class AddUserServlet extends HttpServlet {

    private final UserManager userManager = new UserManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String password = req.getParameter("password");
        String email= req.getParameter("email");
        UserType type = UserType.valueOf(req.getParameter("userType"));

        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        user.setEmail(email);
        user.setType(type);

        if (userManager.addUser(user)) {
            resp.sendRedirect("manager.jsp");
        }

    }
}
