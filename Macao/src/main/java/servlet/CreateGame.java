package servlet;

import game.GameRoom;
import game.Player;
import model.Game;
import model.User;
import repository.UserRepository;
import utils.GlobalInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "createGame",
        urlPatterns = {"/createGame"})
public class CreateGame extends HttpServlet {

    public CreateGame() {
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
            Player player = (Player) session.getAttribute("player");
            GameRoom game = new GameRoom(player);
            GlobalInfo.games.add(game);
            session.setAttribute("gameId", game.getId());
            resp.sendRedirect("game.jsp");
        }
    }


}
