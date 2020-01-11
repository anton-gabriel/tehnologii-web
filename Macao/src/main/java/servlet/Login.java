package servlet;

import game.Player;
import model.User;
import repository.UserRepository;
import utils.GameLogger;
import utils.constants.ApplicationConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;

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
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        GameLogger.getInstance().log(Level.INFO,
                String.format("%s servlet, %s method call", Login.class.getName(), methodName));

        // get request parameters for userID and password
        String username = req.getParameter("user");
        String pwd = req.getParameter("pwd");
        UserRepository userRepository = new UserRepository();
        User user = null;
        try {
            user = userRepository.login(new User.UserBuilder(username).setPassword(pwd).build());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("player", new Player(user));
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(ApplicationConstants.SESSION_TIMEOUT);
            resp.sendRedirect("home.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            PrintWriter out = resp.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(req, resp);
        }
    }
}
