package servlet;

import game.GameRoom;
import model.Game;
import model.User;
import repository.UserRepository;
import utils.GlobalInfo;
import utils.enums.GameStatus;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet(name = "startGame",
        urlPatterns = {"/startGame"})
public class StartGame extends HttpServlet {

    public StartGame() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect("login.jsp");
        }
        else {
            if (session.getAttribute("gameId") == null)
            {
                resp.sendRedirect("home.jsp");
            }
            else {
                UUID gameId = (UUID)session.getAttribute("gameId");
                GameStatus status = GameStatus.ACTIVE;
                GameRoom game = GlobalInfo.getGame(gameId);
                if (game != null)
                {
                    game.setStatus(status);
                    session.setAttribute("gameStatus", status);
                    resp.sendRedirect("gameActive.jsp");
                }
                else
                {
                    resp.sendRedirect("home.jsp");
                }
            }
        }
    }
}
