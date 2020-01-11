package servlet;

import utils.GameLogger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;

/**
 * The type Logout.
 */
@WebServlet(name = "logout",
        urlPatterns = {"/logout"})
public class Logout extends HttpServlet {

    /**
     * Instantiates a new Logout.
     */
    public Logout() {
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
                String.format("%s servlet, %s method call", Logout.class.getName(), methodName));

        resp.setContentType("text/html");
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        resp.sendRedirect("login.jsp");
    }


}
