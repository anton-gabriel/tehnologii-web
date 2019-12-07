package servlet;

import model.User;
import repository.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * The type Login.
 */
@WebServlet(name = "login",
        urlPatterns = {"/login"},
        loadOnStartup = 1)
public class Login extends HttpServlet {

    /**
     * Instantiates a new Login.
     */
    public Login() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserRepository userRepository = new UserRepository();
        try {
            User login = userRepository.login(new User.UserBuilder(username).setPassword(password).build());
            if (login != null) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("success.jsp");

                //sends the username to session
                //create the session
                req.getSession().setAttribute("user", username);
                requestDispatcher.forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
