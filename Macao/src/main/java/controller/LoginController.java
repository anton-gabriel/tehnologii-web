package controller;

import model.User;
import repository.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginController implements Controller {

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) {
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
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
