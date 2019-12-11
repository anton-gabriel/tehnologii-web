package servlet;

import game.GameRoom;
import game.Player;
import model.Game;
import model.User;
import repository.UserRepository;
import utils.GlobalInfo;
import utils.enums.GameStatus;
import utils.enums.PlayerStatus;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet(name = "joinGame",
        urlPatterns = {"/joinGame"})
public class JoinGame extends HttpServlet {

    public JoinGame() {
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
        else if (session.getAttribute("gameId") != null)
        {
            resp.sendRedirect("game.jsp");
        }
        else {
            UUID gameId = UUID.fromString(req.getParameter("gameId"));
            Player player = (Player) session.getAttribute("player");

            GameRoom game = GlobalInfo.getGame(gameId);

            if(game.getStatus() == GameStatus.INACTIVE) {
                game.addPlayer(player);
                player.setStatus(PlayerStatus.ATTENDING);
                session.setAttribute("gameId", gameId);
                resp.sendRedirect("game.jsp");
            } else if(game.getStatus() == GameStatus.ACTIVE) {
                game.getSpectators().add(player);
                player.setStatus(PlayerStatus.SPECTATING);
                session.setAttribute("gameId", gameId);
                resp.sendRedirect("game.jsp");
            } else
            {
                //Nothing
            }

        }
    }
}
